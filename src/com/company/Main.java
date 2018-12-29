package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Item A = new Item(2, null, 1, 30);
        Item B = new Item(1, A, 3, 0);
        Item C = new Item(3, A, 2, 0);
        Item D = new Item(1, C, 1, 0);

        ArrayList<Integer> brutoDemand = new ArrayList<>();
        for (int i = 0; i <= 10; i++){
            A.brutoDemand.add(i, 0);
            A.currentSupply.add(i, 0);
            A.supplyEndOfPeriod.add(i, 0);
            A.netDemand.add(i, 0);
            A.order.add(i, 0);
            B.brutoDemand.add(i, 0);
            B.currentSupply.add(i, 0);
            B.supplyEndOfPeriod.add(i, 0);
            B.netDemand.add(i, 0);
            B.order.add(i, 0);
            C.brutoDemand.add(i, 0);
            C.currentSupply.add(i, 0);
            C.supplyEndOfPeriod.add(i, 0);
            C.netDemand.add(i, 0);
            C.order.add(i, 0);
            D.brutoDemand.add(i, 0);
            D.currentSupply.add(i, 0);
            D.supplyEndOfPeriod.add(i, 0);
            D.netDemand.add(i, 0);
            D.order.add(i, 0);
        }
        A.brutoDemand.add(5, 11);
        A.brutoDemand.add(6,16);
        A.brutoDemand.add(7,20);
        A.brutoDemand.add(8,5);
        A.brutoDemand.add(9,10);
        A.brutoDemand.add(10,12);
        A.currentSupply.add(4, 30);

        A.calculateNetDemand();
        A.calculateOrder();
        A.calculateSupplyEndOfPeriod();

        B.calculateNetDemand();
        B.calculateBrutoDemand();
        B.calculateOrder();
        B.calculateSupplyEndOfPeriod();

        C.calculateNetDemand();
        C.calculateBrutoDemand();
        C.calculateOrder();
        C.calculateSupplyEndOfPeriod();

        D.calculateNetDemand();
        D.calculateBrutoDemand();
        D.calculateOrder();
        D.calculateSupplyEndOfPeriod();

    }
}
