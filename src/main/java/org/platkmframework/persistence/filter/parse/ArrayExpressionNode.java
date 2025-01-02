package org.platkmframework.persistence.filter.parse;

public class ArrayExpressionNode implements Node {

    /**
     * Atributo value
     */
    private Object value;

    /**
     * Constructor ArrayExpressionNode
     * @param value value
     */
    ArrayExpressionNode(Object value) {
        this.value = value;
    }

    /**
     * getValue
     * @return Object
     */
    public Object getValue() {
        return value;
    }
}
