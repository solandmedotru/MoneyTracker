package ru.solandme.moneytracker;


public class Transactions {

    private String title;
    private String sum;

    public Transactions(String title, String sum) {
        this.title = title;
        this.sum = sum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
