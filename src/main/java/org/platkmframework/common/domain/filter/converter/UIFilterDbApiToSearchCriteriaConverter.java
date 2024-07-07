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
  
import org.apache.commons.lang3.StringUtils;
import org.platkmframework.common.domain.filter.criteria.CriteriaBase;
import org.platkmframework.common.domain.filter.criteria.CriteriaFunction;
import org.platkmframework.common.domain.filter.criteria.FilterCriteria;
import org.platkmframework.common.domain.filter.criteria.SearchCriteria;
import org.platkmframework.common.domain.filter.criteria.WhereCriteria;
import org.platkmframework.common.domain.filter.enumerator.SqlOrder;
import org.platkmframework.common.domain.filter.exception.FilterException;
import org.platkmframework.common.domain.filter.ui.Filter;

/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
	
	public class UIFilterDbApiToSearchCriteriaConverter extends BaseFilterToFindFilterConverter implements FilterToFindFilterConverter{
	  
 
    @Override
	public SearchCriteria convertToSearchCriteria(Filter<?> filter) throws FilterException { 
		
		SearchCriteria searchCriteria = new SearchCriteria(); 
		ConverterResultData converterResultData =  this.convert(filter, searchCriteria); 
		searchCriteria.select(converterResultData.getSelect());
		searchCriteria.groupBy(converterResultData.getGroupBy());
		searchCriteria.having(converterResultData.getHaving());
		updateAdditionals(searchCriteria, filter, converterResultData);
		searchCriteria.setCode(filter.getCode());
		
		return searchCriteria;
	}
	
    @Override
	public FilterCriteria convertToFilterCriteria(Filter<?> filter) throws FilterException {
		
		FilterCriteria filterCriteria = new FilterCriteria();
		ConverterResultData converterResultData =  this.convert(filter, filterCriteria); 
		updateAdditionals(filterCriteria, filter, converterResultData);
		filterCriteria.setCode(filter.getCode());
		
		return filterCriteria;
	}
	
    @Override
	public WhereCriteria convertToQueryCriteria(Filter<?> filter) throws FilterException {
		
		WhereCriteria whereCriteria = new WhereCriteria(); 
		ConverterResultData converterResultData =  this.convert(filter, whereCriteria); 
		updateAdditionals(whereCriteria, filter, converterResultData);
		whereCriteria.setCode(filter.getCode());
		
		return whereCriteria;
	}
 
	protected void updateAdditionals(CriteriaFunction<?> findFilter, Filter<?> filter, ConverterResultData converterResultData) {
		
		//order
		
		if(SqlOrder.asc.name().equals(filter.getOrderType()))
			findFilter.orderBy(converterResultData.getDefaultOrderColumn(),SqlOrder.asc); 
		else if(SqlOrder.desc.name().equals(filter.getOrderType()))
			findFilter.orderBy(converterResultData.getDefaultOrderColumn(),SqlOrder.desc); 
		else {
			findFilter.orderBy(converterResultData.getDefaultOrderColumn(),SqlOrder.valueOf(converterResultData.getDefaultOrderType().toLowerCase())); 
		}
		
		findFilter.addOffSetInfo(filter.getRecordPerPage(), filter.getPage());
		//offset
		//findFilter.setPage(filter.getPage());
		//findFilter.setRecordPerPage(filter.getRecordPerPage());
		   
		//fastsearch
		findFilter.addFastSearchInfo(filter.getFastsearch(), converterResultData.getFastSearchColumns());
 
	}
	
	protected void updateAdditionals(CriteriaBase findFilter, Filter<?> filter, ConverterResultData converterResultData) {
		
		//order
		if(StringUtils.isNotBlank(filter.getOrderType()) && StringUtils.isNotBlank(filter.getOrderColumn())) {
			SqlOrder sqlOrder = SqlOrder.valueOf(filter.getOrderType());
			findFilter.orderBy(filter.getOrderColumn(), sqlOrder); 
		}
			
		findFilter.addOffSetInfo(filter.getRecordPerPage(), filter.getPage());
		//offset
		//findFilter.setPage(filter.getPage());
		//findFilter.setRecordPerPage(filter.getRecordPerPage());
		
		//fastsearch
		findFilter.addFastSearchInfo(filter.getFastsearch(), converterResultData.getFastSearchColumns());
	}

}
