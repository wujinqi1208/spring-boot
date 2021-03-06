/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.json;

import java.util.List;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Thin wrapper to adapt {@link org.json.simple.JSONObject} to a {@link JsonParser}.
 *
 * @author Dave Syer
 * @author Jean de Klerk
 * @since 1.2.0
 * @see JsonParserFactory
 */
public class JsonSimpleJsonParser implements JsonParser {

	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> parseMap(String json) {
		try {
			return (Map<String, Object>) new JSONParser().parse(json);
		}
		catch (ParseException ex) {
			throw new IllegalArgumentException("Cannot parse JSON", ex);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object> parseList(String json) {
		try {
			return (List<Object>) new JSONParser().parse(json);
		}
		catch (ParseException ex) {
			throw new IllegalArgumentException("Cannot parse JSON", ex);
		}
	}

}
