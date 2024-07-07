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
package org.platkmframework.common.domain.filter.ui;

import java.util.ArrayList;
import java.util.List;

import org.platkmframework.common.domain.filter.enumerator.ConditionOperator;
import org.platkmframework.common.domain.filter.enumerator.GroupOperator;
import org.platkmframework.common.domain.filter.enumerator.SqlOperator;


/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public class BaseFilter {
	 
	private String code;
	private List<FilterCondition> conditions; 
	private List<Param> parameters;
	private String fastsearch;
	
	public void addCondition(SqlOperator sqlOperator, boolean initGroup, String columnName, ConditionOperator operator, Object value, boolean endGroup)
	{
		FilterCondition filterCondition = new FilterCondition();
		
		if(!getConditions().isEmpty())
			getConditions().get(getConditions().size()-1).setOperator(sqlOperator.name());
  
		filterCondition.setInitGroup(initGroup?GroupOperator.open.toString():null);
		filterCondition.setColumnName(columnName);
		filterCondition.setOperator(operator.name());
		filterCondition.setValue(value);
		filterCondition.setEndGroup(endGroup?GroupOperator.close.toString():null);
		filterCondition.setInternalFilter(true);
		
		getConditions().add(filterCondition);
	}
	
	
	public Object getParamValue(String key)
	{ 
		for (Param param : getParameters()) {
			if(param.getKey().equals(key))
				return param.getValue();
		} 
		return null;
	}
	 
	public List<Param> getParameters() { 
		if(parameters==null) this.parameters = new ArrayList<>(); 
		return parameters;
	}
	public void setParameters(List<Param> parameters) {
		this.parameters = parameters;
	}

	public List<FilterCondition> getConditions() {
		if(this.conditions == null) this.conditions = new ArrayList<>();
		return conditions;
	}

	public void setConditions(List<FilterCondition> conditions) {
		this.conditions = conditions;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	public String getFastsearch() {
		return fastsearch;
	}

	public void setFastsearch(String fastsearch) {
		this.fastsearch = fastsearch;
	}
}
