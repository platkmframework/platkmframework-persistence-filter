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
public final class DeleteQuery extends CriteriaBase implements Serializable {

	private static final long serialVersionUID = 1L;

	public DeleteQuery(String table) {
		super();
		sql.add(new FilterData().addDeleteInfo());
		sql.add(new FilterData().addFromInfo(table, ""));  
	}
	
	public DeleteQuery(String table, String alias) { 
		getSql().add(new FilterData().addDeleteInfo());  
		getSql().add(new FilterData().addFromInfo(table, alias));  
	}
 
	public DeleteQuery join(String table, String tableAlias) {
		super.join(table, tableAlias);  
		return this;
	}
 
	public DeleteQuery leftJoin(String table, String tableAlias) {
		super.leftJoin(table, tableAlias) ;
		return this;
	}
 
	public DeleteQuery rightJoin(String table, String tableAlias) {
		super.rightJoin(table, tableAlias) ; 
		return this;
	}

	public DeleteQuery where() { 
		sql.add(new FilterData(FilterDataType.WHEREINFO));  
		wherePresent = true;
		return this;
	}
	
	public DeleteQuery valexp(String column1, ConditionOperator operator, Object value) {
		 super.valexp(column1, operator,  value);
		return this;
	}

	public DeleteQuery colexp(String column1, ConditionOperator operator, String column2) {
		super.colexp(column1, operator,  column2);
		return this;
	}
 
	public DeleteQuery eq(String column, Object value) {
		super.eq(column, value);
		return this;
	}

	
	public DeleteQuery neq(String column, Object value) {
		super.neq(column, value);
		return this;
	}

	
	public DeleteQuery gt(String column, Object value) {
		super.gt( column, value );
		return this;
	}

	
	public DeleteQuery ge(String column, Object value) {
		super.ge(  column, value );
		return this;
	}

	
	public DeleteQuery le(String column, Object value) {
		super.le(  column, value );
		return this;
	}

	
	public DeleteQuery lt(String column, Object value) {
		super.lt( column, value );
		return this;
	}

	
	public DeleteQuery in(String column, Object value) {
		super.in(  column, value );
		return this;
	}

	
	public DeleteQuery nin(String column, Object value) {
		super.nin(  column, value );
		return this;
	}

	
	public DeleteQuery sw(String column, Object value) {
		super.sw(  column, value );
		return this;
	}

	
	public DeleteQuery ew(String column, Object value) {
		super.ew(  column, value);
		return this;
	}

	
	public DeleteQuery ctn(String column, Object value) {
		super.ctn(  column, value );
		return this;
	}

	
	public DeleteQuery nctn(String column, Object value) {
		super.nctn( column, value );
		return this;
	}

	
	public DeleteQuery isnull(String column) {
		super.isnull( column );
		return this;
	}

	
	public DeleteQuery isnotnull(String column) {
		super.isnotnull( column  );
		return this;
	}
	 
  
	public DeleteQuery and() { 
	  super.and();  
	  return this;
	}
 
	public DeleteQuery or() {
	  super.or();  
	  return this;
	}
 
	public DeleteQuery cp() {
	  super.cp();  
	  return this;
	}
 
	public DeleteQuery op() {
	  super.op();  
	  return this;
	}
}
