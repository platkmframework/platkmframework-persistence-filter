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

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public class FilterCondition 
{
	@Pattern(regexp = "open")
	private String initGroup; //
	
	private String fieldCode;
	private String flabel;
	
	@NotBlank
	private String columnName;
	private String columnPrefix;
	private String tlabel;
	
	@Pattern(regexp = "sum|count|min|max|avg") 
	private String mathOperation; // COUNT, MAX, MIN, SUM
	
	@NotBlank
	@Pattern(regexp = "	equal|equal|notEqual,|greateThan|lessThan|greateEqual|lessEqual|include|notInclude,|startWith|endWith,|contain|notContain|isNull|isNotNull") 
	private String operator; //condition operator eq, noteq
	
	private Object value;
	
	@Pattern(regexp = "close")
	private String endGroup; // GroupOperator
	
	@Pattern(regexp = "and|or")
	private String soperator; //AND OR, from SQL SqlOperator
	
	private String tagFieldType; 
	private String filterColumnOperatorValue; // name = 'petter'
	private String filterWhere;
	private boolean hiddenCondition; // hide in FE.it is used to hide the conditions for default
	private boolean internalFilter; // when the code intercept the search to add custom filter
	 
 
	public String getFieldCode() {
		return fieldCode;
	}
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}

	public String getTagFieldType() {
		return tagFieldType;
	}
	public void setTagFieldType(String tagFieldType) {
		this.tagFieldType = tagFieldType;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getFilterColumnOperatorValue() {
		return filterColumnOperatorValue;
	}
	public void setFilterColumnOperatorValue(String filterColumnOperatorValue) {
		this.filterColumnOperatorValue = filterColumnOperatorValue;
	}
	public String getFilterWhere() {
		return filterWhere;
	}
	public void setFilterWhere(String filterWhere) {
		this.filterWhere = filterWhere;
	}
	public boolean isHiddenCondition() {
		return hiddenCondition;
	}
	public void setHiddenCondition(boolean hiddenCondition) {
		this.hiddenCondition = hiddenCondition;
	}
	public boolean isInternalFilter() {
		return internalFilter;
	}
	public void setInternalFilter(boolean internalFilter) {
		this.internalFilter = internalFilter;
	}
 
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
 
	public String getMathOperation() {
		return mathOperation;
	}
	public void setMathOperation(String mathOperation) {
		this.mathOperation = mathOperation;
	}
	public String getSoperator() {
		return soperator;
	}
	public void setSoperator(String soperator) {
		this.soperator = soperator;
	}
	public String getInitGroup() {
		return initGroup;
	}
	public void setInitGroup(String initGroup) {
		this.initGroup = initGroup;
	}
	public String getEndGroup() {
		return endGroup;
	}
	public void setEndGroup(String endGroup) {
		this.endGroup = endGroup;
	}
	public String getFlabel() {
		return flabel;
	}
	public void setFlabel(String flabel) {
		this.flabel = flabel;
	}
	public String getTlabel() {
		return tlabel;
	}
	public void setTlabel(String tlabel) {
		this.tlabel = tlabel;
	}
	public String getColumnPrefix() {
		return columnPrefix;
	}
	public void setColumnPrefix(String columnPrefix) {
		this.columnPrefix = columnPrefix;
	}
		
	
}
