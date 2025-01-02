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
package org.platkmframework.persistence.filter.criteria.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.platkmframework.persistence.filter.info.FilterData;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public class SearchCriteriaVO implements Serializable {

    /**
     * Atributo serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Atributo list
     */
    private List<FilterData> list;

    /**
     * Atributo offSetInfo
     */
    private FilterData offSetInfo;

    /**
     * Atributo fastSearchInfo
     */
    private FilterData fastSearchInfo;

    /**
     * Atributo addtionalDataInfo
     */
    private FilterData addtionalDataInfo;

    /**
     * Atributo orderByInfo
     */
    private FilterData orderByInfo;

    /**
     * Constructor SearchCriteriaVO
     */
    public SearchCriteriaVO() {
        super();
        list = new ArrayList<>();
    }

    /**
     * getList
     * @return List
     */
    public List<FilterData> getList() {
        return list;
    }

    /**
     * setList
     * @param list list
     */
    public void setList(List<FilterData> list) {
        this.list = list;
    }

    /**
     * getOffSetInfo
     * @return FilterData
     */
    public FilterData getOffSetInfo() {
        return offSetInfo;
    }

    /**
     * setOffSetInfo
     * @param offSetInfo offSetInfo
     */
    public void setOffSetInfo(FilterData offSetInfo) {
        this.offSetInfo = offSetInfo;
    }

    /**
     * getFastSearchInfo
     * @return FilterData
     */
    public FilterData getFastSearchInfo() {
        return fastSearchInfo;
    }

    /**
     * setFastSearchInfo
     * @param fastSearchInfo fastSearchInfo
     */
    public void setFastSearchInfo(FilterData fastSearchInfo) {
        this.fastSearchInfo = fastSearchInfo;
    }

    /**
     * getAddtionalDataInfo
     * @return FilterData
     */
    public FilterData getAddtionalDataInfo() {
        return addtionalDataInfo;
    }

    /**
     * setAddtionalDataInfo
     * @param addtionalDataInfo addtionalDataInfo
     */
    public void setAddtionalDataInfo(FilterData addtionalDataInfo) {
        this.addtionalDataInfo = addtionalDataInfo;
    }

    /**
     * getOrderByInfo
     * @return FilterData
     */
    public FilterData getOrderByInfo() {
        return orderByInfo;
    }

    /**
     * setOrderByInfo
     * @param orderByInfo orderByInfo
     */
    public void setOrderByInfo(FilterData orderByInfo) {
        this.orderByInfo = orderByInfo;
    }
}
