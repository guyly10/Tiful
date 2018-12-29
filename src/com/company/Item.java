package com.company;

import java.util.ArrayList;

public class Item {


    public ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> netDemand = new ArrayList<Integer>();
    public ArrayList<Integer> supplyEndOfPeriod = new ArrayList<Integer>();
    public ArrayList<Integer> order = new ArrayList<Integer>();
    public ArrayList<Integer> currentSupply = new ArrayList<Integer>();
    public ArrayList<Integer> brutoDemand = new ArrayList<Integer>();
    public int LT;
    public Item fatherItem;
    Integer necssaryForFatherItem;
    Integer startingSupply;

    public Item(int LT, Item fatherItem, Integer necssaryForFatherItem, Integer startingSupply) {
        this.LT = LT;
        this.fatherItem = fatherItem;
        this.necssaryForFatherItem = necssaryForFatherItem;
        this.startingSupply = startingSupply;
        table.add(currentSupply);
        table.add(netDemand);
        table.add(order);
        table.add(supplyEndOfPeriod);

    }

    public void calculateNetDemand(){
        for (int i = 0; i <= 10; i++){
            if (startingSupply != 0){
                if (startingSupply > brutoDemand.get(i)){
                    netDemand.add(i, 0);
                    currentSupply.add(i, startingSupply);
                    startingSupply = startingSupply - brutoDemand.get(i);
                }
                else {
                    int tmp = brutoDemand.get(i) - startingSupply;
                    netDemand.add(i, tmp);
                    startingSupply = 0;
                }
            }
            else {
                netDemand.add(i,brutoDemand.get(i));
            }
        }
    }

    public void calculateOrder(){
        for (int i = 0; i < 10; i++){
            if (currentSupply.get(i) < brutoDemand.get(i)){
                int index = i - LT;
                int tmp = brutoDemand.get(i) - currentSupply.get(i);
                order.add(index, tmp);
            }
        }

    }

    public void calculateSupplyEndOfPeriod(){
        for (int i = 0; i < 10; i++){
            int tmp = currentSupply.get(i) - brutoDemand.get(i);
            if (tmp > 0){
               supplyEndOfPeriod.add(i, tmp);
            }
        }

    }

    public void calculateBrutoDemand(){
        for (int i = 0; i < 10; i++){
            int tmp = fatherItem.brutoDemand.get(i) * necssaryForFatherItem;
            brutoDemand.add(i, tmp);
        }
    }
}
