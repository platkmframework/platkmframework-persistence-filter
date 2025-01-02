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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.DateFormat;
import org.platkmframework.persistence.filter.exception.FilterException;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 */
public class ParseTagTypeJavaValue {

    /**
     * parse
     * @param languageType languageType
     * @param value value
     * @return Object
     * @throws FilterException FilterException
     */
    public static Object parse(String languageType, Object value) throws FilterException {
        if (value == null || "".equals(value.toString().trim()))
            return null;
        Class<?> classType = getLanguageType(languageType);
        return validate(value, classType.getSimpleName().toLowerCase());
    }

    /**
     * getLanguageType
     * @param languageType languageType
     * @return Class
     * @throws FilterException FilterException
     */
    private static Class<?> getLanguageType(String languageType) throws FilterException {
        try {
            return Class.forName(languageType);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new FilterException("language type not found");
        }
    }

    /**
     * validate
     * @param value value
     * @param simpleName simpleName
     * @return Object
     * @throws FilterException FilterException
     */
    private static Object validate(Object value, String simpleName) throws FilterException {
        try {
            Method method = ParseTagTypeJavaValue.class.getDeclaredMethod("parse_" + simpleName, Object.class);
            return method.invoke(null, value);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            throw new FilterException("language type not found");
        }
    }

    /**
     * parse_string
     * @param defaultvalue defaultvalue
     * @return Object
     * @throws FilterException FilterException
     */
    public static Object parse_string(Object defaultvalue) throws FilterException {
        try {
            return String.valueOf(defaultvalue);
        } catch (Exception e) {
            throw new FilterException(e.getMessage());
        }
    }

    /**
     * parse_boolean
     * @param defaultvalue defaultvalue
     * @return Object
     * @throws FilterException FilterException
     */
    public static Object parse_boolean(Object defaultvalue) throws FilterException {
        try {
            return Boolean.valueOf(defaultvalue.toString());
        } catch (Exception e) {
            throw new FilterException("el campo no es de tipo condici�n");
        }
    }

    /**
     * parse_date
     * @param defaultvalue defaultvalue
     * @return Object
     * @throws FilterException FilterException
     */
    public static Object parse_date(Object defaultvalue) throws FilterException {
        try {
            return DateFormat.getInstance().parse(defaultvalue.toString());
        } catch (Exception e) {
            throw new FilterException("el campo no es de tipo fecha");
        }
    }

    /**
     * parse_timestamp
     * @param defaultvalue defaultvalue
     * @return Object
     * @throws FilterException FilterException
     */
    public static Object parse_timestamp(Object defaultvalue) throws FilterException {
        try {
            return Timestamp.valueOf(defaultvalue.toString());
        } catch (Exception e) {
            throw new FilterException("el campo no es de tipo fecha");
        }
    }

    /**
     * parse_short
     * @param defaultvalue defaultvalue
     * @return Object
     * @throws FilterException FilterException
     */
    public static Object parse_short(Object defaultvalue) throws FilterException {
        try {
            return Short.valueOf(defaultvalue.toString());
        } catch (Exception e) {
            throw new FilterException("el campo no es de tipo short");
        }
    }

    /**
     * parse_long
     * @param defaultvalue defaultvalue
     * @return Object
     * @throws FilterException FilterException
     */
    public static Object parse_long(Object defaultvalue) throws FilterException {
        try {
            return Long.valueOf(defaultvalue.toString());
        } catch (Exception e) {
            throw new FilterException("el campo no es de tipo entero largo");
        }
    }

    /**
     * parse_bigdecimal
     * @param defaultvalue defaultvalue
     * @return Object
     * @throws FilterException FilterException
     */
    public static Object parse_bigdecimal(Object defaultvalue) throws FilterException {
        try {
            return java.math.BigDecimal.valueOf(Double.valueOf(defaultvalue.toString()));
        } catch (Exception e) {
            throw new FilterException("el campo no es de tipo decimal");
        }
    }

    /**
     * parse_float
     * @param defaultvalue defaultvalue
     * @return Object
     * @throws FilterException FilterException
     */
    public static Object parse_float(Object defaultvalue) throws FilterException {
        try {
            return Float.valueOf(defaultvalue.toString());
        } catch (Exception e) {
            throw new FilterException("el campo no es de tipo real");
        }
    }
}
