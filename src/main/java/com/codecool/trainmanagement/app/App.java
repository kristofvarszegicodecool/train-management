package com.codecool.trainmanagement.app;

import com.codecool.trainmanagement.company.Company;

public class App {
    public static void main(String[] args) {
        Company company = new Company();
        System.out.println(company.getFreightTrainsCarryingDangerousCargo());
    }
}
