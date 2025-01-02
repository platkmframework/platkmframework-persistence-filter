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

import java.io.Serializable;
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
public final class SearchCriteria extends CriteriaBase implements Serializable {

    /**
     * Atributo serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor SearchCriteria
     */
    public SearchCriteria() {
        super();
    }

    /**
     * select
     * @param columns columns
     * @param table table
     * @param alias alias
     * @return SearchCriteria
     */
    public SearchCriteria select(String columns, String table, String alias) {
        getSql().add(new FilterData().addSelectInfo(columns));
        getSql().add(new FilterData().addFromInfo(table, alias));
        return this;
    }

    /**
     * select
     * @param table table
     * @param alias alias
     * @return SearchCriteria
     */
    public SearchCriteria select(String table, String alias) {
        sql.add(new FilterData().addSelectInfo(null));
        sql.add(new FilterData().addFromInfo(table, alias));
        return this;
    }

    /**
     * select
     * @param table table
     * @return SearchCriteria
     */
    public SearchCriteria select(String table) {
        sql.add(new FilterData().addSelectInfo(null));
        sql.add(new FilterData().addFromInfo(table, null));
        return this;
    }

    /**
     * where
     * @return SearchCriteria
     */
    public SearchCriteria where() {
        sql.add(new FilterData(FilterDataType.WHEREINFO));
        wherePresent = true;
        return this;
    }

    /**
     * join
     * @param table table
     * @param tableAlias tableAlias
     * @return SearchCriteria
     */
    public SearchCriteria join(String table, String tableAlias) {
        super.join(table, tableAlias);
        return this;
    }

    /**
     * leftJoin
     * @param table table
     * @param tableAlias tableAlias
     * @return SearchCriteria
     */
    public SearchCriteria leftJoin(String table, String tableAlias) {
        super.leftJoin(table, tableAlias);
        return this;
    }

    /**
     * rightJoin
     * @param table table
     * @param tableAlias tableAlias
     * @return SearchCriteria
     */
    public SearchCriteria rightJoin(String table, String tableAlias) {
        super.rightJoin(table, tableAlias);
        return this;
    }

    /**
     * valexp
     * @param column1 column1
     * @param operator operator
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria valexp(String column1, ConditionOperator operator, Object value) {
        _column(operator, column1, value, false);
        return this;
    }

    /**
     * colexp
     * @param column1 column1
     * @param operator operator
     * @param column2 column2
     * @return SearchCriteria
     */
    public SearchCriteria colexp(String column1, ConditionOperator operator, String column2) {
        super.colexp(column1, operator, column2);
        return this;
    }

    /**
     * eq
     * @param column column
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria eq(String column, Object value) {
        super.eq(column, value);
        return this;
    }

    /**
     * neq
     * @param column column
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria neq(String column, Object value) {
        super.neq(column, value);
        return this;
    }

    /**
     * gt
     * @param column column
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria gt(String column, Object value) {
        super.gt(column, value);
        return this;
    }

    /**
     * ge
     * @param column column
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria ge(String column, Object value) {
        super.ge(column, value);
        return this;
    }

    /**
     * le
     * @param column column
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria le(String column, Object value) {
        super.le(column, value);
        return this;
    }

    /**
     * lt
     * @param column column
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria lt(String column, Object value) {
        super.lt(column, value);
        return this;
    }

    /**
     * in
     * @param column column
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria in(String column, Object value) {
        super.in(column, value);
        return this;
    }

    /**
     * nin
     * @param column column
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria nin(String column, Object value) {
        super.nin(column, value);
        return this;
    }

    /**
     * sw
     * @param column column
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria sw(String column, Object value) {
        super.sw(column, value);
        return this;
    }

    /**
     * ew
     * @param column column
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria ew(String column, Object value) {
        super.ew(column, value);
        return this;
    }

    /**
     * ctn
     * @param column column
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria ctn(String column, Object value) {
        super._column(ConditionOperator.contain, column, value, false);
        return this;
    }

    /**
     * nctn
     * @param column column
     * @param value value
     * @return SearchCriteria
     */
    public SearchCriteria nctn(String column, Object value) {
        super.nctn(column, value);
        return this;
    }

    /**
     * isnull
     * @param column column
     * @return SearchCriteria
     */
    public SearchCriteria isnull(String column) {
        super.isnull(column);
        return this;
    }

    /**
     * isnotnull
     * @param column column
     * @return SearchCriteria
     */
    public SearchCriteria isnotnull(String column) {
        super.isnotnull(column);
        return this;
    }

    /**
     * and
     * @return SearchCriteria
     */
    public SearchCriteria and() {
        super.and();
        return this;
    }

    /**
     * or
     * @return SearchCriteria
     */
    public SearchCriteria or() {
        super.or();
        return this;
    }

    /**
     * cp
     * @return SearchCriteria
     */
    public SearchCriteria cp() {
        super.cp();
        return this;
    }

    /**
     * op
     * @return SearchCriteria
     */
    public SearchCriteria op() {
        super.op();
        return this;
    }

    /**
     * orderBy
     * @param orderColumn orderColumn
     * @param orderType orderType
     * @return SearchCriteria
     */
    public SearchCriteria orderBy(String orderColumn, SqlOrder orderType) {
        super.orderBy(orderColumn, orderType);
        return this;
    }

    /**
     * order
     * @param orderColumn orderColumn
     * @return SearchCriteria
     */
    public SearchCriteria order(String orderColumn) {
        super.order(orderColumn);
        return this;
    }

    /**
     * orderDesc
     * @param orderColumn orderColumn
     * @return SearchCriteria
     */
    public SearchCriteria orderDesc(String orderColumn) {
        super.orderDesc(orderColumn);
        return this;
    }

    /**
     * orderAsc
     * @param orderColumn orderColumn
     * @return SearchCriteria
     */
    public SearchCriteria orderAsc(String orderColumn) {
        super.orderAsc(orderColumn);
        return this;
    }

    /**
     * groupBy
     * @param orderColumn orderColumn
     * @return SearchCriteria
     */
    public SearchCriteria groupBy(String orderColumn) {
        super.groupBy(orderColumn);
        return this;
    }

    /**
     * having
     * @param having having
     * @return SearchCriteria
     */
    public SearchCriteria having(String having) {
        super.having(having);
        return this;
    }

    /**
     * addOffSetInfo
     * @param recordPerPage recordPerPage
     * @param page page
     * @return SearchCriteria
     */
    public SearchCriteria addOffSetInfo(Integer recordPerPage, Integer page) {
        super.addOffSetInfo(recordPerPage, page);
        return this;
    }

    /**
     * addFastSearchInfo
     * @param fastsearch fastsearch
     * @return SearchCriteria
     */
    public SearchCriteria addFastSearchInfo(String fastsearch) {
        super.addFastSearchInfo(fastsearch);
        return this;
    }

    /**
     * isOrderByPresent
     * @return boolean
     */
    public boolean isOrderByPresent() {
        return getSql().stream().filter((c) -> c.getFilterDataType().name().equals(FilterDataType.ORDERBYINFO.name())).findFirst().isPresent();
    }
}
