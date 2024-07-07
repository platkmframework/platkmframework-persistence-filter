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

import java.util.ArrayList;
import java.util.List;

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
public final class WhereCriteria extends ConditionFilterBase implements CriteriaFunction<WhereCriteria>{
	 
	private static final long serialVersionUID = 1L;
 
	private List<String> arguments; 
	
	public WhereCriteria() { 
		super();
		where();
	}
  
 	protected WhereCriteria where() { 
		sql.add(new FilterData(FilterDataType.WHEREINFO));   
		return this;
	}
 	
	
	public WhereCriteria valexp(String column1, ConditionOperator operator, Object value) {
		_column(operator, column1, value,false);
		return this;
	}

	public WhereCriteria colexp(String column1, ConditionOperator operator, String column2) {
		super.colexp(column1, operator, column2); 
		return this;
	}
 
	public WhereCriteria eq(String column, Object value) {
		super. _column(ConditionOperator.equal, column, value,false);
		return this;
	}

	
	public WhereCriteria neq(String column, Object value) {
		super._column(ConditionOperator.notEqual, column, value, false);
		return this;
	}

	
	public WhereCriteria gt(String column, Object value) {
		super._column(ConditionOperator.greateThan, column, value,false);
		return this;
	}

	
	public WhereCriteria ge(String column, Object value) {
		super._column(ConditionOperator.greateEqual, column, value, false);
		return this;
	}

	
	public WhereCriteria le(String column, Object value) {
		super._column(ConditionOperator.lessEqual, column, value, false);
		return this;
	}

	
	public WhereCriteria lt(String column, Object value) {
		super._column(ConditionOperator.lessThan, column, value,false);
		return this;
	}

	
	public WhereCriteria in(String column, Object value) {
		super._column(ConditionOperator.include, column, value,false);
		return this;
	}

	
	public WhereCriteria nin(String column, Object value) {
		super._column(ConditionOperator.notInclude, column, value,false);
		return this;
	}

	
	public WhereCriteria sw(String column, Object value) {
		super._column(ConditionOperator.startWith, column, value,false);
		return this;
	}

	
	public WhereCriteria ew(String column, Object value) {
		super._column(ConditionOperator.endWith, column, value,false);
		return this;
	}

	
	public WhereCriteria ctn(String column, Object value) {
		super._column(ConditionOperator.contain, column, value,false);
		return this;
	}

	
	public WhereCriteria nctn(String column, Object value) {
		super._column(ConditionOperator.notContain, column, value,false);
		return this;
	}

	
	public WhereCriteria isnull(String column) {
		super._column(ConditionOperator.isNull, column, null,false);
		return this;
	}

	
	public WhereCriteria isnotnull(String column) {
		super._column(ConditionOperator.isNotNull, column, null,false);
		return this;
	}
	 
  
	public WhereCriteria and() { 
	  super.and();  
	  return this;
	}
 
	public WhereCriteria or() {
	  super.or();  
	  return this;
	}
 
	public WhereCriteria cp() {
	  super.cp();  
	  return this;
	}
 
	public WhereCriteria op() {
	  super.op();  
	  return this;
	}
	
	public WhereCriteria orderBy(String orderColumn, SqlOrder orderType) {
		sql.add(new FilterData().addOrderByInfo(orderColumn,orderType));
		return this;
	}
	
	public WhereCriteria groupBy(String orderColumn) {
		sql.add(new FilterData().addGroupByInfo(orderColumn));
		return this;
	}
 
	public WhereCriteria having(String having) {
		sql.add(new FilterData().addHavingInfo(having));
		return this;
	}
	
	public WhereCriteria addOffSetInfo(Integer recordPerPage, Integer page) {
		sql.add(new FilterData().addOffSetInfo(recordPerPage, page ));
		return this;
	}
	
 
	
	public List<String> getArguments() {
		if(arguments == null) arguments = new ArrayList<>();
		return arguments; 
	}

	public WhereCriteria addArguments(String key, Object value) { 
		getArguments().add(key + "=" + value);
		return this;
	}
	
	public WhereCriteria addFastSearchInfo(String value, String... columns) {
		sql.add(new FilterData().addFastSearchInfo(value, columns ));
		return this;
	}
	
	public boolean emptyConditions() {
		   
		FilterData filterData = getSql().stream()
					  .filter( (obj-> ((FilterData)obj).isType(FilterDataType.EXPRESSIONINFO) || ((FilterData)obj).isType(FilterDataType.VALUEINFO ) || ((FilterData)obj).isType(FilterDataType.OPERATORINFO)))
					  .findAny()
					  .orElse(null); 
			
		return filterData == null ;
	  
	}

	public void clear() {
		getSql().clear();
		
	}

	@Override
	public WhereCriteria order(String orderColumn) {
		sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.asc));
		return this; 
	}

	@Override
	public WhereCriteria orderDesc(String orderColumn) { 
		return orderBy(orderColumn, SqlOrder.desc);
	}

	@Override
	public WhereCriteria orderAsc(String orderColumn) { 
		return orderBy(orderColumn, SqlOrder.asc);
	}

	@Override
	public boolean isWherePresent() { 
		return true;
	}
}
