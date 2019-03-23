package com.book.entity.type;

import java.util.HashMap;

public class AccountDate {

    private String dateString;

    private String year = null;

    private String month = null;

    private String day = null;

    public AccountDate(String dateString){

        this.dateString = dateString;

    }

    @Override
    public int hashCode() {
        return dateString.hashCode();
    }

}
