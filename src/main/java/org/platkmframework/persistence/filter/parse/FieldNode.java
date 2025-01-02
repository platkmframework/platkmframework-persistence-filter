package org.platkmframework.persistence.filter.parse;

public class FieldNode implements Node {

    /**
     * Atributo name
     */
    private String name;

    /**
     * Constructor FieldNode
     * @param name name
     */
    FieldNode(String name) {
        this.name = name;
    }

    /**
     * getName
     * @return String
     */
    public String getName() {
        return name;
    }
}
