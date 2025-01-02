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
package org.platkmframework.persistence.filter.criteria.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.platkmframework.persistence.filter.enumerator.ConditionOperator;
import org.platkmframework.persistence.filter.enumerator.GroupOperator;
import org.platkmframework.persistence.filter.enumerator.SqlOperator;
import org.platkmframework.persistence.filter.info.FilterData;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public abstract class ConditionFilterBase implements ConditionFilter, Serializable {

    /**
     * Atributo serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Atributo sql
     */
    protected List<FilterData> sql;

    /**
     * Atributo code
     */
    protected String code;

    /**
     * Constructor ConditionFilterBase
     * @param sql sql
     */
    public ConditionFilterBase(List<FilterData> sql) {
        this.sql = sql;
    }

    /**
     * Constructor ConditionFilterBase
     */
    public ConditionFilterBase() {
        this.sql = new ArrayList<>();
    }

    /**
     * valexp
     * @param column1 column1
     * @param operator operator
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase valexp(String column1, ConditionOperator operator, Object value) {
        _column(operator, column1, value, false);
        return this;
    }

    /**
     * colexp
     * @param column1 column1
     * @param operator operator
     * @param column2 column2
     * @return ConditionFilterBase
     */
    public ConditionFilterBase colexp(String column1, ConditionOperator operator, String column2) {
        sql.add(new FilterData().addExpressionInfo(column1, operator, column2, true));
        return this;
    }

    /**
     * eq
     * @param column column
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase eq(String column, Object value) {
        return _column(ConditionOperator.equal, column, value, false);
    }

    /**
     * neq
     * @param column column
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase neq(String column, Object value) {
        return _column(ConditionOperator.notEqual, column, value, false);
    }

    /**
     * gt
     * @param column column
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase gt(String column, Object value) {
        return _column(ConditionOperator.greateThan, column, value, false);
    }

    /**
     * ge
     * @param column column
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase ge(String column, Object value) {
        return _column(ConditionOperator.greateEqual, column, value, false);
    }

    /**
     * le
     * @param column column
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase le(String column, Object value) {
        return _column(ConditionOperator.lessEqual, column, value, false);
    }

    /**
     * lt
     * @param column column
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase lt(String column, Object value) {
        return _column(ConditionOperator.lessThan, column, value, false);
    }

    /**
     * in
     * @param column column
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase in(String column, Object value) {
        return _column(ConditionOperator.include, column, value, false);
    }

    /**
     * nin
     * @param column column
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase nin(String column, Object value) {
        return _column(ConditionOperator.notInclude, column, value, false);
    }

    /**
     * sw
     * @param column column
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase sw(String column, Object value) {
        return _column(ConditionOperator.startWith, column, value, false);
    }

    /**
     * ew
     * @param column column
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase ew(String column, Object value) {
        return _column(ConditionOperator.endWith, column, value, false);
    }

    /**
     * ctn
     * @param column column
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase ctn(String column, Object value) {
        return _column(ConditionOperator.contain, column, value, false);
    }

    /**
     * nctn
     * @param column column
     * @param value value
     * @return ConditionFilterBase
     */
    public ConditionFilterBase nctn(String column, Object value) {
        return _column(ConditionOperator.notContain, column, value, false);
    }

    /**
     * isnull
     * @param column column
     * @return ConditionFilterBase
     */
    public ConditionFilterBase isnull(String column) {
        return _column(ConditionOperator.isNull, column, null, false);
    }

    /**
     * isnotnull
     * @param column column
     * @return ConditionFilterBase
     */
    public ConditionFilterBase isnotnull(String column) {
        return _column(ConditionOperator.isNotNull, column, null, false);
    }

    /**
     * _column
     * @param operator operator
     * @param column column
     * @param value value
     * @param valueAsColumn valueAsColumn
     * @return ConditionFilterBase
     */
    protected ConditionFilterBase _column(ConditionOperator operator, String column, Object value, boolean valueAsColumn) {
        sql.add(new FilterData().addExpressionInfo(column, operator, value, valueAsColumn));
        return this;
    }

    /**
     * and
     * @return ConditionFilterBase
     */
    public ConditionFilterBase and() {
        sql.add(getOperatorInfo(SqlOperator.and.name()));
        return this;
    }

    /**
     * or
     * @return ConditionFilterBase
     */
    public ConditionFilterBase or() {
        sql.add(getOperatorInfo(SqlOperator.or.name()));
        return this;
    }

    /**
     * cp
     * @return ConditionFilterBase
     */
    public ConditionFilterBase cp() {
        sql.add(getOperatorInfo(GroupOperator.close.name()));
        return this;
    }

    /**
     * op
     * @return ConditionFilterBase
     */
    public ConditionFilterBase op() {
        sql.add(getOperatorInfo(GroupOperator.open.name()));
        return this;
    }

    /**
     * getOperatorInfo
     * @param operator operator
     * @return FilterData
     */
    protected FilterData getOperatorInfo(String operator) {
        return new FilterData().addOperatorInfo(operator);
    }

    /**
     * getSql
     * @return List
     */
    public List<FilterData> getSql() {
        return sql;
    }

    /**
     * getCode
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     * setCode
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }
}
