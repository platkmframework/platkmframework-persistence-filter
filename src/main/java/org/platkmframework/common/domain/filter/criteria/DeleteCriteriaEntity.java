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
import org.platkmframework.common.domain.filter.info.FilterData;
import org.platkmframework.common.domain.filter.info.FilterDataType;



/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public final class DeleteCriteriaEntity extends DeleteCriteria implements Serializable {

	private static final long serialVersionUID = 1L;
	 

	public DeleteCriteriaEntity() {
		super(""); 
	}
	

	protected DeleteCriteriaEntity where() { 
		sql.add(new FilterData(FilterDataType.WHEREINFO));   
		return this;
	}
	
	public DeleteCriteriaEntity valexp(String column1, ConditionOperator operator, Object value) {
		 super.valexp(column1, operator,  value);
		return this;
	}

	public DeleteCriteriaEntity colexp(String column1, ConditionOperator operator, String column2) {
		super.valexp(column1, operator,  column2);
		return this;
	}
 
	public DeleteCriteriaEntity eq(String column, Object value) {
		super.eq(column, value);
		return this;
	}

	
	public DeleteCriteriaEntity neq(String column, Object value) {
		super.neq(column, value);
		return this;
	}

	
	public DeleteCriteriaEntity gt(String column, Object value) {
		super.gt( column, value );
		return this;
	}

	
	public DeleteCriteriaEntity ge(String column, Object value) {
		super.ge(  column, value );
		return this;
	}

	
	public DeleteCriteriaEntity le(String column, Object value) {
		super.le(  column, value );
		return this;
	}

	
	public DeleteCriteriaEntity lt(String column, Object value) {
		super.lt( column, value );
		return this;
	}

	
	public DeleteCriteriaEntity in(String column, Object value) {
		super.in(  column, value );
		return this;
	}

	
	public DeleteCriteriaEntity nin(String column, Object value) {
		super.nin(  column, value );
		return this;
	}

	
	public DeleteCriteriaEntity sw(String column, Object value) {
		super.sw(  column, value );
		return this;
	}

	
	public DeleteCriteriaEntity ew(String column, Object value) {
		super.ew(  column, value);
		return this;
	}

	
	public DeleteCriteriaEntity ctn(String column, Object value) {
		super.ctn(  column, value );
		return this;
	}

	
	public DeleteCriteriaEntity nctn(String column, Object value) {
		super.nctn( column, value );
		return this;
	}

	
	public DeleteCriteriaEntity isnull(String column) {
		super.isnull( column );
		return this;
	}

	
	public DeleteCriteriaEntity isnotnull(String column) {
		super.isnotnull( column  );
		return this;
	}
	 
  
	public DeleteCriteriaEntity and() { 
	  super.and();  
	  return this;
	}
 
	public DeleteCriteriaEntity or() {
	  super.or();  
	  return this;
	}
 
	public DeleteCriteriaEntity cp() {
	  super.cp();  
	  return this;
	}
 
	public DeleteCriteriaEntity op() {
	  super.op();  
	  return this;
	}
	 
}
