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
 
import org.platkmframework.common.domain.filter.enumerator.ConditionOperator; 


/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public interface ConditionFilter {

	public ConditionFilter valexp(String column1, ConditionOperator operator, Object value);

	public ConditionFilter colexp(String column1, ConditionOperator operator, String column2);
 
	public ConditionFilter eq(String column, Object value) ;

	
	public ConditionFilter neq(String column, Object value);

	
	public ConditionFilter gt(String column, Object value) ;

	
	public ConditionFilter ge(String column, Object value);

	
	public ConditionFilter le(String column, Object value);

	
	public ConditionFilter lt(String column, Object value);

	
	public ConditionFilter in(String column, Object value);

	
	public ConditionFilter nin(String column, Object value);

	
	public ConditionFilter sw(String column, Object value);

	
	public ConditionFilter ew(String column, Object value);

	
	public ConditionFilter ctn(String column, Object value);

	
	public ConditionFilter nctn(String column, Object value);

	
	public ConditionFilter isnull(String column);

	
	public ConditionFilter isnotnull(String column);
	 
	public ConditionFilter and();
 
	public ConditionFilter or();
 
	public ConditionFilter cp();
 
	public ConditionFilter op();
	  
}
