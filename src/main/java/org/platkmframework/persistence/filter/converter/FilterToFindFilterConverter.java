package org.platkmframework.persistence.filter.converter;

import org.platkmframework.persistence.filter.criteria.FilterCriteria;
import org.platkmframework.persistence.filter.criteria.SearchCriteria;
import org.platkmframework.persistence.filter.criteria.WhereCriteria;
import org.platkmframework.persistence.filter.exception.FilterException;
import org.platkmframework.persistence.filter.ui.Filter;

public interface FilterToFindFilterConverter {

    /**
     * convertToSearchCriteria
     * @param filter filter
     * @return SearchCriteria
     * @throws FilterException FilterException
     */
    public SearchCriteria convertToSearchCriteria(Filter<?> filter) throws FilterException;

    /**
     * convertToFilterCriteria
     * @param filter filter
     * @return FilterCriteria
     * @throws FilterException FilterException
     */
    public FilterCriteria convertToFilterCriteria(Filter<?> filter) throws FilterException;

    /**
     * convertToQueryCriteria
     * @param filter filter
     * @return WhereCriteria
     * @throws FilterException FilterException
     */
    public WhereCriteria convertToQueryCriteria(Filter<?> filter) throws FilterException;
}
