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
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.platkmframework.annotation.db.ESearchFilter;
import org.platkmframework.annotation.db.QSearchFilter;
import org.platkmframework.annotation.db.SearchFilterColumn;
import org.platkmframework.annotation.db.SelectOption;
import org.platkmframework.common.domain.filter.criteria.base.ConditionFilterBase;
import org.platkmframework.common.domain.filter.enumerator.ConditionOperator;
import org.platkmframework.common.domain.filter.enumerator.GroupOperator;
import org.platkmframework.common.domain.filter.enumerator.MathOperator;
import org.platkmframework.common.domain.filter.enumerator.SqlOperator;
import org.platkmframework.common.domain.filter.exception.FilterException;
import org.platkmframework.common.domain.filter.ui.BaseFilter;
import org.platkmframework.common.domain.filter.ui.Filter;
import org.platkmframework.common.domain.filter.ui.FilterCondition;
import org.platkmframework.content.ObjectContainer;


/**
 *   Author: 
 *     Eduardo Iglesias
 *   Contributors: 
 *   	Eduardo Iglesias - initial API and implementation
 **/
public abstract class BaseFilterToFindFilterConverter {
 
	
	private static Logger logger = LoggerFactory.getLogger(BaseFilterToFindFilterConverter.class);
	  
	
	protected ConverterResultData convertByTableCode(Filter filter, ConditionFilterBase findFilter) throws FilterException {
 
		return convert(filter, findFilter);
	}
  
	protected ConverterResultData convert(Filter filter, ConditionFilterBase findFilter ) throws FilterException {
		   
		ConverterResultData converterResultData = new ConverterResultData();
		if(filter == null) return converterResultData;
		 
		processConditions(converterResultData, filter, findFilter); 
		
		return converterResultData;
	}  
	
	protected void processConditions(ConverterResultData converterResultData, Filter filter, ConditionFilterBase findFilter) throws FilterException {
		
		if(StringUtils.isNotBlank(filter.getCode())) {
			SearchFilterData searchFilterData = getSearchMapByCode(filter.getCode());
			if(searchFilterData != null){ 
				Map<String, SearchFilterConditionData>  colMap =  searchFilterData.getSearchMap();
				if(!filter.getConditions().isEmpty() && searchFilterData.getSearchMap() != null && searchFilterData.getSearchMap().size() >0){
					List<String> columns = new ArrayList<>();
					List<String> groupsby = new ArrayList<>();
					String columnName = "";
					MathOperator mathOperator;  
					FilterCondition filterCondition;
					for (int i = 0; i <filter.getConditions().size(); i++)
					{
						filterCondition = filter.getConditions().get(i);
						columnName      = filterCondition.getColumnName();
						
						if(StringUtils.isEmpty(columnName)){
							logger.error("El campo del la condición de búsqueda está vacío searchCode-> " + filter.getCode() + " indice -> " + i);
							throw new FilterException("No están correctas las condiciones de búsqueda");
						}
						 
						if(!colMap.containsKey(columnName)){
							logger.error("El código de la condición de búsqueda no se encuetra en la configuración -> " + filter.getCode() + " codigo -> " + columnName + "indice->" +i);
							throw new FilterException("No están correctas las condiciones de búsqueda");
						}
						
						columnName = colMap.get(columnName).getColumn();
						
						if(StringUtils.isBlank(filterCondition.getColumnPrefix())){
							filterCondition.setColumnName(columnName);
						}else {
							filterCondition.setColumnName(filterCondition.getColumnPrefix() + "." + columnName);
						}
							
						checkCustomFormat(filterCondition);
						
						if(StringUtils.isNotBlank(filterCondition.getMathOperation())) {
							mathOperator = MathOperator.valueOf(filterCondition.getMathOperation()); 
							if(mathOperator == null) throw new FilterException("no se reconoce la operación matemática");
							
							if("sum".equals(mathOperator.name())) {
								columns.add("SUM(" + columnName + ") AS " + columnName);
							}else if("max".equals(mathOperator.name())) {
								columns.add("MAX(" + columnName + ") AS " + columnName);
							}else if("count".equals(mathOperator.name())) {
								columns.add("COUNT(" + columnName + ") AS " + columnName);
							}else if("min".equals(mathOperator.name())) {
								columns.add("MIN(" + columnName + ") AS " + columnName);
							}
							//columns.add(columnName);
							groupsby.add(columnName);
						}
						
						addCondition(findFilter, filterCondition );
					 
					} 
					converterResultData.setSelect(columns.stream().collect(Collectors.joining(",")));
					converterResultData.setGroupBy(groupsby.stream().collect(Collectors.joining(",")));
					//@TODO
					//converterResultData.setHaving(columnName);
				} 
				
				if(StringUtils.isNotBlank(searchFilterData.getFastsearch())){
					converterResultData.setFastSearchValue(filter.getFastsearch());
					converterResultData.setFastSearchColumns(searchFilterData.getFastsearch().split(","));
				}
				
				if(StringUtils.isNotBlank(filter.getOrderColumn()) && colMap.containsKey(filter.getOrderColumn())){
					converterResultData.setDefaultOrderColumn(colMap.get(filter.getOrderColumn()).getColumn());
				}else {
					converterResultData.setDefaultOrderColumn(searchFilterData.getDefaultOrderColumn());
				}
				
				converterResultData.setDefaultOrderType(searchFilterData.getDefaultOrderType());
			}
		}
			 
	 
	}
  

	protected SearchFilterData getSearchMapByCode(String code) throws FilterException {

		Object ob = ObjectContainer.instance().getSearchMapInfo(code);
		if(ob == null) return null;
		if(ob instanceof SelectOption) {
			 ob = ObjectContainer.instance().getSearchMapInfo(((SelectOption)ob).searchCode());
		}
		if(ob == null) return null;
		
		Map<String, SearchFilterConditionData> searchMap = new HashMap<>();
		SearchFilterData searchFilterData;
		if(ob instanceof ESearchFilter) {
			ESearchFilter eSearchFilter = (ESearchFilter)ob;
			searchFilterData = new SearchFilterData(eSearchFilter.fastsearch(), eSearchFilter.orderColumn(), eSearchFilter.orderType());
			for (SearchFilterColumn searchFilterColumn : eSearchFilter.columns()){
				searchMap.put(searchFilterColumn.code(), new SearchFilterConditionData(searchFilterColumn.label(),
						searchFilterColumn.code(), 
						searchFilterColumn.column()));
			}
		}else if(ob instanceof QSearchFilter) {
			QSearchFilter qSearchFilter = (QSearchFilter)ob;
			searchFilterData = new SearchFilterData(qSearchFilter.fastsearch(), qSearchFilter.orderColumn(), qSearchFilter.orderType());
			for (SearchFilterColumn searchFilterColumn : qSearchFilter.columns()){
				searchMap.put(searchFilterColumn.code(), new SearchFilterConditionData(searchFilterColumn.label(),
						searchFilterColumn.code(), 
						searchFilterColumn.column()));
			}
		}else return null;
		
		searchFilterData.setDefaultOrderColumn(searchMap.get(searchFilterData.getDefaultOrderColumn()).getColumn());
		
		searchFilterData.setSearchMap(searchMap);
		return searchFilterData;
	}

	public void addCondition(ConditionFilterBase findFilter, FilterCondition filterCondition) throws FilterException 
	{   
		
		SqlOperator sqlOperator;
		GroupOperator groupOperator;
		ConditionOperator conditionOperator;
		if(StringUtils.isNotBlank(filterCondition.getSoperator())) {
			sqlOperator = SqlOperator.valueOf(filterCondition.getSoperator());
			if(sqlOperator == null) {
				 throw new FilterException("no se encontró el operador");
			}
			
			if(SqlOperator.and.name().equalsIgnoreCase(sqlOperator.name())) {
				findFilter.and();
			}else if(SqlOperator.or.name().equalsIgnoreCase(sqlOperator.name())) {
				findFilter.or();
			} 
			 
		}
		if(StringUtils.isNotBlank(filterCondition.getInitGroup())){
			groupOperator = GroupOperator.valueOf(filterCondition.getInitGroup());
			if(groupOperator == null) throw new FilterException("no se encontró el operador"); 
			if(GroupOperator.open.name().equalsIgnoreCase(groupOperator.name())) {
				findFilter.op();
			}else if(GroupOperator.close.name().equalsIgnoreCase(groupOperator.name())) {
				findFilter.cp();
			}  
		}
		
		if(StringUtils.isNotBlank(filterCondition.getOperator())){
			conditionOperator = ConditionOperator.valueOf(filterCondition.getOperator());
			if(conditionOperator == null) throw new FilterException("no se encontró el operador");
			findFilter.valexp( filterCondition.getColumnName(), conditionOperator, filterCondition.getValue());
		}

		//filter.getSql().add(new FindFilterExpressionInfo(ConditionOperator.valueOf(filterCondition.getOperator()), filterCondition.getColumnName(), validateValue(filterCondition.getValue(), mdTableFields, typeLanguages))); 
		
		//filter.column(filterCondition.getColumnName()).castOperator(filterCondition.getOperator()).value(validateValue(filterCondition.getValue(), mdTableFields, typeLanguages));
		
		if(StringUtils.isNotBlank(filterCondition.getEndGroup())){
			groupOperator = GroupOperator.valueOf(filterCondition.getEndGroup());
			if(groupOperator == null) throw new FilterException("no se encontr� el operador"); 
			if(GroupOperator.open.name().equalsIgnoreCase(groupOperator.name())) {
				findFilter.op();
			}else if(GroupOperator.close.name().equalsIgnoreCase(groupOperator.name())) {
				findFilter.cp();
			} 
		} 	 
	}

	
	protected void checkCustomFormat(FilterCondition filterCondition) 
	{
		if(filterCondition.getValue() != null && filterCondition.getValue().toString().contains(":"))
		{
			String[] arrayFecha = filterCondition.getValue().toString().split(":");
			String   formato    = arrayFecha[0].toString().trim();
			
			if("y".equals(formato)) 
			{
				filterCondition.setValue(arrayFecha[1]);
				filterCondition.setColumnName("YEAR(" + filterCondition.getColumnName() + ")");
			}else if("m".equals(formato)) 
			{
				filterCondition.setValue(arrayFecha[1]);
				filterCondition.setColumnName("MONTH(" + filterCondition.getColumnName() + ")");
			}else if("d".equals(formato)) 
			{
				filterCondition.setValue(arrayFecha[1]);
				filterCondition.setColumnName("DAY(" + filterCondition.getColumnName() + ")");
			} 
		} 
	}
	
	protected List<String> getFieldsCode(BaseFilter filter){
		List<String> list = new ArrayList<>();
		if(filter != null)
			for (FilterCondition filterCondition : filter.getConditions()) 
				if(StringUtils.isNotEmpty(filterCondition.getFieldCode()))
					list.add(filterCondition.getFieldCode());
					  
		return list;
	}
 
	
	
}
