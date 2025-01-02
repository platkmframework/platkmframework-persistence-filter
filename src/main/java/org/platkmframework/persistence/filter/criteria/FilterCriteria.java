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

import java.util.Arrays;
import org.platkmframework.persistence.filter.criteria.base.ConditionFilter;
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
public final class FilterCriteria extends ConditionFilterBase implements ConditionFilter, CriteriaFunction<FilterCriteria> {

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor FilterCriteria
     */
    public FilterCriteria() {
        super();
        selectInitWhere(null, null, null);
    }

    /**
     * Constructor FilterCriteria
     * @param alias alias
     */
    public FilterCriteria(String alias) {
        super();
        selectInitWhere(null, null, alias);
    }

    /**
     * selectInitWhere
     * @param columns columns
     * @param table table
     * @param alias alias
     */
    private void selectInitWhere(String columns, String table, String alias) {
        getSql().add(new FilterData().addSelectInfo(columns));
        getSql().add(new FilterData().addFromInfo(table, alias));
        where();
    }

    /**
     * where
     * @return FilterCriteria
     */
    private FilterCriteria where() {
        sql.add(new FilterData(FilterDataType.WHEREINFO));
        return this;
    }

    /**
     * valexp
     * @param column1 column1
     * @param operator operator
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria valexp(String column1, ConditionOperator operator, Object value) {
        _column(operator, column1, value, false);
        return this;
    }

    /**
     * colexp
     * @param column1 column1
     * @param operator operator
     * @param column2 column2
     * @return FilterCriteria
     */
    public FilterCriteria colexp(String column1, ConditionOperator operator, String column2) {
        super.colexp(column1, operator, column2);
        return this;
    }

    /**
     * eq
     * @param column column
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria eq(String column, Object value) {
        super._column(ConditionOperator.equal, column, value, false);
        return this;
    }

    /**
     * neq
     * @param column column
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria neq(String column, Object value) {
        super._column(ConditionOperator.notEqual, column, value, false);
        return this;
    }

    /**
     * gt
     * @param column column
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria gt(String column, Object value) {
        super._column(ConditionOperator.greateThan, column, value, false);
        return this;
    }

    /**
     * ge
     * @param column column
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria ge(String column, Object value) {
        super._column(ConditionOperator.greateEqual, column, value, false);
        return this;
    }

    /**
     * le
     * @param column column
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria le(String column, Object value) {
        super._column(ConditionOperator.lessEqual, column, value, false);
        return this;
    }

    /**
     * lt
     * @param column column
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria lt(String column, Object value) {
        super._column(ConditionOperator.lessThan, column, value, false);
        return this;
    }

    /**
     * in
     * @param column column
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria in(String column, Object value) {
        super._column(ConditionOperator.include, column, value, false);
        return this;
    }

    /**
     * nin
     * @param column column
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria nin(String column, Object value) {
        super._column(ConditionOperator.notInclude, column, value, false);
        return this;
    }

    /**
     * sw
     * @param column column
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria sw(String column, Object value) {
        super._column(ConditionOperator.startWith, column, value, false);
        return this;
    }

    /**
     * ew
     * @param column column
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria ew(String column, Object value) {
        super._column(ConditionOperator.endWith, column, value, false);
        return this;
    }

    /**
     * ctn
     * @param column column
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria ctn(String column, Object value) {
        super._column(ConditionOperator.contain, column, value, false);
        return this;
    }

    /**
     * nctn
     * @param column column
     * @param value value
     * @return FilterCriteria
     */
    public FilterCriteria nctn(String column, Object value) {
        super._column(ConditionOperator.notContain, column, value, false);
        return this;
    }

    /**
     * isnull
     * @param column column
     * @return FilterCriteria
     */
    public FilterCriteria isnull(String column) {
        super._column(ConditionOperator.isNull, column, null, false);
        return this;
    }

    /**
     * isnotnull
     * @param column column
     * @return FilterCriteria
     */
    public FilterCriteria isnotnull(String column) {
        super._column(ConditionOperator.isNotNull, column, null, false);
        return this;
    }

    /**
     * and
     * @return FilterCriteria
     */
    public FilterCriteria and() {
        super.and();
        return this;
    }

    /**
     * or
     * @return FilterCriteria
     */
    public FilterCriteria or() {
        super.or();
        return this;
    }

    /**
     * cp
     * @return FilterCriteria
     */
    public FilterCriteria cp() {
        super.cp();
        return this;
    }

    /**
     * op
     * @return FilterCriteria
     */
    public FilterCriteria op() {
        super.op();
        return this;
    }

    /**
     * orderBy
     * @param orderColumn orderColumn
     * @param orderType orderType
     * @return FilterCriteria
     */
    public FilterCriteria orderBy(String orderColumn, SqlOrder orderType) {
        sql.add(new FilterData().addOrderByInfo(orderColumn, orderType));
        return this;
    }

    /**
     * order
     * @param orderColumn orderColumn
     * @return FilterCriteria
     */
    public FilterCriteria order(String orderColumn) {
        sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.asc));
        return this;
    }

    /**
     * orderDesc
     * @param orderColumn orderColumn
     * @return FilterCriteria
     */
    public FilterCriteria orderDesc(String orderColumn) {
        sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.desc));
        return this;
    }

    /**
     * orderAsc
     * @param orderColumn orderColumn
     * @return FilterCriteria
     */
    public FilterCriteria orderAsc(String orderColumn) {
        sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.asc));
        return this;
    }

    /**
     * groupBy
     * @param orderColumn orderColumn
     * @return FilterCriteria
     */
    public FilterCriteria groupBy(String orderColumn) {
        sql.add(new FilterData().addGroupByInfo(orderColumn));
        return this;
    }

    /**
     * having
     * @param having having
     * @return FilterCriteria
     */
    public FilterCriteria having(String having) {
        sql.add(new FilterData().addHavingInfo(having));
        return this;
    }

    /**
     * addOffSetInfo
     * @param recordPerPage recordPerPage
     * @param page page
     * @return FilterCriteria
     */
    public FilterCriteria addOffSetInfo(Integer recordPerPage, Integer page) {
        sql.add(new FilterData().addOffSetInfo(recordPerPage, page));
        return this;
    }

    /**
     * addFastSearchInfo
     * @param value value
     * @param columns columns
     * @return FilterCriteria
     */
    public FilterCriteria addFastSearchInfo(String value, String... columns) {
        sql.add(new FilterData().addFastSearchInfo(value, columns));
        return this;
    }

    /**
     * addFastSearchInfoColumns
     * @param columns columns
     */
    public void addFastSearchInfoColumns(String[] columns) {
        FilterData filterData = sql.stream().filter((obj -> ((FilterData) obj).isType(FilterDataType.FASTSEARCHINFO))).findAny().orElse(null);
        if (filterData != null) {
            filterData.setFastSearchList(Arrays.asList(columns));
        }
    }

    /**
     * emptyConditions
     * @return boolean
     */
    public boolean emptyConditions() {
        FilterData filterData = getSql().stream().filter((obj -> ((FilterData) obj).isType(FilterDataType.WHEREINFO))).findAny().orElse(null);
        if (filterData == null)
            return true;
        int post = getSql().indexOf(filterData) + 1;
        if (post <= getSql().size()) {
            //List<FilterData> list = getSql().subList(2, getSql().size() -1);
            filterData = getSql().stream().filter((obj -> ((FilterData) obj).isType(FilterDataType.EXPRESSIONINFO) || ((FilterData) obj).isType(FilterDataType.VALUEINFO) || ((FilterData) obj).isType(FilterDataType.OPERATORINFO))).findAny().orElse(null);
            return filterData == null;
        } else
            return true;
    }

    /**
     * isWherePresent
     * @return boolean
     */
    @Override
    public boolean isWherePresent() {
        return true;
    }

    /**
     * clear
     */
    @Override
    public void clear() {
        getSql().clear();
    }
}
