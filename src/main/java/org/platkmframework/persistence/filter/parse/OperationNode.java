package org.platkmframework.persistence.filter.parse;

public class OperationNode implements Node {

    public enum Type {

        AND,
        OR,
        LESS,
        GREATER,
        EQUALS,
        LESS_EQUALS,
        GREATER_EQUALS,
        LIKE,
        IN
    }

    /**
     * Atributo type
     */
    private Type type;

    /**
     * Atributo leftChild
     */
    private Node leftChild;

    /**
     * Atributo rightChild
     */
    private Node rightChild;

    /**
     * Constructor OperationNode
     * @param type type
     * @param leftChild leftChild
     * @param rightChild rightChild
     */
    OperationNode(Type type, Node leftChild, Node rightChild) {
        this.type = type;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * getType
     * @return Type
     */
    public Type getType() {
        return type;
    }

    /**
     * getLeftChild
     * @return Node
     */
    public Node getLeftChild() {
        return leftChild;
    }

    /**
     * getRightChild
     * @return Node
     */
    public Node getRightChild() {
        return rightChild;
    }
}
