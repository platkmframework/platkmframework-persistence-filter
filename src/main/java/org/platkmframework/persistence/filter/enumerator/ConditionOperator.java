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
package org.platkmframework.persistence.filter.enumerator;

import java.io.Serializable;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public enum ConditionOperator implements Serializable {

    //equal
    equal,
    //no equal
    notEqual,
    //mayor que
    greateThan,
    //menor que
    lessThan,
    //mayor igual
    greateEqual,
    //menor igual
    lessEqual,
    //incluye
    include,
    //no incluye
    notInclude,
    //string comienza con
    startWith,
    //string termina con
    endWith,
    // string contiene
    contain,
    // string no contiene
    notContain,
    // is null value
    isNull,
    // is not null value
    isNotNull
}
