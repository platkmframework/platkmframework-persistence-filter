package org.platkmframework.persistence.filter.parse;

public class LiteralNode implements Node {

    /**
     * Atributo value
     */
    private Object value;

    /**
     * Constructor LiteralNode
     * @param value value
     */
    LiteralNode(Object value) {
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
