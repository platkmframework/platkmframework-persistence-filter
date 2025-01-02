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
package org.platkmframework.persistence.filter.criteria;

import java.util.ArrayList;
import java.util.List;
import org.platkmframework.persistence.filter.criteria.base.ConditionFilterBase;
import org.platkmframework.persistence.filter.enumerator.ConditionOperator;
import org.platkmframework.persistence.filter.enumerator.SqlOrder;
import org.platkmframework.persistence.filter.info.FilterData;
import org.platkmframework.persistence.filter.info.FilterDataType;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public final class WhereCriteria extends ConditionFilterBase implements CriteriaFunction<WhereCriteria> {

    /**
     * Atributo serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Atributo arguments
     */
    private List<String> arguments;

    /**
     * Constructor WhereCriteria
     */
    public WhereCriteria() {
        super();
        where();
    }

    /**
     * where
     * @return WhereCriteria
     */
    protected WhereCriteria where() {
        sql.add(new FilterData(FilterDataType.WHEREINFO));
        return this;
    }

    /**
     * valexp
     * @param column1 column1
     * @param operator operator
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria valexp(String column1, ConditionOperator operator, Object value) {
        _column(operator, column1, value, false);
        return this;
    }

    /**
     * colexp
     * @param column1 column1
     * @param operator operator
     * @param column2 column2
     * @return WhereCriteria
     */
    public WhereCriteria colexp(String column1, ConditionOperator operator, String column2) {
        super.colexp(column1, operator, column2);
        return this;
    }

    /**
     * eq
     * @param column column
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria eq(String column, Object value) {
        super._column(ConditionOperator.equal, column, value, false);
        return this;
    }

    /**
     * neq
     * @param column column
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria neq(String column, Object value) {
        super._column(ConditionOperator.notEqual, column, value, false);
        return this;
    }

    /**
     * gt
     * @param column column
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria gt(String column, Object value) {
        super._column(ConditionOperator.greateThan, column, value, false);
        return this;
    }

    /**
     * ge
     * @param column column
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria ge(String column, Object value) {
        super._column(ConditionOperator.greateEqual, column, value, false);
        return this;
    }

    /**
     * le
     * @param column column
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria le(String column, Object value) {
        super._column(ConditionOperator.lessEqual, column, value, false);
        return this;
    }

    /**
     * lt
     * @param column column
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria lt(String column, Object value) {
        super._column(ConditionOperator.lessThan, column, value, false);
        return this;
    }

    /**
     * in
     * @param column column
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria in(String column, Object value) {
        super._column(ConditionOperator.include, column, value, false);
        return this;
    }

    /**
     * nin
     * @param column column
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria nin(String column, Object value) {
        super._column(ConditionOperator.notInclude, column, value, false);
        return this;
    }

    /**
     * sw
     * @param column column
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria sw(String column, Object value) {
        super._column(ConditionOperator.startWith, column, value, false);
        return this;
    }

    /**
     * ew
     * @param column column
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria ew(String column, Object value) {
        super._column(ConditionOperator.endWith, column, value, false);
        return this;
    }

    /**
     * ctn
     * @param column column
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria ctn(String column, Object value) {
        super._column(ConditionOperator.contain, column, value, false);
        return this;
    }

    /**
     * nctn
     * @param column column
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria nctn(String column, Object value) {
        super._column(ConditionOperator.notContain, column, value, false);
        return this;
    }

    /**
     * isnull
     * @param column column
     * @return WhereCriteria
     */
    public WhereCriteria isnull(String column) {
        super._column(ConditionOperator.isNull, column, null, false);
        return this;
    }

    /**
     * isnotnull
     * @param column column
     * @return WhereCriteria
     */
    public WhereCriteria isnotnull(String column) {
        super._column(ConditionOperator.isNotNull, column, null, false);
        return this;
    }

    /**
     * and
     * @return WhereCriteria
     */
    public WhereCriteria and() {
        super.and();
        return this;
    }

    /**
     * or
     * @return WhereCriteria
     */
    public WhereCriteria or() {
        super.or();
        return this;
    }

    /**
     * cp
     * @return WhereCriteria
     */
    public WhereCriteria cp() {
        super.cp();
        return this;
    }

    /**
     * op
     * @return WhereCriteria
     */
    public WhereCriteria op() {
        super.op();
        return this;
    }

    /**
     * orderBy
     * @param orderColumn orderColumn
     * @param orderType orderType
     * @return WhereCriteria
     */
    public WhereCriteria orderBy(String orderColumn, SqlOrder orderType) {
        sql.add(new FilterData().addOrderByInfo(orderColumn, orderType));
        return this;
    }

    /**
     * groupBy
     * @param orderColumn orderColumn
     * @return WhereCriteria
     */
    public WhereCriteria groupBy(String orderColumn) {
        sql.add(new FilterData().addGroupByInfo(orderColumn));
        return this;
    }

    /**
     * having
     * @param having having
     * @return WhereCriteria
     */
    public WhereCriteria having(String having) {
        sql.add(new FilterData().addHavingInfo(having));
        return this;
    }

    /**
     * addOffSetInfo
     * @param recordPerPage recordPerPage
     * @param page page
     * @return WhereCriteria
     */
    public WhereCriteria addOffSetInfo(Integer recordPerPage, Integer page) {
        sql.add(new FilterData().addOffSetInfo(recordPerPage, page));
        return this;
    }

    /**
     * getArguments
     * @return List
     */
    public List<String> getArguments() {
        if (arguments == null)
            arguments = new ArrayList<>();
        return arguments;
    }

    /**
     * addArguments
     * @param key key
     * @param value value
     * @return WhereCriteria
     */
    public WhereCriteria addArguments(String key, Object value) {
        getArguments().add(key + "=" + value);
        return this;
    }

    /**
     * addFastSearchInfo
     * @param value value
     * @param columns columns
     * @return WhereCriteria
     */
    public WhereCriteria addFastSearchInfo(String value, String... columns) {
        sql.add(new FilterData().addFastSearchInfo(value, columns));
        return this;
    }

    /**
     * emptyConditions
     * @return boolean
     */
    public boolean emptyConditions() {
        FilterData filterData = getSql().stream().filter((obj -> ((FilterData) obj).isType(FilterDataType.EXPRESSIONINFO) || ((FilterData) obj).isType(FilterDataType.VALUEINFO) || ((FilterData) obj).isType(FilterDataType.OPERATORINFO))).findAny().orElse(null);
        return filterData == null;
    }

    /**
     * clear
     */
    public void clear() {
        getSql().clear();
    }

    /**
     * order
     * @param orderColumn orderColumn
     * @return WhereCriteria
     */
    @Override
    public WhereCriteria order(String orderColumn) {
        sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.asc));
        return this;
    }

    /**
     * orderDesc
     * @param orderColumn orderColumn
     * @return WhereCriteria
     */
    @Override
    public WhereCriteria orderDesc(String orderColumn) {
        return orderBy(orderColumn, SqlOrder.desc);
    }

    /**
     * orderAsc
     * @param orderColumn orderColumn
     * @return WhereCriteria
     */
    @Override
    public WhereCriteria orderAsc(String orderColumn) {
        return orderBy(orderColumn, SqlOrder.asc);
    }

    /**
     * isWherePresent
     * @return boolean
     */
    @Override
    public boolean isWherePresent() {
        return true;
    }
}
