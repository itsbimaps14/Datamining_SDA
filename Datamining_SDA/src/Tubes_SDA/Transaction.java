/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tubes_SDA;

import java.util.Arrays;

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
    private Items[] item;
    
    public String toString(){
        return name + ": " +Arrays.toString(item);
    }
   
}
