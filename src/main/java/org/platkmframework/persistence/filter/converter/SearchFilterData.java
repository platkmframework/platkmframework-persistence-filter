package org.platkmframework.persistence.filter.converter;

import java.util.Map;

public class SearchFilterData {

    /**
     * Atributo fastsearch
     */
    private String fastsearch;

    /**
     * Atributo defaultOrderColumn
     */
    private String defaultOrderColumn;

    /**
     * Atributo defaultOrderType
     */
    private String defaultOrderType;

    /**
     * Atributo searchMap
     */
    private Map<String, SearchFilterConditionData> searchMap;

    /**
     * Constructor SearchFilterData
     * @param fastsearch fastsearch
     * @param defaultOrderColumn defaultOrderColumn
     * @param defaultOrderType defaultOrderType
     */
    public SearchFilterData(String fastsearch, String defaultOrderColumn, String defaultOrderType) {
        super();
        this.fastsearch = fastsearch;
        this.defaultOrderColumn = defaultOrderColumn;
        this.defaultOrderType = defaultOrderType;
    }

    /**
     * getFastsearch
     * @return String
     */
    public String getFastsearch() {
        return fastsearch;
    }

    /**
     * setFastsearch
     * @param fastsearch fastsearch
     */
    public void setFastsearch(String fastsearch) {
        this.fastsearch = fastsearch;
    }

    /**
     * getSearchMap
     * @return Map
     */
    public Map<String, SearchFilterConditionData> getSearchMap() {
        return searchMap;
    }

    /**
     * setSearchMap
     * @param searchMap searchMap
     */
    public void setSearchMap(Map<String, SearchFilterConditionData> searchMap) {
        this.searchMap = searchMap;
    }

    /**
     * getDefaultOrderColumn
     * @return String
     */
    public String getDefaultOrderColumn() {
        return defaultOrderColumn;
    }

    /**
     * setDefaultOrderColumn
     * @param defaultOrderColumn defaultOrderColumn
     */
    public void setDefaultOrderColumn(String defaultOrderColumn) {
        this.defaultOrderColumn = defaultOrderColumn;
    }

    /**
     * getDefaultOrderType
     * @return String
     */
    public String getDefaultOrderType() {
        return defaultOrderType;
    }

    /**
     * setDefaultOrderType
     * @param defaultOrderType defaultOrderType
     */
    public void setDefaultOrderType(String defaultOrderType) {
        this.defaultOrderType = defaultOrderType;
    }
}
