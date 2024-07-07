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

import java.util.Arrays;

import org.platkmframework.common.domain.filter.criteria.base.ConditionFilter;
import org.platkmframework.common.domain.filter.criteria.base.ConditionFilterBase;
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
public final class FilterCriteria extends ConditionFilterBase implements ConditionFilter, CriteriaFunction<FilterCriteria> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 

	public FilterCriteria() {
		super(); 
		selectInitWhere(null, null, null);
	}

	public FilterCriteria(String alias) {
		super(); 
		selectInitWhere(null, null, alias);
	}

	private void selectInitWhere (String columns, String table, String alias) {   
		 getSql().add(new FilterData().addSelectInfo(columns));  
		 getSql().add(new FilterData().addFromInfo(table, alias)); 
	    where();  
	}

 

	private FilterCriteria where() { 
		sql.add(new FilterData(FilterDataType.WHEREINFO));   
		return this;
	}
	
	
	public FilterCriteria valexp(String column1, ConditionOperator operator, Object value) {
		_column(operator, column1, value,false);
		return this;
	}

	public FilterCriteria colexp(String column1, ConditionOperator operator, String column2) {
		super.colexp(column1, operator, column2); 
		return this;
	}
 
	public FilterCriteria eq(String column, Object value) {
		super. _column(ConditionOperator.equal, column, value,false);
		return this;
	}

	
	public FilterCriteria neq(String column, Object value) {
		super._column(ConditionOperator.notEqual, column, value, false);
		return this;
	}

	
	public FilterCriteria gt(String column, Object value) {
		super._column(ConditionOperator.greateThan, column, value,false);
		return this;
	}

	
	public FilterCriteria ge(String column, Object value) {
		super._column(ConditionOperator.greateEqual, column, value, false);
		return this;
	}

	
	public FilterCriteria le(String column, Object value) {
		super._column(ConditionOperator.lessEqual, column, value, false);
		return this;
	}

	
	public FilterCriteria lt(String column, Object value) {
		super._column(ConditionOperator.lessThan, column, value,false);
		return this;
	}

	
	public FilterCriteria in(String column, Object value) {
		super._column(ConditionOperator.include, column, value,false);
		return this;
	}

	
	public FilterCriteria nin(String column, Object value) {
		super._column(ConditionOperator.notInclude, column, value,false);
		return this;
	}

	
	public FilterCriteria sw(String column, Object value) {
		super._column(ConditionOperator.startWith, column, value,false);
		return this;
	}

	
	public FilterCriteria ew(String column, Object value) {
		super._column(ConditionOperator.endWith, column, value,false);
		return this;
	}

	
	public FilterCriteria ctn(String column, Object value) {
		super._column(ConditionOperator.contain, column, value,false);
		return this;
	}

	
	public FilterCriteria nctn(String column, Object value) {
		super._column(ConditionOperator.notContain, column, value,false);
		return this;
	}

	
	public FilterCriteria isnull(String column) {
		super._column(ConditionOperator.isNull, column, null,false);
		return this;
	}

	
	public FilterCriteria isnotnull(String column) {
		super._column(ConditionOperator.isNotNull, column, null,false);
		return this;
	}
	 
  
	public FilterCriteria and() { 
	  super.and();  
	  return this;
	}
 
	public FilterCriteria or() {
	  super.or();  
	  return this;
	}
 
	public FilterCriteria cp() {
	  super.cp();  
	  return this;
	}
 
	public FilterCriteria op() {
	  super.op();  
	  return this;
	}
	
	public FilterCriteria orderBy(String orderColumn, SqlOrder orderType) {
		sql.add(new FilterData().addOrderByInfo(orderColumn,orderType));
		return this;
	}
	
	public FilterCriteria order(String orderColumn) {
		sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.asc));
		return this;
	} 
	
	public FilterCriteria orderDesc(String orderColumn) {
		sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.desc));
		return this;
	}
	
	public FilterCriteria orderAsc(String orderColumn) {
		sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.asc));
		return this;
	}	 	
	
	public FilterCriteria groupBy(String orderColumn) {
		sql.add(new FilterData().addGroupByInfo(orderColumn));
		return this;
	}
 
	public FilterCriteria having(String having) {
		sql.add(new FilterData().addHavingInfo(having));
		return this;
	}
	
	public FilterCriteria addOffSetInfo(Integer recordPerPage, Integer page) {
		sql.add(new FilterData().addOffSetInfo(recordPerPage, page ));
		return this;
	}
	
	public FilterCriteria addFastSearchInfo(String value, String... columns) {
		sql.add(new FilterData().addFastSearchInfo(value, columns ));
		return this;
	}
	
	public void addFastSearchInfoColumns(String[] columns) {
		
		FilterData filterData = sql.stream()
				  .filter( (obj-> ((FilterData)obj).isType(FilterDataType.FASTSEARCHINFO)))
				  .findAny()
				  .orElse(null);
		
		if(filterData != null) {
			filterData.setFastSearchList(Arrays.asList(columns));
		}
		
	}
	
	public boolean emptyConditions() {
		  
		FilterData filterData =  getSql().stream()
				  .filter( (obj-> ((FilterData)obj).isType(FilterDataType.WHEREINFO)))
				  .findAny()
				  .orElse(null); 
		
		if(filterData == null ) return true;
		
		int post = getSql().indexOf(filterData) + 1; 
		if(post <= getSql().size()) {
			//List<FilterData> list = getSql().subList(2, getSql().size() -1);
			
			filterData = getSql().stream()
					  .filter( (obj-> ((FilterData)obj).isType(FilterDataType.EXPRESSIONINFO) || ((FilterData)obj).isType(FilterDataType.VALUEINFO ) || ((FilterData)obj).isType(FilterDataType.OPERATORINFO)))
					  .findAny()
					  .orElse(null); 
			
			return filterData == null ;
		}else return true;
	}

	@Override
	public boolean isWherePresent() { 
		return true;
	}

	@Override
	public void clear() { 
		getSql().clear();
		
	}


}
