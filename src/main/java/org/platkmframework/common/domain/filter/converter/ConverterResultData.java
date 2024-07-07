/*******************************************************************************
 * Copyright(c) 2023 the original author Eduardo Iglesias Taylor.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	 https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * 	Eduardo Iglesias Taylor - initial API and implementation
 *******************************************************************************/
package org.platkmframework.common.domain.filter.converter;

/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public class ConverterResultData {
	
	private String select;
	private String groupBy;
	private String having;
	private String fastSearchValue;
	private String[] fastSearchColumns;
	private String defaultOrderColumn;
	private String defaultOrderType;
	
	
	public ConverterResultData() {
		super();
		select = null;
		groupBy = null;
	}
	
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public String getGroupBy() {
		return groupBy;
	}
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

	public String getHaving() {
		return having;
	}

	public void setHaving(String having) {
		this.having = having;
	}

	public String getFastSearchValue() {
		return fastSearchValue;
	}

	public void setFastSearchValue(String fastSearchValue) {
		this.fastSearchValue = fastSearchValue;
	}

	public String[] getFastSearchColumns() { 
		return fastSearchColumns;
	}

	public void setFastSearchColumns(String[] fastSearchColumns) {
		this.fastSearchColumns = fastSearchColumns;
	}

	 
	public String getDefaultOrderColumn() {
		return defaultOrderColumn;
	}

	public void setDefaultOrderColumn(String defaultOrderColumn) {
		this.defaultOrderColumn = defaultOrderColumn;
	}

	public String getDefaultOrderType() {
		return defaultOrderType;
	}

	public void setDefaultOrderType(String defaultOrderType) {
		this.defaultOrderType = defaultOrderType;
	}
	

}
