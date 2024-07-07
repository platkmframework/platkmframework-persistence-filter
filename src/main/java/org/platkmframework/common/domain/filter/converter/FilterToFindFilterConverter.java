package org.platkmframework.common.domain.filter.converter;

import org.platkmframework.common.domain.filter.criteria.FilterCriteria;
import org.platkmframework.common.domain.filter.criteria.SearchCriteria;
import org.platkmframework.common.domain.filter.criteria.WhereCriteria;
import org.platkmframework.common.domain.filter.exception.FilterException;
import org.platkmframework.common.domain.filter.ui.Filter;

public interface FilterToFindFilterConverter {
	
	public SearchCriteria convertToSearchCriteria(Filter<?> filter) throws FilterException;
	
	public FilterCriteria convertToFilterCriteria(Filter<?> filter) throws FilterException;
	
	public WhereCriteria convertToQueryCriteria(Filter<?> filter) throws FilterException;

}
