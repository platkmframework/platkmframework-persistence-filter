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

import org.platkmframework.persistence.filter.enumerator.ConditionOperator;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public interface ConditionFilter {

    /**
     * valexp
     * @param column1 column1
     * @param operator operator
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter valexp(String column1, ConditionOperator operator, Object value);

    /**
     * colexp
     * @param column1 column1
     * @param operator operator
     * @param column2 column2
     * @return ConditionFilter
     */
    public ConditionFilter colexp(String column1, ConditionOperator operator, String column2);

    /**
     * eq
     * @param column column
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter eq(String column, Object value);

    /**
     * neq
     * @param column column
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter neq(String column, Object value);

    /**
     * gt
     * @param column column
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter gt(String column, Object value);

    /**
     * ge
     * @param column column
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter ge(String column, Object value);

    /**
     * le
     * @param column column
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter le(String column, Object value);

    /**
     * lt
     * @param column column
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter lt(String column, Object value);

    /**
     * in
     * @param column column
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter in(String column, Object value);

    /**
     * nin
     * @param column column
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter nin(String column, Object value);

    /**
     * sw
     * @param column column
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter sw(String column, Object value);

    /**
     * ew
     * @param column column
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter ew(String column, Object value);

    /**
     * ctn
     * @param column column
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter ctn(String column, Object value);

    /**
     * nctn
     * @param column column
     * @param value value
     * @return ConditionFilter
     */
    public ConditionFilter nctn(String column, Object value);

    /**
     * isnull
     * @param column column
     * @return ConditionFilter
     */
    public ConditionFilter isnull(String column);

    /**
     * isnotnull
     * @param column column
     * @return ConditionFilter
     */
    public ConditionFilter isnotnull(String column);

    /**
     * and
     * @return ConditionFilter
     */
    public ConditionFilter and();

    /**
     * or
     * @return ConditionFilter
     */
    public ConditionFilter or();

    /**
     * cp
     * @return ConditionFilter
     */
    public ConditionFilter cp();

    /**
     * op
     * @return ConditionFilter
     */
    public ConditionFilter op();
}
