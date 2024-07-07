/*******************************************************************************
 * Copyright(c) 2023 the original author Eduardo Iglesias Taylor.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	 https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * 	Eduardo Iglesias Taylor - initial API and implementation
 *******************************************************************************/
package org.platkmframework.common.domain.filter.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.platkmframework.common.domain.filter.enumerator.ConditionOperator;
import org.platkmframework.common.domain.filter.enumerator.InnerOperator;
import org.platkmframework.common.domain.filter.enumerator.SqlOrder; 


/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public class FilterData  implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	
	private FilterDataType filterDataType; 
	
	//AddtionalDataInfo
	private String additional;  
	
	private String havingInfo;  
	
	//ExpressionInfo
	private ConditionOperator expesionOperator;  private String column;  private  Object expesionValue; private boolean valueAsColumn = false ;	
	
	//FastSearchInfo
	private String fastsearch; private List<String> fastSearchList;
	
	//FromInfo
	private String from; private String alias;
	
	//GroupByInfo
	private String groupColumns;
	 
	//JoinInfo
	private InnerOperator innerJoin; private String table; private String tableAlias;  private String using;
	
	//OffSetInfo
	private int recordPerPage = 0;  private int page   = 0;  //20; //by default //    = 0; //by default
	
  
	//SelectInfo
	private String selectColumns;
	
	//OrderByInfo  
	private String orderColumn;	private SqlOrder orderType;
	
	private String sqlOperator;
	
	private Object value1, value2;


	public FilterData() {
		super(); 
	}
 
	public FilterData(FilterDataType filterDataType) {
		this.filterDataType = filterDataType;
	}
 
	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public FilterDataType getFilterDataType() {
		return filterDataType;
	}

	public void setFilterDataType(FilterDataType filterDataType) {
		this.filterDataType = filterDataType;
	}

	public ConditionOperator getExpesionOperator() {
		return expesionOperator;
	}

	public void setExpesionOperator(ConditionOperator expesionOperator) {
		this.expesionOperator = expesionOperator;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}
 
	public Object getExpesionValue() {
		return expesionValue;
	}

	public String getSqlOperator() {
		return sqlOperator;
	}

	public void setExpesionValue(Object expesionValue) {
		this.expesionValue = expesionValue;
	}

	public boolean isValueAsColumn() {
		return valueAsColumn;
	}

	public void setValueAsColumn(boolean valueAsColumn) {
		this.valueAsColumn = valueAsColumn;
	}
 

	public String getFastsearch() {
		return fastsearch;
	}

	public void setFastsearch(String fastsearch) {
		this.fastsearch = fastsearch;
	}

	public List<String> getFastSearchList() {
		if(fastSearchList == null) fastSearchList = new ArrayList<>();
		return fastSearchList;
	}

	public void setFastSearchList(List<String> fastSearchList) {
		this.fastSearchList = fastSearchList;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getGroupColumns() {
		return groupColumns;
	}

	public void setGroupColumns(String groupColumns) {
		this.groupColumns = groupColumns;
	}

	public InnerOperator getInnerJoin() {
		return innerJoin;
	}

	public void setInnerJoin(InnerOperator innerJoin) {
		this.innerJoin = innerJoin;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getTableAlias() {
		return tableAlias;
	}

	public void setTableAlias(String tableAlias) {
		this.tableAlias = tableAlias;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
 

	public String getSelectColumns() {
		return selectColumns;
	}

	public void setSelectColumns(String selectColumns) {
		this.selectColumns = selectColumns;
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public FilterData setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
		return this;
	}

	public SqlOrder getOrderType() {
		return orderType;
	}

	public void setOrderType(SqlOrder orderType) {
		this.orderType = orderType;
	}

	public FilterData addFromInfo(String from, String alias) {
		this.filterDataType = FilterDataType.FROMINFO;
		this.from  = from;
		this.alias = alias;
		return this;
	}


	public FilterData addGroupByInfo(String columns) {
		this.filterDataType = FilterDataType.GROUPBYINFO;
		this.groupColumns = columns;
		return this;
	}

	public FilterData addOperatorInfo(String operator ) {
		this.filterDataType = FilterDataType.OPERATORINFO; 
		this.sqlOperator = operator;
		return this;
	}

	 
	public FilterData addExpressionInfo(String column, ConditionOperator operator, Object value, boolean valueAsColumn) {
		this.filterDataType = FilterDataType.EXPRESSIONINFO;
		this.expesionOperator = operator;
		this.column = column;
		this.expesionValue = value; 
		this.valueAsColumn = valueAsColumn;
		return this;
	}
	
	public FilterData addValue(Object value1, ConditionOperator operator, Object value2 ) {
		this.filterDataType = FilterDataType.VALUEINFO;
		this.expesionOperator = operator;
		this.value1 = value1;
		this.value2 = value2; 
		this.valueAsColumn = true;
		return this;
	}

	public FilterData addJoinInfo(InnerOperator innerJoin, String table, String tableAlias) {
		this.filterDataType = FilterDataType.JOININFO;
		this.innerJoin = innerJoin;
		this.table = table;
		this.tableAlias = tableAlias; 
		return this;
	}

	public void clearOrderByInfo() {
		this.orderColumn = "";
		this.orderType   =  null; 
	}

	public FilterData addSelectInfo(String selectColumns) {
		this.filterDataType = FilterDataType.SELECTINFO;
		this.selectColumns = selectColumns;
		return this;
	}

	public FilterData addOrderByInfo(String orderColumn, SqlOrder orderType) {
		this.filterDataType = FilterDataType.ORDERBYINFO;
		this.orderColumn = orderColumn;
		this.orderType   =  orderType; 
		return this;
	}

	public FilterData addOffSetInfo(Integer recordPerPage, Integer page) {
		this.filterDataType = FilterDataType.OFFSETINFO;
		this.recordPerPage = recordPerPage;
		this.page = page;
		return this;
	}

	public FilterData addFastSearchInfo(String value, List<String> columns) {
		this.filterDataType = FilterDataType.FASTSEARCHINFO;
		this.fastsearch = value;
		this.fastSearchList = columns;
		return this;
	}
	
	public FilterData addFastSearchInfo(String value, String... columns) {
		this.filterDataType = FilterDataType.FASTSEARCHINFO;
		this.fastsearch = value;
		if(columns!= null && columns.length > 0) {
			this.fastSearchList =  new ArrayList<String>();
			for (String fastsearchValue : columns) {
				this.fastSearchList.add(fastsearchValue);
			}
		} 
		return this;
	}

	public FilterData addAddtionalDataInfo(String additional) {
		this.filterDataType = FilterDataType.ADDTIONALDATAINFO;
		this.additional = additional; 
		return this;
	}

	public boolean isType(FilterDataType pFilterDataType) { 
		return this.filterDataType.name().equals(pFilterDataType.name());
	}

	public FilterData addHavingInfo(String having) {
		this.filterDataType = FilterDataType.HAVINGINFO;
		this.havingInfo = having; 
		return this;
	}
	
	public FilterData addDeleteInfo() {
		this.filterDataType = FilterDataType.DELETEINFO; 
		return this;
	}

	public String getHavingInfo() {
		return havingInfo;
	}

	public Object getValue1() {
		return value1;
	}

	public Object getValue2() {
		return value2;
	}

	public FilterData setUsing(String using) {
		this.filterDataType = FilterDataType.USINGPOSTGRESQLINFO; 
		this.using = using;
		return this; 
	}

	public String getUsing() {
		return using;
	}
 

}
