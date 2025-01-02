/**
 * ****************************************************************************
 *  Copyright(c) 2023 the original author Eduardo Iglesias Taylor.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  	 https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Contributors:
 *  	Eduardo Iglesias Taylor - initial API and implementation
 * *****************************************************************************
 */
package org.platkmframework.persistence.filter.ui;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public class FilterCondition {

    /**
     * Atributo initGroup
     */
    @Pattern(regexp = "open")
    private String //
    initGroup;

    /**
     * Atributo fieldCode
     */
    private String fieldCode;

    /**
     * Atributo flabel
     */
    private String flabel;

    /**
     * Atributo columnName
     */
    @NotBlank
    private String columnName;

    /**
     * Atributo columnPrefix
     */
    private String columnPrefix;

    /**
     * Atributo tlabel
     */
    private String tlabel;

    /**
     * Atributo mathOperation
     */
    @Pattern(regexp = "sum|count|min|max|avg")
    private String // COUNT, MAX, MIN, SUM
    mathOperation;

    /**
     * Atributo operator
     */
    @NotBlank
    @Pattern(regexp = "	equal|equal|notEqual,|greateThan|lessThan|greateEqual|lessEqual|include|notInclude,|startWith|endWith,|contain|notContain|isNull|isNotNull")
    private String //condition operator eq, noteq
    operator;

    /**
     * Atributo value
     */
    private Object value;

    /**
     * Atributo endGroup
     */
    @Pattern(regexp = "close")
    private String // GroupOperator
    endGroup;

    /**
     * Atributo soperator
     */
    @Pattern(regexp = "and|or")
    private String //AND OR, from SQL SqlOperator
    soperator;

    /**
     * Atributo tagFieldType
     */
    private String tagFieldType;

    // name = 'petter'
    private String filterColumnOperatorValue;

    /**
     * Atributo filterWhere
     */
    private String filterWhere;

    // hide in FE.it is used to hide the conditions for default
    private boolean hiddenCondition;

    // when the code intercept the search to add custom filter
    private boolean internalFilter;

    /**
     * getFieldCode
     * @return String
     */
    public String getFieldCode() {
        return fieldCode;
    }

    /**
     * setFieldCode
     * @param fieldCode fieldCode
     */
    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    /**
     * getValue
     * @return Object
     */
    public Object getValue() {
        return value;
    }

    /**
     * setValue
     * @param value value
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * getTagFieldType
     * @return String
     */
    public String getTagFieldType() {
        return tagFieldType;
    }

    /**
     * setTagFieldType
     * @param tagFieldType tagFieldType
     */
    public void setTagFieldType(String tagFieldType) {
        this.tagFieldType = tagFieldType;
    }

    /**
     * getColumnName
     * @return String
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * setColumnName
     * @param columnName columnName
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * getFilterColumnOperatorValue
     * @return String
     */
    public String getFilterColumnOperatorValue() {
        return filterColumnOperatorValue;
    }

    /**
     * setFilterColumnOperatorValue
     * @param filterColumnOperatorValue filterColumnOperatorValue
     */
    public void setFilterColumnOperatorValue(String filterColumnOperatorValue) {
        this.filterColumnOperatorValue = filterColumnOperatorValue;
    }

    /**
     * getFilterWhere
     * @return String
     */
    public String getFilterWhere() {
        return filterWhere;
    }

    /**
     * setFilterWhere
     * @param filterWhere filterWhere
     */
    public void setFilterWhere(String filterWhere) {
        this.filterWhere = filterWhere;
    }

    /**
     * isHiddenCondition
     * @return boolean
     */
    public boolean isHiddenCondition() {
        return hiddenCondition;
    }

    /**
     * setHiddenCondition
     * @param hiddenCondition hiddenCondition
     */
    public void setHiddenCondition(boolean hiddenCondition) {
        this.hiddenCondition = hiddenCondition;
    }

    /**
     * isInternalFilter
     * @return boolean
     */
    public boolean isInternalFilter() {
        return internalFilter;
    }

    /**
     * setInternalFilter
     * @param internalFilter internalFilter
     */
    public void setInternalFilter(boolean internalFilter) {
        this.internalFilter = internalFilter;
    }

    /**
     * getOperator
     * @return String
     */
    public String getOperator() {
        return operator;
    }

    /**
     * setOperator
     * @param operator operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * getMathOperation
     * @return String
     */
    public String getMathOperation() {
        return mathOperation;
    }

    /**
     * setMathOperation
     * @param mathOperation mathOperation
     */
    public void setMathOperation(String mathOperation) {
        this.mathOperation = mathOperation;
    }

    /**
     * getSoperator
     * @return String
     */
    public String getSoperator() {
        return soperator;
    }

    /**
     * setSoperator
     * @param soperator soperator
     */
    public void setSoperator(String soperator) {
        this.soperator = soperator;
    }

    /**
     * getInitGroup
     * @return String
     */
    public String getInitGroup() {
        return initGroup;
    }

    /**
     * setInitGroup
     * @param initGroup initGroup
     */
    public void setInitGroup(String initGroup) {
        this.initGroup = initGroup;
    }

    /**
     * getEndGroup
     * @return String
     */
    public String getEndGroup() {
        return endGroup;
    }

    /**
     * setEndGroup
     * @param endGroup endGroup
     */
    public void setEndGroup(String endGroup) {
        this.endGroup = endGroup;
    }

    /**
     * getFlabel
     * @return String
     */
    public String getFlabel() {
        return flabel;
    }

    /**
     * setFlabel
     * @param flabel flabel
     */
    public void setFlabel(String flabel) {
        this.flabel = flabel;
    }

    /**
     * getTlabel
     * @return String
     */
    public String getTlabel() {
        return tlabel;
    }

    /**
     * setTlabel
     * @param tlabel tlabel
     */
    public void setTlabel(String tlabel) {
        this.tlabel = tlabel;
    }

    /**
     * getColumnPrefix
     * @return String
     */
    public String getColumnPrefix() {
        return columnPrefix;
    }

    /**
     * setColumnPrefix
     * @param columnPrefix columnPrefix
     */
    public void setColumnPrefix(String columnPrefix) {
        this.columnPrefix = columnPrefix;
    }
}
