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
package org.platkmframework.common.domain.filter.criteria;

import java.io.Serializable;

import org.platkmframework.common.domain.filter.enumerator.ConditionOperator;
import org.platkmframework.common.domain.filter.enumerator.SqlOrder;
import org.platkmframework.common.domain.filter.info.FilterData;
import org.platkmframework.common.domain.filter.info.FilterDataType; 


/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public final class SearchCriteria extends CriteriaBase implements Serializable {

	private static final long serialVersionUID = 1L;
	 

	public SearchCriteria() {
		super();
	}
  
	public SearchCriteria select(String columns, String table, String alias) { 
		getSql().add(new FilterData().addSelectInfo(columns));  
		getSql().add(new FilterData().addFromInfo(table, alias));  
		return this; 
	}
	
	public SearchCriteria select( String table, String alias) { 
		sql.add(new FilterData().addSelectInfo(null));  
		sql.add(new FilterData().addFromInfo(table, alias));  
		return this; 
	}
 
	public SearchCriteria select ( String table ) { 
		sql.add(new FilterData().addSelectInfo(null));  
		sql.add(new FilterData().addFromInfo(table, null)); 
		return this; 
	} 
	
	public SearchCriteria where() { 
		sql.add(new FilterData(FilterDataType.WHEREINFO));  
		wherePresent = true;
		return this;
	}
	

	public SearchCriteria join(String table, String tableAlias) {
		super.join(table, tableAlias);  
		return this;
	}
 
	public SearchCriteria leftJoin(String table, String tableAlias) {
		super.leftJoin(table, tableAlias); 
		return this;
	}
 
	public SearchCriteria rightJoin(String table, String tableAlias) {
		super.rightJoin(table, tableAlias); 
		return this;
	}
 
	
	public SearchCriteria valexp(String column1, ConditionOperator operator, Object value) {
		_column(operator, column1, value,false);
		return this;
	}

	public SearchCriteria colexp(String column1, ConditionOperator operator, String column2) {
		super.colexp(column1, operator, column2); 
		return this;
	}
 
	public SearchCriteria eq(String column, Object value) {
		super.eq(column, value);
		return this;
	}

	
	public SearchCriteria neq(String column, Object value) {
		super.neq(column, value);
		return this;
	}

	
	public SearchCriteria gt(String column, Object value) {
		super.gt(column, value);
		return this;
	}

	
	public SearchCriteria ge(String column, Object value) {
		super.ge(column, value);
		return this;
	}

	
	public SearchCriteria le(String column, Object value) {
		super.le(column, value);
		return this;
	}

	
	public SearchCriteria lt(String column, Object value) {
		super.lt(column, value);
		return this;
	}

	
	public SearchCriteria in(String column, Object value) {
		super.in(column, value);
		return this;
	}

	
	public SearchCriteria nin(String column, Object value) {
		super.nin(column, value);
		return this;
	}

	
	public SearchCriteria sw(String column, Object value) {
		super.sw(column, value);
		return this;
	}

	
	public SearchCriteria ew(String column, Object value) {
		super.ew(column, value);
		return this;
	}

	
	public SearchCriteria ctn(String column, Object value) {
		super._column(ConditionOperator.contain, column, value,false);
		return this;
	}

	
	public SearchCriteria nctn(String column, Object value) {
		super.nctn(column, value);
		return this;
	}

	
	public SearchCriteria isnull(String column) {
		super.isnull(column);
		return this;
	}

	
	public SearchCriteria isnotnull(String column) {
		super.isnotnull(column);
		return this;
	}
	 
  
	public SearchCriteria and() { 
	  super.and();  
	  return this;
	}
 
	public SearchCriteria or() {
	  super.or();  
	  return this;
	}
 
	public SearchCriteria cp() {
	  super.cp();  
	  return this;
	}
 
	public SearchCriteria op() {
	  super.op();  
	  return this;
	}
	
	public SearchCriteria orderBy(String orderColumn, SqlOrder orderType) {
		super.orderBy(orderColumn,orderType);
		return this;
	}
	
	public SearchCriteria order(String orderColumn) {
		super.order(orderColumn);
		return this;
	} 
	
	public SearchCriteria orderDesc(String orderColumn) {
		super.orderDesc(orderColumn);
		return this;
	}
	
	public SearchCriteria orderAsc(String orderColumn) {
		super.orderAsc(orderColumn);
		return this;
	}	 	
	
	public SearchCriteria groupBy(String orderColumn) {
		super.groupBy(orderColumn);
		return this;
	}
 
	public SearchCriteria having(String having) {
		super.having(having);
		return this;
	}
	
	public SearchCriteria addOffSetInfo(Integer recordPerPage, Integer page) {
		super.addOffSetInfo(recordPerPage, page );
		return this;
	}
	
	public SearchCriteria addFastSearchInfo(String fastsearch) {
		super.addFastSearchInfo(fastsearch);
		return this;
	}

	public boolean isOrderByPresent() {
		return getSql().stream().filter((c)-> c.getFilterDataType().name().equals(FilterDataType.ORDERBYINFO.name())).findFirst().isPresent();
	}

}
