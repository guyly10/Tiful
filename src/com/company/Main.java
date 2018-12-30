package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Item A = new Item(2, null, 1, 30);
        Item B = new Item(1, A, 3, 0);
        Item C = new Item(3, A, 2, 0);
        Item D = new Item(1, C, 1, 0);

        A.brutoDemand[5] = 11;
        A.brutoDemand[6] = 16;
        A.brutoDemand[7] = 20;
        A.brutoDemand[8] = 5;
        A.brutoDemand[9] = 10;
        A.brutoDemand[10] = 12;
        A.currentSupply[4] = 30;

        A.calculateNetDemand();
        A.calculateOrder();
        A.calculateSupplyEndOfPeriod();

        System.out.println("Plan For Product A");
        print(A);
        System.out.println("*********************************************");

        B.calculateBrutoDemand();
        B.calculateNetDemand();
        B.calculateOrder();
        B.calculateSupplyEndOfPeriod();

        System.out.println("Plan For Product B");
        print(B);
        System.out.println("*********************************************");

        C.calculateBrutoDemand();
        C.calculateNetDemand();
        C.calculateOrder();
        C.calculateSupplyEndOfPeriod();

        System.out.println("Plan For Product C");
        print(C);
        System.out.println("*********************************************");

        D.calculateBrutoDemand();
        D.calculateNetDemand();
        D.calculateOrder();
        D.calculateSupplyEndOfPeriod();

        System.out.println("Plan For Product D");
        print(D);
        System.out.println("*********************************************");

    }

    private static void print(Item a) {
        System.out.println("Gross Demand");
        printTables(a.brutoDemand);
        System.out.println();
        System.out.println("Current Supply");
        printTables(a.currentSupply);
        System.out.println();
        System.out.println("Net Demand");
        printTables(a.netDemand);
        System.out.println();
        System.out.println("Released Order");
        printTables(a.order);
        System.out.println();
        System.out.println("Supply At End Of Period");
        printTables(a.supplyEndOfPeriod);
        System.out.println();
    }

    private static void printTables(Integer [] a) {
        for (int i = 0; i < 11; i++){
            if (a[i] != null){
                System.out.printf("%5d", i);
            }
        }
        System.out.println();
        for (int i = 0; i < 11; i++){
            if (a[i] != null){
                int cast = a[i];
                System.out.printf("%5d", cast);
            }
        }
    }
}
