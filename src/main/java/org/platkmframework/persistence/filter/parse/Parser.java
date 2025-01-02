package org.platkmframework.persistence.filter.parse;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.platkmframework.persistence.filter.exception.FilterException;
import org.platkmframework.util.Util;

public class Parser {

    /**
     * Atributo tokenizer
     */
    private StreamTokenizer tokenizer;

    /**
     * parse
     * @param expr expr
     * @return Node
     * @throws FilterException FilterException
     */
    public static Node parse(String expr) throws FilterException {
        try {
            StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(expr));
            // Don't parse minus as part of numbers.
            tokenizer.ordinaryChar('-');
            // Don't parse slash as part of numbers.
            tokenizer.ordinaryChar('/');
            // Don't parse slash as part of numbers.
            tokenizer.wordChars('_', '_');
            tokenizer.nextToken();
            Parser parser = new Parser(tokenizer);
            Node result = parser.parseExpression();
            if (tokenizer.ttype != StreamTokenizer.TT_EOF) {
                throw new FilterException("EOF expected, got" + tokenizer.ttype + "/" + tokenizer.sval);
            }
            return result;
        } catch (IOException e) {
            throw new FilterException(e.getMessage());
        }
    }

    /**
     * Constructor Parser
     * @param tokenizer tokenizer
     */
    private Parser(StreamTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    /**
     * parseExpression
     * @return Node
     * @throws IOException IOException
     */
    private Node parseExpression() throws IOException {
        Node left = parseAnd();
        if (tokenizer.ttype == StreamTokenizer.TT_WORD && tokenizer.sval.equalsIgnoreCase("OR")) {
            tokenizer.nextToken();
            return new OperationNode(OperationNode.Type.OR, left, parseExpression());
        }
        return left;
    }

    /**
     * parseAnd
     * @return Node
     * @throws IOException IOException
     */
    private Node parseAnd() throws IOException {
        Node left = parseRelational();
        if (tokenizer.ttype == StreamTokenizer.TT_WORD && tokenizer.sval.equalsIgnoreCase("AND")) {
            tokenizer.nextToken();
            return new OperationNode(OperationNode.Type.AND, left, parseAnd());
        }
        return left;
    }

    /**
     * parseRelational
     * @return Node
     * @throws IOException IOException
     */
    private Node parseRelational() throws IOException {
        Node left = parsePrimary();
        OperationNode.Type type;
        int t;
        switch(tokenizer.ttype) {
            case '<':
                t = tokenizer.nextToken();
                switch(t) {
                    case '=':
                        type = OperationNode.Type.LESS_EQUALS;
                        break;
                    default:
                        tokenizer.pushBack();
                        type = OperationNode.Type.LESS;
                        break;
                }
                break;
            case '=':
                type = OperationNode.Type.EQUALS;
                break;
            case '>':
                t = tokenizer.nextToken();
                switch(t) {
                    case '=':
                        type = OperationNode.Type.GREATER_EQUALS;
                        break;
                    default:
                        tokenizer.pushBack();
                        type = OperationNode.Type.GREATER;
                        break;
                }
                break;
            default:
                if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
                    if (tokenizer.sval.equalsIgnoreCase("LIKE")) {
                        type = OperationNode.Type.LIKE;
                        break;
                    } else if (tokenizer.sval.equalsIgnoreCase("IN")) {
                        type = OperationNode.Type.IN;
                        break;
                    } else
                        return left;
                } else
                    return left;
        }
        tokenizer.nextToken();
        return new OperationNode(type, left, parseRelational());
    }

    /**
     * parsePrimary
     * @return Node
     * @throws IOException IOException
     */
    private Node parsePrimary() throws IOException {
        Node result;
        if (tokenizer.ttype == '(') {
            tokenizer.nextToken();
            if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                result = new ArrayExpressionNode(parseNumberArray());
            } else if (tokenizer.ttype == '\'') {
                result = new ArrayExpressionNode(parseStringArray());
            } else {
                result = new ParenthesisNode(new LiteralNode('('), ParenthesisNode.Type.OPEN, parseExpression());
                if (tokenizer.ttype != ')') {
                    throw new FilterException(") expected, got " + tokenizer.ttype + "/" + tokenizer.sval);
                }
                result = new ParenthesisNode(result, ParenthesisNode.Type.CLOSE, new LiteralNode(')'));
            }
        } else if (tokenizer.ttype == '"' || tokenizer.ttype == '\'') {
            result = new LiteralNode(tokenizer.sval);
        } else if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
            result = new LiteralNode(tokenizer.nval);
        } else if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
            result = new FieldNode(tokenizer.sval);
        } else {
            throw new FilterException("Unrecognized token: " + tokenizer.ttype + "/" + tokenizer.sval);
        }
        tokenizer.nextToken();
        return result;
    }

    /**
     * parseNumberArray
     * @return String
     * @throws IOException IOException
     */
    private String parseNumberArray() throws IOException {
        List<String> expression = new ArrayList<>();
        int maxArraySize = 200;
        boolean keepLoop = true;
        String currentType = "number";
        while (keepLoop && maxArraySize > expression.size()) {
            if (tokenizer.ttype == StreamTokenizer.TT_NUMBER && currentType.equals("number")) {
                expression.add(String.valueOf(tokenizer.nval));
                tokenizer.nextToken();
                maxArraySize++;
                currentType = "coma";
            } else if (tokenizer.ttype == ',' && currentType.equals("coma")) {
                tokenizer.nextToken();
                currentType = "number";
            } else if (tokenizer.ttype == ')') {
                keepLoop = false;
            } else
                throw new FilterException(" empty array");
        }
        if (expression.isEmpty())
            throw new FilterException(" empty array");
        return Util.listToStringComa(expression);
    }

    /**
     * parseStringArray
     * @return String
     * @throws IOException IOException
     */
    private String parseStringArray() throws IOException {
        List<String> expression = new ArrayList<>();
        int maxArraySize = 200;
        boolean keepLoop = true;
        String currentType = "word";
        while (keepLoop && maxArraySize > expression.size()) {
            if (tokenizer.ttype == '\'' && currentType.equals("word")) {
                expression.add(String.valueOf(tokenizer.sval));
                // final '
                tokenizer.nextToken();
                maxArraySize++;
                currentType = "coma";
            } else if (tokenizer.ttype == ',' && currentType.equals("coma")) {
                tokenizer.nextToken();
                currentType = "word";
            } else if (tokenizer.ttype == ')') {
                keepLoop = false;
            } else
                throw new FilterException(" empty array");
        }
        if (expression.isEmpty())
            throw new FilterException(" empty array");
        return Util.listToStringComa(expression);
    }
    /**
     * 	  public static final void main(String a[]) throws IOException {
     * 		  Parser.parse(" country_id_fk = 3 ");
     * 		  Parser.parse(" a = 8");
     * 		  Parser.parse(" a > b and c<q or x=b");
     * 		  Parser.parse(" a > b and (c<q or x=b)");
     * 		  Parser.parse("state in (65, 4,  8)"); //Node node =
     * 		  Parser.parse("state in (65, 4,  8) or (nombre like '%pedro')");
     * 		  Parser.parse("state in ('pedro', 'antonio', 'filomena')");
     * 		  Parser.parse(" a > b");
     * 		  Parser.parse(" a > b and (b=5 or g <= 8)");
     * 		  parse("a <= b and (a >= b AND state in (46)) or a = b or nombre like '%pedro' and state in (3,5,4)"
     * 		  );
     * 	  }
     */
}
