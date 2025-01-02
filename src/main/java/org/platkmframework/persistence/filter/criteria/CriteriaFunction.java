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

import org.platkmframework.persistence.filter.enumerator.SqlOrder;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public interface CriteriaFunction<E> {

    /**
     * orderBy
     * @param orderColumn orderColumn
     * @param orderType orderType
     * @return E
     */
    public E orderBy(String orderColumn, SqlOrder orderType);

    /**
     * order
     * @param orderColumn orderColumn
     * @return E
     */
    public E order(String orderColumn);

    /**
     * orderDesc
     * @param orderColumn orderColumn
     * @return E
     */
    public E orderDesc(String orderColumn);

    /**
     * orderAsc
     * @param orderColumn orderColumn
     * @return E
     */
    public E orderAsc(String orderColumn);

    /**
     * groupBy
     * @param orderColumn orderColumn
     * @return E
     */
    public E groupBy(String orderColumn);

    /**
     * having
     * @param having having
     * @return E
     */
    public E having(String having);

    /**
     * addOffSetInfo
     * @param recordPerPage recordPerPage
     * @param page page
     * @return E
     */
    public E addOffSetInfo(Integer recordPerPage, Integer page);

    /**
     * addFastSearchInfo
     * @param fastsearch fastsearch
     * @param columns columns
     * @return E
     */
    public E addFastSearchInfo(String fastsearch, String... columns);

    /**
     * isWherePresent
     * @return boolean
     */
    public boolean isWherePresent();

    /**
     * emptyConditions
     * @return boolean
     */
    public boolean emptyConditions();

    /**
     * clear
     */
    public void clear();
}
