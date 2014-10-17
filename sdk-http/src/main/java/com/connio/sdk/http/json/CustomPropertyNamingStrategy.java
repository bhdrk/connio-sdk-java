package com.connio.sdk.http.json;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class CustomPropertyNamingStrategy extends PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy {

    @Override
    public String translate(String input) {
        // java keyword fix
        if ("clazz".equalsIgnoreCase(input)) {
            return "class";
        } else if (input.startsWith("_")) {
            return "@" + input.substring(1);
        }
        return super.translate(input);
    }
}
