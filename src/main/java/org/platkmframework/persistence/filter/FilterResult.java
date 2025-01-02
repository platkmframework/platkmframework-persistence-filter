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
package org.platkmframework.persistence.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public class FilterResult<F> implements Serializable {

    /**
     * Atributo serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Atributo page
     */
    private int page;

    //(all record filtered / recordPerPage)
    private long pageCount;

    /**
     * Atributo list
     */
    private List<F> list = new ArrayList<>();

    /**
     * Atributo columns
     */
    private List<String> columns = new ArrayList<>();

    /**
     * Atributo labels
     */
    private List<String> labels = new ArrayList<>();

    /**
     * Atributo extra
     */
    private Object extra;

    /**
     * getList
     * @return List
     */
    public List<F> getList() {
        if (list == null)
            this.list = new ArrayList<>();
        return list;
    }

    /**
     * setList
     * @param list list
     */
    public void setList(List<F> list) {
        this.list = list;
    }

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
     * @return long
     */
    public long getPageCount() {
        return pageCount;
    }

    /**
     * setPageCount
     * @param pageCount pageCount
     */
    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * getColumns
     * @return List
     */
    public List<String> getColumns() {
        if (columns == null)
            this.columns = new ArrayList<>();
        return columns;
    }

    /**
     * setColumns
     * @param columns columns
     */
    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    /**
     * getLabels
     * @return List
     */
    public List<String> getLabels() {
        if (labels == null)
            labels = new ArrayList<>();
        return labels;
    }

    /**
     * setLabels
     * @param labels labels
     */
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    /**
     * getExtra
     * @return Object
     */
    public Object getExtra() {
        return extra;
    }

    /**
     * setExtra
     * @param extra extra
     */
    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
