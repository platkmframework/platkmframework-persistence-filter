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
package org.platkmframework.common.domain.filter.criteria.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.platkmframework.common.domain.filter.enumerator.ConditionOperator;
import org.platkmframework.common.domain.filter.enumerator.GroupOperator;
import org.platkmframework.common.domain.filter.enumerator.SqlOperator;
import org.platkmframework.common.domain.filter.info.FilterData; 


/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public  abstract  class ConditionFilterBase implements ConditionFilter, Serializable {
	 
    private static final long serialVersionUID = 1L;
	  
	protected List<FilterData> sql;
	
	protected String code;
	
	public ConditionFilterBase(List<FilterData> sql) { 
		this.sql = sql;
	}
	
	public ConditionFilterBase() { 
		this.sql = new ArrayList<>();
	}
	
	public ConditionFilterBase valexp(String column1, ConditionOperator operator, Object value) {
		_column(operator, column1, value,false);
		return this;
	}

	public ConditionFilterBase colexp(String column1, ConditionOperator operator, String column2) {
 
		sql.add(new FilterData().addExpressionInfo(column1, operator, column2, true)); 
		return this;
	}
 
	public ConditionFilterBase eq(String column, Object value) {
		return _column(ConditionOperator.equal, column, value,false);
	}

	
	public ConditionFilterBase neq(String column, Object value) {
		return _column(ConditionOperator.notEqual, column, value, false);
	}

	
	public ConditionFilterBase gt(String column, Object value) {
		return _column(ConditionOperator.greateThan, column, value,false);
	}

	
	public ConditionFilterBase ge(String column, Object value) {
		return _column(ConditionOperator.greateEqual, column, value, false);
	}

	
	public ConditionFilterBase le(String column, Object value) {
		return _column(ConditionOperator.lessEqual, column, value, false);
	}

	
	public ConditionFilterBase lt(String column, Object value) {
		return _column(ConditionOperator.lessThan, column, value,false);
	}

	
	public ConditionFilterBase in(String column, Object value) {
		return _column(ConditionOperator.include, column, value,false);
	}

	
	public ConditionFilterBase nin(String column, Object value) {
		return _column(ConditionOperator.notInclude, column, value,false);
	}

	
	public ConditionFilterBase sw(String column, Object value) {
		return _column(ConditionOperator.startWith, column, value,false);
	}

	
	public ConditionFilterBase ew(String column, Object value) {
		return _column(ConditionOperator.endWith, column, value,false);
	}

	
	public ConditionFilterBase ctn(String column, Object value) {
		return _column(ConditionOperator.contain, column, value,false);
	}

	
	public ConditionFilterBase nctn(String column, Object value) {
		return _column(ConditionOperator.notContain, column, value,false);
	}

	
	public ConditionFilterBase isnull(String column) {
		return _column(ConditionOperator.isNull, column, null,false);
	}

	
	public ConditionFilterBase isnotnull(String column) {
		return _column(ConditionOperator.isNotNull, column, null,false);
	}
	
	protected ConditionFilterBase _column(ConditionOperator operator, String column, Object value, boolean valueAsColumn) { 
	 
		sql.add(new FilterData().addExpressionInfo( column, operator, value,  valueAsColumn)); 
		return this;
	}	
  
	public ConditionFilterBase and() { 
		sql.add(getOperatorInfo(SqlOperator.and.name())); 
		return this;
	}
 
	public ConditionFilterBase or() {
		sql.add(getOperatorInfo(SqlOperator.or.name())); 
		return this;
	}
 
	public ConditionFilterBase cp() {
		sql.add(getOperatorInfo(GroupOperator.close.name())); 
		return this;
	}
 
	public ConditionFilterBase op() {
		sql.add(getOperatorInfo(GroupOperator.open.name())); 
		return this;
	}	 
	
	protected FilterData getOperatorInfo(String operator) {
 
		return new FilterData().addOperatorInfo(operator );
	}

	public List<FilterData> getSql() {
		return sql;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
