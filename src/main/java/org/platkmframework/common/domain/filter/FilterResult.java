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
package org.platkmframework.common.domain.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public class FilterResult<F>  implements Serializable {
	 
		private static final long serialVersionUID = 1L;

	private int page; 
	private long pageCount; //(all record filtered / recordPerPage)
	private List<F> list = new ArrayList<>();
	private List<String> columns = new ArrayList<>();
	private List<String> labels  = new ArrayList<>();;
	private Object extra;
	
	public List<F> getList() 
	{
		if(list == null)
			this.list= new ArrayList<>();
		return list;
	}

	public void setList(List<F> list) {
		this.list = list;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public List<String> getColumns() {
		if(columns == null) this.columns= new ArrayList<>();
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public List<String> getLabels() {
		if(labels == null)
			labels = new ArrayList<>();
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}
	
}
