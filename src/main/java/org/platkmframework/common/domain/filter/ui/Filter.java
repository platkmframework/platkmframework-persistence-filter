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
package org.platkmframework.common.domain.filter.ui;

import org.platkmframework.common.domain.filter.enumerator.SqlOrder;

import jakarta.validation.constraints.Min; 
/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public class Filter<E>  extends BaseFilter{
	
	@Min(value = 0)
	private int page           = 0; // by default the firts
	
	@Min(value = 0)
	private int recordPerPage  = 20; //by default
	
	//@NotBlank
	private String orderColumn = "";
	
	//@Pattern(regexp = "asc|desc")
	//@NotBlank
	private String orderType = SqlOrder.asc.name(); 
	
	private E  extra;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	} 

	public E getExtra() {
		return extra;
	}

	public void setExtra(E extra) {
		this.extra = extra;
	}
 
	
	
}
