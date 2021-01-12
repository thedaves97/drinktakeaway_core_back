package com.api.drinktakeaway_core_back.dto;

public class OrderDrinkQuantity {

    private long sum;
    private int id_local;

    public OrderDrinkQuantity(long sum, int id_local)
    {
        this.sum = sum;
        this.id_local = id_local;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }
}
