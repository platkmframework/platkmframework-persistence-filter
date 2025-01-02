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

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/**
 * 	Description: filter for search pagging
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public class Filter<E> {

    /**
     * Atributo page
     */
    @Min(value = 0)
    private int // by default the first
    page = 0;

    /**
     * Atributo pageCount
     */
    @Min(value = 0)
    private int //by default count elements by search
    pageCount = 20;

    /**
     * Atributo order
     */
    @NotBlank
    private String //order column -name,+lastname
    order = "";

    // where conditions a>b and c in(1,2...
    private String conditions = "";

    //fast search
    private String filtertext = "";

    //fast search columns como separator
    private String filtercolumn = "";

    /**
     * Atributo extra
     */
    private E extra;

    /**
     * getPage
     * @return int
     */
    public int getPage() {
        return page;
    }

    /**
     * setPage
     * @param page page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * getPageCount
     * @return int
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * setPageCount
     * @param pageCount pageCount
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * getOrder
     * @return String
     */
    public String getOrder() {
        return order;
    }

    /**
     * setOrder
     * @param order order
     */
    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * getExtra
     * @return E
     */
    public E getExtra() {
        return extra;
    }

    /**
     * setExtra
     * @param extra extra
     */
    public void setExtra(E extra) {
        this.extra = extra;
    }

    /**
     * getConditions
     * @return String
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * setConditions
     * @param conditions conditions
     */
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    /**
     * getFiltertext
     * @return String
     */
    public String getFiltertext() {
        return filtertext;
    }

    /**
     * setFiltertext
     * @param filtertext filtertext
     */
    public void setFiltertext(String filtertext) {
        this.filtertext = filtertext;
    }

    /**
     * getFiltercolumn
     * @return String
     */
    public String getFiltercolumn() {
        return filtercolumn;
    }

    /**
     * setFiltercolumn
     * @param filtercolumn filtercolumn
     */
    public void setFiltercolumn(String filtercolumn) {
        this.filtercolumn = filtercolumn;
    }
}
