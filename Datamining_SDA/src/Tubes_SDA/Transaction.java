/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tubes_SDA;

import java.util.ArrayList;

/**
 *
 * Author = Bima Putra S | 191524038 | D4-1B "2019
 *          M Faza I R | 191524050 | D4-1B'19
 * Politeknik Negeri Bandung
 * Tanggal :
 * Deskripsi :
 */
public class Transaction {
    private String id, name, date, time, list_item;
    private int index;
    private ArrayList<Items> item;
    private ArrayList<String> data = new ArrayList<String>();
    
    public void removeFalseItem(){
        for(int x = item.size() - 1; x >= 0; x--){
            if(!item.get(x).getStatus()){
                item.remove(x);
            }
        }
    }
    
    public ArrayList<String> getData(){
        data.add(item.toString());
        return data;
    }
    
    public String toString(){
        return item.toString();
    }
    
    public String display(){
        removeFalseItem();
        return "Name: " + name + "\nDate: " + date + "\nItems: " + item + "\n";
    }
}