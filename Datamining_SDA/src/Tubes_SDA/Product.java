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
    
    public int getTotalProduct(){
        return 0;
    }
    
    public String toString(){
        return getId() +". "+ name + " - by " +company;
    }

    public int getId() {
        return id;
    }
}
