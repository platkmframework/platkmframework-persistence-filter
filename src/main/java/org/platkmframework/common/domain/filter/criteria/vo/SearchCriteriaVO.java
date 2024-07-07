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
package org.platkmframework.common.domain.filter.criteria.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.platkmframework.common.domain.filter.info.FilterData;
 


/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public class SearchCriteriaVO implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private List<FilterData> list;
	
	private FilterData offSetInfo;
	
	private FilterData fastSearchInfo;
	
	private FilterData addtionalDataInfo;
	
	private FilterData orderByInfo;
 
	public SearchCriteriaVO() {
		super();
		list = new ArrayList<>();
	}

	public List<FilterData> getList() {
		return list;
	}

	public void setList(List<FilterData> list) {
		this.list = list;
	}

	public FilterData getOffSetInfo() {
		return offSetInfo;
	}

	public void setOffSetInfo(FilterData offSetInfo) {
		this.offSetInfo = offSetInfo;
	}

	public FilterData getFastSearchInfo() {
		return fastSearchInfo;
	}

	public void setFastSearchInfo(FilterData fastSearchInfo) {
		this.fastSearchInfo = fastSearchInfo;
	}

	public FilterData getAddtionalDataInfo() {
		return addtionalDataInfo;
	}

	public void setAddtionalDataInfo(FilterData addtionalDataInfo) {
		this.addtionalDataInfo = addtionalDataInfo;
	}

	public FilterData getOrderByInfo() {
		return orderByInfo;
	}

	public void setOrderByInfo(FilterData orderByInfo) {
		this.orderByInfo = orderByInfo;
	}
	
 
	
}
