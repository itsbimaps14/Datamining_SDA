/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tubes_SDA;

/**
 *
 * Author = Bima Putra S | 191524038 | D4-1B "2019
 * Politeknik Negeri Bandung
 * Tanggal :
 * Deskripsi :
 */
public class Product {
    private int id;
    private String name, currency, company;
    private double sell_price, profit;
    
    @Override
    public String toString(){
        return getId() +". "+ name + " - by " +company;
    }

    public int getId() {
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCompany(){
        return company;
    }
    
    public double getSellPrice(){
        return sell_price;
    }
    
    public double getProfit(){
        return profit;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCompany(){
        this.company = company;
    }
    
    public void setSellPrice(){
        this.sell_price = sell_price;
    }
    
    public void setProfit(){
        this.profit = profit;
    }
}
