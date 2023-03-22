package com.exam.designpatterns.structural_design_patterns.d05proxy;

public class DatabaseExecuterImpl implements DatabaseExecuter{

    @Override
    public void executeDatabase(String query) throws Exception {
        System.out.println("Going to execute Query: " + query);
    }

}
