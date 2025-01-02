/**
 * ****************************************************************************
 *  Copyright(c) 2023 the original author Eduardo Iglesias Taylor.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  	 https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Contributors:
 *  	Eduardo Iglesias Taylor - initial API and implementation
 * *****************************************************************************
 */
package org.platkmframework.persistence.filter.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.platkmframework.persistence.filter.enumerator.ConditionOperator;
import org.platkmframework.persistence.filter.enumerator.InnerOperator;
import org.platkmframework.persistence.filter.enumerator.SqlOrder;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public class FilterData implements Serializable {

    /**
     * Atributo serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Atributo filterDataType
     */
    private FilterDataType filterDataType;

    //AddtionalDataInfo
    private String additional;

    /**
     * Atributo havingInfo
     */
    private String havingInfo;

    //ExpressionInfo
    private ConditionOperator expesionOperator;

    /**
     * Atributo column
     */
    private String column;

    /**
     * Atributo expesionValue
     */
    private Object expesionValue;

    /**
     * Atributo valueAsColumn
     */
    private boolean valueAsColumn = false;

    //FastSearchInfo
    private String fastsearch;

    /**
     * Atributo fastSearchList
     */
    private List<String> fastSearchList;

    //FromInfo
    private String from;

    /**
     * Atributo alias
     */
    private String alias;

    //GroupByInfo
    private String groupColumns;

    //JoinInfo
    private InnerOperator innerJoin;

    /**
     * Atributo table
     */
    private String table;

    /**
     * Atributo tableAlias
     */
    private String tableAlias;

    /**
     * Atributo using
     */
    private String using;

    //OffSetInfo
    //20; //by default //    = 0; //by default
    private int recordPerPage = 0;

    //20; //by default //    = 0; //by default
    private int page = 0;

    //SelectInfo
    private String selectColumns;

    //OrderByInfo
    private String orderColumn;

    /**
     * Atributo orderType
     */
    private SqlOrder orderType;

    /**
     * Atributo sqlOperator
     */
    private String sqlOperator;

    /**
     * Atributo value1
     */
    private Object value1, value2;

    /**
     * Constructor FilterData
     */
    public FilterData() {
        super();
    }

    /**
     * Constructor FilterData
     * @param filterDataType filterDataType
     */
    public FilterData(FilterDataType filterDataType) {
        this.filterDataType = filterDataType;
    }

    /**
     * getAdditional
     * @return String
     */
    public String getAdditional() {
        return additional;
    }

    /**
     * setAdditional
     * @param additional additional
     */
    public void setAdditional(String additional) {
        this.additional = additional;
    }

    /**
     * getFilterDataType
     * @return FilterDataType
     */
    public FilterDataType getFilterDataType() {
        return filterDataType;
    }

    /**
     * setFilterDataType
     * @param filterDataType filterDataType
     */
    public void setFilterDataType(FilterDataType filterDataType) {
        this.filterDataType = filterDataType;
    }

    /**
     * getExpesionOperator
     * @return ConditionOperator
     */
    public ConditionOperator getExpesionOperator() {
        return expesionOperator;
    }

    /**
     * setExpesionOperator
     * @param expesionOperator expesionOperator
     */
    public void setExpesionOperator(ConditionOperator expesionOperator) {
        this.expesionOperator = expesionOperator;
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

    /**
     * getExpesionValue
     * @return Object
     */
    public Object getExpesionValue() {
        return expesionValue;
    }

    /**
     * getSqlOperator
     * @return String
     */
    public String getSqlOperator() {
        return sqlOperator;
    }

    /**
     * setExpesionValue
     * @param expesionValue expesionValue
     */
    public void setExpesionValue(Object expesionValue) {
        this.expesionValue = expesionValue;
    }

    /**
     * isValueAsColumn
     * @return boolean
     */
    public boolean isValueAsColumn() {
        return valueAsColumn;
    }

    /**
     * setValueAsColumn
     * @param valueAsColumn valueAsColumn
     */
    public void setValueAsColumn(boolean valueAsColumn) {
        this.valueAsColumn = valueAsColumn;
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
     * getFastSearchList
     * @return List
     */
    public List<String> getFastSearchList() {
        if (fastSearchList == null)
            fastSearchList = new ArrayList<>();
        return fastSearchList;
    }

    /**
     * setFastSearchList
     * @param fastSearchList fastSearchList
     */
    public void setFastSearchList(List<String> fastSearchList) {
        this.fastSearchList = fastSearchList;
    }

    /**
     * getFrom
     * @return String
     */
    public String getFrom() {
        return from;
    }

    /**
     * setFrom
     * @param from from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * getAlias
     * @return String
     */
    public String getAlias() {
        return alias;
    }

    /**
     * setAlias
     * @param alias alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * getGroupColumns
     * @return String
     */
    public String getGroupColumns() {
        return groupColumns;
    }

    /**
     * setGroupColumns
     * @param groupColumns groupColumns
     */
    public void setGroupColumns(String groupColumns) {
        this.groupColumns = groupColumns;
    }

    /**
     * getInnerJoin
     * @return InnerOperator
     */
    public InnerOperator getInnerJoin() {
        return innerJoin;
    }

    /**
     * setInnerJoin
     * @param innerJoin innerJoin
     */
    public void setInnerJoin(InnerOperator innerJoin) {
        this.innerJoin = innerJoin;
    }

    /**
     * getTable
     * @return String
     */
    public String getTable() {
        return table;
    }

    /**
     * setTable
     * @param table table
     */
    public void setTable(String table) {
        this.table = table;
    }

    /**
     * getTableAlias
     * @return String
     */
    public String getTableAlias() {
        return tableAlias;
    }

    /**
     * setTableAlias
     * @param tableAlias tableAlias
     */
    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    /**
     * getRecordPerPage
     * @return int
     */
    public int getRecordPerPage() {
        return recordPerPage;
    }

    /**
     * setRecordPerPage
     * @param recordPerPage recordPerPage
     */
    public void setRecordPerPage(int recordPerPage) {
        this.recordPerPage = recordPerPage;
    }

    /**
     * getPage
     * @return int
     */
    public int getPage() {
        return page;
    }

    /**
     * setPage
     * @param page page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * getSelectColumns
     * @return String
     */
    public String getSelectColumns() {
        return selectColumns;
    }

    /**
     * setSelectColumns
     * @param selectColumns selectColumns
     */
    public void setSelectColumns(String selectColumns) {
        this.selectColumns = selectColumns;
    }

    /**
     * getOrderColumn
     * @return String
     */
    public String getOrderColumn() {
        return orderColumn;
    }

    /**
     * setOrderColumn
     * @param orderColumn orderColumn
     * @return FilterData
     */
    public FilterData setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
        return this;
    }

    /**
     * getOrderType
     * @return SqlOrder
     */
    public SqlOrder getOrderType() {
        return orderType;
    }

    /**
     * setOrderType
     * @param orderType orderType
     */
    public void setOrderType(SqlOrder orderType) {
        this.orderType = orderType;
    }

    /**
     * addFromInfo
     * @param from from
     * @param alias alias
     * @return FilterData
     */
    public FilterData addFromInfo(String from, String alias) {
        this.filterDataType = FilterDataType.FROMINFO;
        this.from = from;
        this.alias = alias;
        return this;
    }

    /**
     * addGroupByInfo
     * @param columns columns
     * @return FilterData
     */
    public FilterData addGroupByInfo(String columns) {
        this.filterDataType = FilterDataType.GROUPBYINFO;
        this.groupColumns = columns;
        return this;
    }

    /**
     * addOperatorInfo
     * @param operator operator
     * @return FilterData
     */
    public FilterData addOperatorInfo(String operator) {
        this.filterDataType = FilterDataType.OPERATORINFO;
        this.sqlOperator = operator;
        return this;
    }

    /**
     * addExpressionInfo
     * @param column column
     * @param operator operator
     * @param value value
     * @param valueAsColumn valueAsColumn
     * @return FilterData
     */
    public FilterData addExpressionInfo(String column, ConditionOperator operator, Object value, boolean valueAsColumn) {
        this.filterDataType = FilterDataType.EXPRESSIONINFO;
        this.expesionOperator = operator;
        this.column = column;
        this.expesionValue = value;
        this.valueAsColumn = valueAsColumn;
        return this;
    }

    /**
     * addValue
     * @param value1 value1
     * @param operator operator
     * @param value2 value2
     * @return FilterData
     */
    public FilterData addValue(Object value1, ConditionOperator operator, Object value2) {
        this.filterDataType = FilterDataType.VALUEINFO;
        this.expesionOperator = operator;
        this.value1 = value1;
        this.value2 = value2;
        this.valueAsColumn = true;
        return this;
    }

    /**
     * addJoinInfo
     * @param innerJoin innerJoin
     * @param table table
     * @param tableAlias tableAlias
     * @return FilterData
     */
    public FilterData addJoinInfo(InnerOperator innerJoin, String table, String tableAlias) {
        this.filterDataType = FilterDataType.JOININFO;
        this.innerJoin = innerJoin;
        this.table = table;
        this.tableAlias = tableAlias;
        return this;
    }

    /**
     * clearOrderByInfo
     */
    public void clearOrderByInfo() {
        this.orderColumn = "";
        this.orderType = null;
    }

    /**
     * addSelectInfo
     * @param selectColumns selectColumns
     * @return FilterData
     */
    public FilterData addSelectInfo(String selectColumns) {
        this.filterDataType = FilterDataType.SELECTINFO;
        this.selectColumns = selectColumns;
        return this;
    }

    /**
     * addOrderByInfo
     * @param orderColumn orderColumn
     * @param orderType orderType
     * @return FilterData
     */
    public FilterData addOrderByInfo(String orderColumn, SqlOrder orderType) {
        this.filterDataType = FilterDataType.ORDERBYINFO;
        this.orderColumn = orderColumn;
        this.orderType = orderType;
        return this;
    }

    /**
     * addOffSetInfo
     * @param recordPerPage recordPerPage
     * @param page page
     * @return FilterData
     */
    public FilterData addOffSetInfo(Integer recordPerPage, Integer page) {
        this.filterDataType = FilterDataType.OFFSETINFO;
        this.recordPerPage = recordPerPage;
        this.page = page;
        return this;
    }

    /**
     * addFastSearchInfo
     * @param value value
     * @param columns columns
     * @return FilterData
     */
    public FilterData addFastSearchInfo(String value, List<String> columns) {
        this.filterDataType = FilterDataType.FASTSEARCHINFO;
        this.fastsearch = value;
        this.fastSearchList = columns;
        return this;
    }

    /**
     * addFastSearchInfo
     * @param value value
     * @param columns columns
     * @return FilterData
     */
    public FilterData addFastSearchInfo(String value, String... columns) {
        this.filterDataType = FilterDataType.FASTSEARCHINFO;
        this.fastsearch = value;
        if (columns != null && columns.length > 0) {
            this.fastSearchList = new ArrayList<>();
            for (String fastsearchValue : columns) {
                this.fastSearchList.add(fastsearchValue);
            }
        }
        return this;
    }

    /**
     * addAddtionalDataInfo
     * @param additional additional
     * @return FilterData
     */
    public FilterData addAddtionalDataInfo(String additional) {
        this.filterDataType = FilterDataType.ADDTIONALDATAINFO;
        this.additional = additional;
        return this;
    }

    /**
     * isType
     * @param pFilterDataType pFilterDataType
     * @return boolean
     */
    public boolean isType(FilterDataType pFilterDataType) {
        return this.filterDataType.name().equals(pFilterDataType.name());
    }

    /**
     * addHavingInfo
     * @param having having
     * @return FilterData
     */
    public FilterData addHavingInfo(String having) {
        this.filterDataType = FilterDataType.HAVINGINFO;
        this.havingInfo = having;
        return this;
    }

    /**
     * addDeleteInfo
     * @return FilterData
     */
    public FilterData addDeleteInfo() {
        this.filterDataType = FilterDataType.DELETEINFO;
        return this;
    }

    /**
     * getHavingInfo
     * @return String
     */
    public String getHavingInfo() {
        return havingInfo;
    }

    /**
     * getValue1
     * @return Object
     */
    public Object getValue1() {
        return value1;
    }

    /**
     * getValue2
     * @return Object
     */
    public Object getValue2() {
        return value2;
    }

    /**
     * setUsing
     * @param using using
     * @return FilterData
     */
    public FilterData setUsing(String using) {
        this.filterDataType = FilterDataType.USINGPOSTGRESQLINFO;
        this.using = using;
        return this;
    }

    /**
     * getUsing
     * @return String
     */
    public String getUsing() {
        return using;
    }
}
