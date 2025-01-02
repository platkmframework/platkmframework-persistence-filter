package org.platkmframework.persistence.filter.converter;

public class SearchFilterConditionData {

    /**
     * Atributo label
     */
    String label;

    /**
     * Atributo code
     */
    String code;

    /**
     * Atributo column
     */
    String column;

    /**
     * Constructor SearchFilterConditionData
     * @param label label
     * @param code code
     * @param column column
     */
    public SearchFilterConditionData(String label, String code, String column) {
        super();
        this.label = label;
        this.code = code;
        this.column = column;
    }

    /**
     * getLabel
     * @return String
     */
    public String getLabel() {
        return label;
    }

    /**
     * setLabel
     * @param label label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * getCode
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     * setCode
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * getColumn
     * @return String
     */
    public String getColumn() {
        return column;
    }

    /**
     * setColumn
     * @param column column
     */
    public void setColumn(String column) {
        this.column = column;
    }
}
