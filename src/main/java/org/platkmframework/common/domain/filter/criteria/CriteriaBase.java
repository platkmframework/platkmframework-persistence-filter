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

import java.util.List;

import org.platkmframework.common.domain.filter.criteria.base.ConditionFilterBase;
import org.platkmframework.common.domain.filter.enumerator.ConditionOperator;
import org.platkmframework.common.domain.filter.enumerator.InnerOperator;
import org.platkmframework.common.domain.filter.enumerator.SqlOrder;
import org.platkmframework.common.domain.filter.info.FilterData; 

/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public abstract class CriteriaBase extends ConditionFilterBase implements CriteriaFunction<ConditionFilterBase>{
 
	private static final long serialVersionUID = 1L;


	protected boolean wherePresent;
	
	protected CriteriaBase(List<FilterData> sql) { 
		super(sql);
	}
	
	protected CriteriaBase() { 
		super();
	}
	
	public CriteriaBase join(String table, String tableAlias) {
		sql.add(new FilterData().addJoinInfo(InnerOperator.inner_join, table, tableAlias));  
		return this;
	}
 
	public CriteriaBase leftJoin(String table, String tableAlias) {
		sql.add(new FilterData().addJoinInfo(InnerOperator.left_join, table, tableAlias)); 
		return this;
	}
 
	public CriteriaBase rightJoin(String table, String tableAlias) {
		sql.add(new FilterData().addJoinInfo(InnerOperator.right_join, table, tableAlias)); 
		return this;
	}
 
	
	public CriteriaBase valexp(String column1, ConditionOperator operator, Object value) {
		_column(operator, column1, value,false);
		return this;
	}

	public CriteriaBase colexp(String column1, ConditionOperator operator, String column2) {
		super.colexp(column1, operator, column2); 
		return this;
	}
 
	public CriteriaBase eq(String column, Object value) {
		super. _column(ConditionOperator.equal, column, value,false);
		return this;
	}

	
	public CriteriaBase neq(String column, Object value) {
		super._column(ConditionOperator.notEqual, column, value, false);
		return this;
	}

	
	public CriteriaBase gt(String column, Object value) {
		super._column(ConditionOperator.greateThan, column, value,false);
		return this;
	}

	
	public CriteriaBase ge(String column, Object value) {
		super._column(ConditionOperator.greateEqual, column, value, false);
		return this;
	}

	
	public CriteriaBase le(String column, Object value) {
		super._column(ConditionOperator.lessEqual, column, value, false);
		return this;
	}

	
	public CriteriaBase lt(String column, Object value) {
		super._column(ConditionOperator.lessThan, column, value,false);
		return this;
	}

	
	public CriteriaBase in(String column, Object value) {
		super._column(ConditionOperator.include, column, value,false);
		return this;
	}

	
	public CriteriaBase nin(String column, Object value) {
		super._column(ConditionOperator.notInclude, column, value,false);
		return this;
	}

	
	public CriteriaBase sw(String column, Object value) {
		super._column(ConditionOperator.startWith, column, value,false);
		return this;
	}

	
	public CriteriaBase ew(String column, Object value) {
		super._column(ConditionOperator.endWith, column, value,false);
		return this;
	}

	
	public CriteriaBase ctn(String column, Object value) {
		super._column(ConditionOperator.contain, column, value,false);
		return this;
	}

	
	public CriteriaBase nctn(String column, Object value) {
		super._column(ConditionOperator.notContain, column, value,false);
		return this;
	}

	
	public CriteriaBase isnull(String column) {
		super._column(ConditionOperator.isNull, column, null,false);
		return this;
	}

	
	public CriteriaBase isnotnull(String column) {
		super._column(ConditionOperator.isNotNull, column, null,false);
		return this;
	}
	 
  
	public CriteriaBase and() { 
	  super.and();  
	  return this;
	}
 
	public CriteriaBase or() {
	  super.or();  
	  return this;
	}
 
	public CriteriaBase cp() {
	  super.cp();  
	  return this;
	}
 
	public CriteriaBase op() {
	  super.op();  
	  return this;
	}
	
	public CriteriaBase orderBy(String orderColumn, SqlOrder orderType) {
		sql.add(new FilterData().addOrderByInfo(orderColumn,orderType));
		return this;
	}
	
	public CriteriaBase order(String orderColumn) {
		sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.asc));
		return this;
	} 
	
	public CriteriaBase orderDesc(String orderColumn) {
		sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.desc));
		return this;
	}
	
	public CriteriaBase orderAsc(String orderColumn) {
		sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.asc));
		return this;
	}	 	
	
	public CriteriaBase groupBy(String orderColumn) {
		sql.add(new FilterData().addGroupByInfo(orderColumn));
		return this;
	}
 
	public CriteriaBase having(String having) {
		sql.add(new FilterData().addHavingInfo(having));
		return this;
	}
	
	public CriteriaBase addOffSetInfo(Integer recordPerPage, Integer page) {
		sql.add(new FilterData().addOffSetInfo(recordPerPage, page ));
		return this;
	}
	
	public CriteriaBase addFastSearchInfo(String fastsearch, String... columns) {
		sql.add(new FilterData().addFastSearchInfo(fastsearch, columns ));
		return this;
	}

	public boolean isWherePresent() {
		return wherePresent;
	}
	
	public boolean emptyConditions() {
		return getSql().size() == 0;
	}

	public void clear() {
		getSql().clear();
		
	}


}
