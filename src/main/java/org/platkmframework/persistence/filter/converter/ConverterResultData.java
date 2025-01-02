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
package org.platkmframework.persistence.filter.converter;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public class ConverterResultData {

    /**
     * Atributo select
     */
    private String select;

    /**
     * Atributo groupBy
     */
    private String groupBy;

    /**
     * Atributo having
     */
    private String having;

    /**
     * Atributo fastSearchValue
     */
    private String fastSearchValue;

    /**
     * Atributo fastSearchColumns
     */
    private String[] fastSearchColumns;

    /**
     * Atributo defaultOrderColumn
     */
    private String defaultOrderColumn;

    /**
     * Atributo defaultOrderType
     */
    private String defaultOrderType;

    /**
     * Constructor ConverterResultData
     */
    public ConverterResultData() {
        super();
        select = null;
        groupBy = null;
    }

    /**
     * getSelect
     * @return String
     */
    public String getSelect() {
        return select;
    }

    /**
     * setSelect
     * @param select select
     */
    public void setSelect(String select) {
        this.select = select;
    }

    /**
     * getGroupBy
     * @return String
     */
    public String getGroupBy() {
        return groupBy;
    }

    /**
     * setGroupBy
     * @param groupBy groupBy
     */
    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    /**
     * getHaving
     * @return String
     */
    public String getHaving() {
        return having;
    }

    /**
     * setHaving
     * @param having having
     */
    public void setHaving(String having) {
        this.having = having;
    }

    /**
     * getFastSearchValue
     * @return String
     */
    public String getFastSearchValue() {
        return fastSearchValue;
    }

    /**
     * setFastSearchValue
     * @param fastSearchValue fastSearchValue
     */
    public void setFastSearchValue(String fastSearchValue) {
        this.fastSearchValue = fastSearchValue;
    }

    /**
     * getFastSearchColumns
     * @return String[]
     */
    public String[] getFastSearchColumns() {
        return fastSearchColumns;
    }

    /**
     * setFastSearchColumns
     * @param fastSearchColumns fastSearchColumns
     */
    public void setFastSearchColumns(String[] fastSearchColumns) {
        this.fastSearchColumns = fastSearchColumns;
    }

    /**
     * getDefaultOrderColumn
     * @return String
     */
    public String getDefaultOrderColumn() {
        return defaultOrderColumn;
    }

    /**
     * setDefaultOrderColumn
     * @param defaultOrderColumn defaultOrderColumn
     */
    public void setDefaultOrderColumn(String defaultOrderColumn) {
        this.defaultOrderColumn = defaultOrderColumn;
    }

    /**
     * getDefaultOrderType
     * @return String
     */
    public String getDefaultOrderType() {
        return defaultOrderType;
    }

    /**
     * setDefaultOrderType
     * @param defaultOrderType defaultOrderType
     */
    public void setDefaultOrderType(String defaultOrderType) {
        this.defaultOrderType = defaultOrderType;
    }
}
