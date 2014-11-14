package com.connio.sdk.api.systemservices.apps.model;

/**
 * TODO: javadoc
 *
 * Created by bdirik on 14.11.2014.
 */
public class Condition {

    private String op;

    private Object value;

    private String unit;

    public Condition() {
    }

    public Condition(String op, Object value, String unit) {
        this.op = op;
        this.value = value;
        this.unit = unit;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "op='" + op + '\'' +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Condition condition = (Condition) o;

        if (op != null ? !op.equals(condition.op) : condition.op != null) return false;
        if (unit != null ? !unit.equals(condition.unit) : condition.unit != null) return false;
        if (value != null ? !value.equals(condition.value) : condition.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = op != null ? op.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
