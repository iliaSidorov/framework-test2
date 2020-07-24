package ru.appline.testproject.framework.model;

public class Product {


    private double price;
    private double priceWithGuarantee;
    private int guarantee;

    public double getTotalPrice() {
        if (priceWithGuarantee == 0) {
            return price;
        } else return priceWithGuarantee;
    }

    //getters & setters
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getGuarantee() {
        return guarantee;
    }
    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }
    public double getPriceWithGuarantee() {
        return priceWithGuarantee;
    }
    public void setPriceWithGuarantee(double priceWithGuarantee) {
        this.priceWithGuarantee = priceWithGuarantee;
    }
}
