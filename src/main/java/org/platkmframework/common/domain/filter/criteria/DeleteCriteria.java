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

import org.platkmframework.common.domain.filter.criteria.base.ConditionFilterBase;
import org.platkmframework.common.domain.filter.enumerator.ConditionOperator;
import org.platkmframework.common.domain.filter.info.FilterData;
import org.platkmframework.common.domain.filter.info.FilterDataType;  

/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public class DeleteCriteria extends ConditionFilterBase implements Serializable {

	private static final long serialVersionUID = 1L;
	 

	public DeleteCriteria(String table) {
		super();
		sql.add(new FilterData().addDeleteInfo());
		sql.add(new FilterData().addFromInfo(table, "")); 
		where();
	}
	
	public DeleteCriteria(String table, String alias) {
		super();
		sql.add(new FilterData().addDeleteInfo());
		sql.add(new FilterData().addFromInfo(table, alias)); 
		where();
	}
 

	protected DeleteCriteria where() { 
		sql.add(new FilterData(FilterDataType.WHEREINFO));   
		return this;
	}
	
	public DeleteCriteria valexp(String column1, ConditionOperator operator, Object value) {
		 super.valexp(column1, operator,  value);
		return this;
	}

	public DeleteCriteria colexp(String column1, ConditionOperator operator, String column2) {
		super.valexp(column1, operator,  column2);
		return this;
	}
 
	public DeleteCriteria eq(String column, Object value) {
		super.eq(column, value);
		return this;
	}

	
	public DeleteCriteria neq(String column, Object value) {
		super.neq(column, value);
		return this;
	}

	
	public DeleteCriteria gt(String column, Object value) {
		super.gt( column, value );
		return this;
	}

	
	public DeleteCriteria ge(String column, Object value) {
		super.ge(  column, value );
		return this;
	}

	
	public DeleteCriteria le(String column, Object value) {
		super.le(  column, value );
		return this;
	}

	
	public DeleteCriteria lt(String column, Object value) {
		super.lt( column, value );
		return this;
	}

	
	public DeleteCriteria in(String column, Object value) {
		super.in(  column, value );
		return this;
	}

	
	public DeleteCriteria nin(String column, Object value) {
		super.nin(  column, value );
		return this;
	}

	
	public DeleteCriteria sw(String column, Object value) {
		super.sw(  column, value );
		return this;
	}

	
	public DeleteCriteria ew(String column, Object value) {
		super.ew(  column, value);
		return this;
	}

	
	public DeleteCriteria ctn(String column, Object value) {
		super.ctn(  column, value );
		return this;
	}

	
	public DeleteCriteria nctn(String column, Object value) {
		super.nctn( column, value );
		return this;
	}

	
	public DeleteCriteria isnull(String column) {
		super.isnull( column );
		return this;
	}

	
	public DeleteCriteria isnotnull(String column) {
		super.isnotnull( column  );
		return this;
	}
	 
  
	public DeleteCriteria and() { 
	  super.and();  
	  return this;
	}
 
	public DeleteCriteria or() {
	  super.or();  
	  return this;
	}
 
	public DeleteCriteria cp() {
	  super.cp();  
	  return this;
	}
 
	public DeleteCriteria op() {
	  super.op();  
	  return this;
	}
}
