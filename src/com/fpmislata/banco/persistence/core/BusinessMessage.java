package com.fpmislata.banco.persistence.core;

public class BusinessMessage implements Comparable<BusinessMessage>{

    private String fieldName, message;

    public BusinessMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int compareTo(BusinessMessage o) {
        if ((getFieldName() == null) && (o.getFieldName() == null)) {
            return getMessage().compareTo(o.getMessage());
        } else if ((getFieldName() == null) && (o.getFieldName() != null)) {
            return 1;
        } else if ((getFieldName() != null) && (o.getFieldName() == null)) {
            return -1;
        } else if ((getFieldName() != null) && (o.getFieldName() != null)) {
            if (getFieldName().equals(o.getFieldName())) {
                return getMessage().compareTo(o.getMessage());
            } else {
                return getFieldName().compareTo(o.getFieldName());
            }
        } else {
            throw new RuntimeException("Error de lógica");
        }
    }

    @Override
    public String toString() {
        if (fieldName != null) {
            return "'" + fieldName + " - " + message;
        } else {
            return message;
        }
    }
}