package com.exam.designpatterns.structural_design_patterns.d06facade.example2;

public class FacadePatternExample {

    public static void main(String[] args) {
        String test = "CheckElementPresent";

        WebExplorerHelperFacade.generateReports("firefox", "html", test);
        WebExplorerHelperFacade.generateReports("firefox", "junit", test);
        WebExplorerHelperFacade.generateReports("chrome", "html", test);
        WebExplorerHelperFacade.generateReports("chrome", "junit", test);
    }
}
