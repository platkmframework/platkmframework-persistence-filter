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

import java.util.List;
import org.platkmframework.persistence.filter.criteria.base.ConditionFilterBase;
import org.platkmframework.persistence.filter.enumerator.ConditionOperator;
import org.platkmframework.persistence.filter.enumerator.InnerOperator;
import org.platkmframework.persistence.filter.enumerator.SqlOrder;
import org.platkmframework.persistence.filter.info.FilterData;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public abstract class CriteriaBase extends ConditionFilterBase implements CriteriaFunction<ConditionFilterBase> {

    /**
     * Atributo serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Atributo wherePresent
     */
    protected boolean wherePresent;

    /**
     * Constructor CriteriaBase
     * @param sql sql
     */
    protected CriteriaBase(List<FilterData> sql) {
        super(sql);
    }

    /**
     * Constructor CriteriaBase
     */
    protected CriteriaBase() {
        super();
    }

    /**
     * join
     * @param table table
     * @param tableAlias tableAlias
     * @return CriteriaBase
     */
    public CriteriaBase join(String table, String tableAlias) {
        sql.add(new FilterData().addJoinInfo(InnerOperator.inner_join, table, tableAlias));
        return this;
    }

    /**
     * leftJoin
     * @param table table
     * @param tableAlias tableAlias
     * @return CriteriaBase
     */
    public CriteriaBase leftJoin(String table, String tableAlias) {
        sql.add(new FilterData().addJoinInfo(InnerOperator.left_join, table, tableAlias));
        return this;
    }

    /**
     * rightJoin
     * @param table table
     * @param tableAlias tableAlias
     * @return CriteriaBase
     */
    public CriteriaBase rightJoin(String table, String tableAlias) {
        sql.add(new FilterData().addJoinInfo(InnerOperator.right_join, table, tableAlias));
        return this;
    }

    /**
     * valexp
     * @param column1 column1
     * @param operator operator
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase valexp(String column1, ConditionOperator operator, Object value) {
        _column(operator, column1, value, false);
        return this;
    }

    /**
     * colexp
     * @param column1 column1
     * @param operator operator
     * @param column2 column2
     * @return CriteriaBase
     */
    public CriteriaBase colexp(String column1, ConditionOperator operator, String column2) {
        super.colexp(column1, operator, column2);
        return this;
    }

    /**
     * eq
     * @param column column
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase eq(String column, Object value) {
        super._column(ConditionOperator.equal, column, value, false);
        return this;
    }

    /**
     * neq
     * @param column column
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase neq(String column, Object value) {
        super._column(ConditionOperator.notEqual, column, value, false);
        return this;
    }

    /**
     * gt
     * @param column column
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase gt(String column, Object value) {
        super._column(ConditionOperator.greateThan, column, value, false);
        return this;
    }

    /**
     * ge
     * @param column column
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase ge(String column, Object value) {
        super._column(ConditionOperator.greateEqual, column, value, false);
        return this;
    }

    /**
     * le
     * @param column column
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase le(String column, Object value) {
        super._column(ConditionOperator.lessEqual, column, value, false);
        return this;
    }

    /**
     * lt
     * @param column column
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase lt(String column, Object value) {
        super._column(ConditionOperator.lessThan, column, value, false);
        return this;
    }

    /**
     * in
     * @param column column
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase in(String column, Object value) {
        super._column(ConditionOperator.include, column, value, false);
        return this;
    }

    /**
     * nin
     * @param column column
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase nin(String column, Object value) {
        super._column(ConditionOperator.notInclude, column, value, false);
        return this;
    }

    /**
     * sw
     * @param column column
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase sw(String column, Object value) {
        super._column(ConditionOperator.startWith, column, value, false);
        return this;
    }

    /**
     * ew
     * @param column column
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase ew(String column, Object value) {
        super._column(ConditionOperator.endWith, column, value, false);
        return this;
    }

    /**
     * ctn
     * @param column column
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase ctn(String column, Object value) {
        super._column(ConditionOperator.contain, column, value, false);
        return this;
    }

    /**
     * nctn
     * @param column column
     * @param value value
     * @return CriteriaBase
     */
    public CriteriaBase nctn(String column, Object value) {
        super._column(ConditionOperator.notContain, column, value, false);
        return this;
    }

    /**
     * isnull
     * @param column column
     * @return CriteriaBase
     */
    public CriteriaBase isnull(String column) {
        super._column(ConditionOperator.isNull, column, null, false);
        return this;
    }

    /**
     * isnotnull
     * @param column column
     * @return CriteriaBase
     */
    public CriteriaBase isnotnull(String column) {
        super._column(ConditionOperator.isNotNull, column, null, false);
        return this;
    }

    /**
     * and
     * @return CriteriaBase
     */
    public CriteriaBase and() {
        super.and();
        return this;
    }

    /**
     * or
     * @return CriteriaBase
     */
    public CriteriaBase or() {
        super.or();
        return this;
    }

    /**
     * cp
     * @return CriteriaBase
     */
    public CriteriaBase cp() {
        super.cp();
        return this;
    }

    /**
     * op
     * @return CriteriaBase
     */
    public CriteriaBase op() {
        super.op();
        return this;
    }

    /**
     * orderBy
     * @param orderColumn orderColumn
     * @param orderType orderType
     * @return CriteriaBase
     */
    public CriteriaBase orderBy(String orderColumn, SqlOrder orderType) {
        sql.add(new FilterData().addOrderByInfo(orderColumn, orderType));
        return this;
    }

    /**
     * order
     * @param orderColumn orderColumn
     * @return CriteriaBase
     */
    public CriteriaBase order(String orderColumn) {
        sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.asc));
        return this;
    }

    /**
     * orderDesc
     * @param orderColumn orderColumn
     * @return CriteriaBase
     */
    public CriteriaBase orderDesc(String orderColumn) {
        sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.desc));
        return this;
    }

    /**
     * orderAsc
     * @param orderColumn orderColumn
     * @return CriteriaBase
     */
    public CriteriaBase orderAsc(String orderColumn) {
        sql.add(new FilterData().addOrderByInfo(orderColumn, SqlOrder.asc));
        return this;
    }

    /**
     * groupBy
     * @param orderColumn orderColumn
     * @return CriteriaBase
     */
    public CriteriaBase groupBy(String orderColumn) {
        sql.add(new FilterData().addGroupByInfo(orderColumn));
        return this;
    }

    /**
     * having
     * @param having having
     * @return CriteriaBase
     */
    public CriteriaBase having(String having) {
        sql.add(new FilterData().addHavingInfo(having));
        return this;
    }

    /**
     * addOffSetInfo
     * @param recordPerPage recordPerPage
     * @param page page
     * @return CriteriaBase
     */
    public CriteriaBase addOffSetInfo(Integer recordPerPage, Integer page) {
        sql.add(new FilterData().addOffSetInfo(recordPerPage, page));
        return this;
    }

    /**
     * addFastSearchInfo
     * @param fastsearch fastsearch
     * @param columns columns
     * @return CriteriaBase
     */
    public CriteriaBase addFastSearchInfo(String fastsearch, String... columns) {
        sql.add(new FilterData().addFastSearchInfo(fastsearch, columns));
        return this;
    }

    /**
     * isWherePresent
     * @return boolean
     */
    public boolean isWherePresent() {
        return wherePresent;
    }

    /**
     * emptyConditions
     * @return boolean
     */
    public boolean emptyConditions() {
        return getSql().size() == 0;
    }

    /**
     * clear
     */
    public void clear() {
        getSql().clear();
    }
}
