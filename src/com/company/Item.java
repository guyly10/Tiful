package com.company;

import java.util.ArrayList;

public class Item {


    public ArrayList<Integer[]> table = new ArrayList<>();
    Integer[] netDemand = new Integer[11];
    Integer[] supplyEndOfPeriod = new Integer[11];
    Integer[] order = new Integer[11];
    Integer[] currentSupply = new Integer[11];
    Integer[] brutoDemand = new Integer[11];

    public int LT;
    public Item fatherItem;
    Integer necssaryForFatherItem;
    Integer startingSupply;

    public Item(int LT, Item fatherItem, Integer necssaryForFatherItem, Integer startingSupply) {
        this.LT = LT;
        this.fatherItem = fatherItem;
        this.necssaryForFatherItem = necssaryForFatherItem;
        this.startingSupply = startingSupply;
        table.add(brutoDemand);
        table.add(currentSupply);
        table.add(netDemand);
        table.add(order);
        table.add(supplyEndOfPeriod);

    }

    public void calculateNetDemand() {
        for (int i = 0; i <= 10; i++) {
            if (startingSupply != 0) {
                if (brutoDemand[i] != null) {
                    if (startingSupply > brutoDemand[i]) {
                        netDemand[i] = 0;
                        currentSupply[i] = startingSupply;
                        startingSupply = startingSupply - brutoDemand[i];
                    } else {
                        int tmp = brutoDemand[i] - startingSupply;
                        netDemand[i] = tmp;
                        currentSupply[i] = startingSupply;
                        startingSupply = 0;
                    }
                }
            }
            else {
                netDemand[i] = brutoDemand[i];
                currentSupply[i] = startingSupply;
            }
        }
    }

    public void calculateOrder() {
        int j = 1;
        for (int i = 0; i <= 10; i++) {
            if (currentSupply[i] != null && j < 11 && brutoDemand[j] != null ) {
                if (currentSupply[i] < brutoDemand[j]) {
                    int index = j - LT;
                    order[index] = netDemand[j];
                }
            }
            j++;
        }
    }

    public void calculateSupplyEndOfPeriod() {
        for (int i = 0; i <= 10; i++) {
            if (currentSupply[i] != null && brutoDemand[i] != null) {
                int tmp = currentSupply[i] - brutoDemand[i];
                if (tmp > 0) {
                    supplyEndOfPeriod[i] = tmp;
                }
                else {
                    supplyEndOfPeriod[i] = 0;
                }
            }
        }
    }

    public void calculateBrutoDemand() {
        for (int i = 0; i <= 10; i++) {
            if (fatherItem.order[i] != null) {
                int tmp = fatherItem.order[i] * necssaryForFatherItem;
                brutoDemand[i] = tmp;
            }
        }
    }

    @Override
    public String toString() {
        return "AAA";
    }
}
