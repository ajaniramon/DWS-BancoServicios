package com.fpmislata.banco.persistence.core;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BusinessException extends Exception {
    private Set<BusinessMessage> bussinessMessages = new TreeSet<>();

    public BusinessException() {
        
    }
    public BusinessException(List<BusinessMessage> bussinessMessages) {
        this.bussinessMessages.addAll(bussinessMessages);
    }

    public BusinessException(BusinessMessage bussinessMessage) {
        bussinessMessages.add(bussinessMessage);
    }

    public BusinessException(Exception ex) {
        bussinessMessages.add(new BusinessMessage(null, ex.toString()));
    }

    public Set<BusinessMessage> getBussinessMessages() {
        return bussinessMessages;
    }
    
    public void add(BusinessMessage businessMessage) {
        bussinessMessages.add(businessMessage);
    }
}