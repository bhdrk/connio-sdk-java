package com.connio.sdk.api.model;

import com.connio.sdk.api.utils.Asserts;

import java.util.Locale;

import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 02.10.2014
 */
public class ContentType {

    private String type;
    private String charset;

    public ContentType(String type, String charset) {
        Asserts.notEmpty(type, "Type");
        Asserts.notEmpty(charset, "Charset");

        this.type = type.toLowerCase(Locale.ENGLISH);
        this.charset = charset.toLowerCase(Locale.ENGLISH);
    }

    public String getType() {
        return type;
    }

    public String getCharset() {
        return charset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContentType that = (ContentType) o;

        if (charset != null ? !charset.equals(that.charset) : that.charset != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (charset != null ? charset.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String str = "";
        if (type != null) str += type;
        if (charset != null) str += ";charset=" + charset;
        return str;
    }
}
