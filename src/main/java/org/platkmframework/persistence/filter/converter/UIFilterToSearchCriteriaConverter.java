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

import org.apache.commons.lang3.StringUtils;
import org.platkmframework.persistence.filter.criteria.CriteriaFunction;
import org.platkmframework.persistence.filter.criteria.FilterCriteria;
import org.platkmframework.persistence.filter.criteria.SearchCriteria;
import org.platkmframework.persistence.filter.criteria.WhereCriteria;
import org.platkmframework.persistence.filter.criteria.base.ConditionFilterBase;
import org.platkmframework.persistence.filter.enumerator.SqlOperator;
import org.platkmframework.persistence.filter.enumerator.SqlOrder;
import org.platkmframework.persistence.filter.exception.FilterException;
import org.platkmframework.persistence.filter.info.FilterData;
import org.platkmframework.persistence.filter.parse.ArrayExpressionNode;
import org.platkmframework.persistence.filter.parse.FieldNode;
import org.platkmframework.persistence.filter.parse.LiteralNode;
import org.platkmframework.persistence.filter.parse.Node;
import org.platkmframework.persistence.filter.parse.OperationNode;
import org.platkmframework.persistence.filter.parse.ParenthesisNode;
import org.platkmframework.persistence.filter.parse.Parser;
import org.platkmframework.persistence.filter.ui.Filter;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public class UIFilterToSearchCriteriaConverter implements FilterToFindFilterConverter {

    /**
     * Atributo uiFilterToSearchCriteriaConverter
     */
    private static UIFilterToSearchCriteriaConverter uiFilterToSearchCriteriaConverter;

    /**
     * Constructor UIFilterToSearchCriteriaConverter
     */
    private UIFilterToSearchCriteriaConverter() {
    }

    /**
     * instance
     * @return UIFilterToSearchCriteriaConverter
     */
    public static UIFilterToSearchCriteriaConverter instance() {
        if (uiFilterToSearchCriteriaConverter == null)
            uiFilterToSearchCriteriaConverter = new UIFilterToSearchCriteriaConverter();
        return uiFilterToSearchCriteriaConverter;
    }

    /**
     * convertToSearchCriteria
     * @param filter filter
     * @return SearchCriteria
     * @throws FilterException FilterException
     */
    @Override
    public SearchCriteria convertToSearchCriteria(Filter<?> filter) throws FilterException {
        SearchCriteria searchCriteria = new SearchCriteria();
        convert(searchCriteria, filter);
        return searchCriteria;
    }

    /**
     * convertToFilterCriteria
     * @param filter filter
     * @return FilterCriteria
     * @throws FilterException FilterException
     */
    @Override
    public FilterCriteria convertToFilterCriteria(Filter<?> filter) throws FilterException {
        FilterCriteria filterCriteria = new FilterCriteria();
        convert(filterCriteria, filter);
        return filterCriteria;
    }

    /**
     * convertToQueryCriteria
     * @param filter filter
     * @return WhereCriteria
     * @throws FilterException FilterException
     */
    @Override
    public WhereCriteria convertToQueryCriteria(Filter<?> filter) throws FilterException {
        WhereCriteria whereCriteria = new WhereCriteria();
        convert(whereCriteria, filter);
        return whereCriteria;
    }

    /**
     * convert
     * @param findFilter findFilter
     * @param filter filter
     */
    protected void convert(ConditionFilterBase findFilter, Filter<?> filter) {
        if (StringUtils.isNotBlank(filter.getConditions())) {
            Node node = Parser.parse(filter.getConditions());
            processConditionNodes(node, findFilter);
        }
        if (StringUtils.isNotBlank(filter.getOrder())) {
            String[] orders = filter.getOrder().split(",");
            for (String order : orders) {
                ((CriteriaFunction) findFilter).orderBy(order.replace("-", "").replace("+", ""), order.startsWith("-") ? SqlOrder.desc : SqlOrder.asc);
            }
        }
        ((CriteriaFunction) findFilter).addOffSetInfo(filter.getPageCount(), filter.getPage());
        if (StringUtils.isNotBlank(filter.getFiltertext())) {
            if (StringUtils.isNotBlank(filter.getFiltercolumn())) {
                ((CriteriaFunction) findFilter).addFastSearchInfo(filter.getFiltertext().trim(), filter.getFiltercolumn().split(","));
            } else {
                ((CriteriaFunction) findFilter).addFastSearchInfo(filter.getFiltertext().trim());
            }
        }
    }

    /**
     * processConditionNodes
     * @param node node
     * @param findFilter findFilter
     */
    private void processConditionNodes(Node node, ConditionFilterBase findFilter) {
        if (node instanceof OperationNode) {
            processOperationNode((OperationNode) node, findFilter);
        } else if (node instanceof ParenthesisNode) {
            processConditionNodes(((ParenthesisNode) node).getLeftChild(), findFilter);
            if (((ParenthesisNode) node).getType().name().equals(ParenthesisNode.Type.CLOSE.name())) {
                findFilter.cp();
            } else if (((ParenthesisNode) node).getType().name().equals(ParenthesisNode.Type.OPEN.name())) {
                findFilter.op();
            }
            processConditionNodes(((ParenthesisNode) node).getRightChild(), findFilter);
        }
    }

    /**
     * processOperationNode
     * @param operationNode operationNode
     * @param findFilter findFilter
     */
    private void processOperationNode(OperationNode operationNode, ConditionFilterBase findFilter) {
        if (operationNode.getType().name().equals(OperationNode.Type.AND.name())) {
            processConditionNodes(operationNode.getLeftChild(), findFilter);
            findFilter.getSql().add(new FilterData().addOperatorInfo(SqlOperator.and.name()));
            processConditionNodes(operationNode.getLeftChild(), findFilter);
        } else if (operationNode.getType().name().equals(OperationNode.Type.OR.name())) {
            findFilter.getSql().add(new FilterData().addOperatorInfo(SqlOperator.or.name()));
        } else if (operationNode.getType().name().equals(OperationNode.Type.EQUALS.name())) {
            findFilter.eq(((FieldNode) operationNode.getLeftChild()).getName(), ((LiteralNode) operationNode.getRightChild()).getValue());
        } else if (operationNode.getType().name().equals(OperationNode.Type.GREATER.name())) {
            findFilter.gt(((FieldNode) operationNode.getLeftChild()).getName(), ((LiteralNode) operationNode.getRightChild()).getValue());
        } else if (operationNode.getType().name().equals(OperationNode.Type.GREATER_EQUALS.name())) {
            findFilter.ge(((FieldNode) operationNode.getLeftChild()).getName(), ((LiteralNode) operationNode.getRightChild()).getValue());
        } else if (operationNode.getType().name().equals(OperationNode.Type.IN.name())) {
            findFilter.in(((FieldNode) operationNode.getLeftChild()).getName(), ((ArrayExpressionNode) operationNode.getRightChild()).getValue());
        } else if (operationNode.getType().name().equals(OperationNode.Type.LESS.name())) {
            findFilter.lt(((FieldNode) operationNode.getLeftChild()).getName(), ((LiteralNode) operationNode.getRightChild()).getValue());
        } else if (operationNode.getType().name().equals(OperationNode.Type.LESS_EQUALS.name())) {
            findFilter.le(((FieldNode) operationNode.getLeftChild()).getName(), ((LiteralNode) operationNode.getRightChild()).getValue());
        } else if (operationNode.getType().name().equals(OperationNode.Type.LIKE.name())) {
            findFilter.ctn(((FieldNode) operationNode.getLeftChild()).getName(), ((LiteralNode) operationNode.getRightChild()).getValue());
        }
    }
    /*
	public static final void main(String a[]) throws IOException {
		
		UIFilterToSearchCriteriaConverter uIFilterToSearchCriteriaConverter = new UIFilterToSearchCriteriaConverter();
		Filter filter = new Filter<>();
		filter.setConditions("age > 6");
		filter.setPageCount(5);
		filter.setOrder("-name,+lastname");
		filter.setPage(1);
		
		uIFilterToSearchCriteriaConverter.convertToFilterCriteria(filter);
	}


	 * private void addOperator(OperationNode operationNode, ConditionFilterBase
	 * findFilter) {
	 * 
	 * 
	 * processConditionNodes(((OperationNode)node).getLeftChild(), findFilter);
	 * addOperator((OperationNode) node, (ConditionFilterBase) findFilter);
	 * processConditionNodes( ((OperationNode)node).getRightChild(), findFilter);
	 * 
	 * 
	 * if(operationNode.getType().name().equals(OperationNode.Type.AND.name())) {
	 * findFilter.getSql().add(new FilterData().addOperatorInfo(
	 * SqlOperator.and.name())); }else
	 * if(operationNode.getType().name().equals(OperationNode.Type.OR.name())) {
	 * findFilter.getSql().add(new FilterData().addOperatorInfo(
	 * SqlOperator.or.name())); }else
	 * if(operationNode.getType().name().equals(OperationNode.Type.EQUALS.name())) {
	 * findFilter.getSql().add(new FilterData().addOperatorInfo(
	 * ConditionOperator.equal.name())); }
	 * 
	 * }
	 */
    /**
     *   searchCriteria.getSql().add(new FilterData().addExpressionInfo(expr.getLeftExpression().toString().replace("'", ""),
     * 					    																	 getLikeConditionOperator(expr.getRightExpression().toString()),
     * 					    																		expr.getRightExpression().toString().replace("'", ""), false));
     */
}
