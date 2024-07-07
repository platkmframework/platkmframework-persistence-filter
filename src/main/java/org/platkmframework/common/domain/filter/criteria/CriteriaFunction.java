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
package org.platkmframework.common.domain.filter.criteria;

import org.platkmframework.common.domain.filter.enumerator.SqlOrder; 

/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public interface CriteriaFunction<E> {
	
	public E orderBy(String orderColumn, SqlOrder orderType) ;
	
	public E order(String orderColumn);
	
	public E orderDesc(String orderColumn) ;
	
	public E orderAsc(String orderColumn); 	
	
	public E groupBy(String orderColumn);
 
	public E having(String having);
	
	public E addOffSetInfo(Integer recordPerPage, Integer page);
	
	public E addFastSearchInfo(String fastsearch, String... columns);

	public boolean isWherePresent();
	
	public boolean emptyConditions();

	public void clear();

}
