package org.platkmframework.persistence.filter.parse;

public class ParenthesisNode implements Node {

    public enum Type {

        OPEN, CLOSE
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
     * Constructor ParenthesisNode
     * @param leftChild leftChild
     * @param type type
     * @param rightChild rightChild
     */
    ParenthesisNode(Node leftChild, Type type, Node rightChild) {
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
