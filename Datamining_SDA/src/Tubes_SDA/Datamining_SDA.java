/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA;

import Tubes_SDA.Kombinasi.Kombi;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Author = Bima Putra S | 191524038 | D4-1B "2019
 *          M Faza I R | 191524050 | D4-1B'19
 * Politeknik Negeri Bandung
 * Tanggal :
 * Deskripsi :
 */
public class Datamining_SDA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Kamus Data
        ArrayList<Transaction> data_transaction;
        ArrayList list = new ArrayList<String>();
        ArrayList<ArrayList<String>> hasil;
        int choice;
        
        // Object Declaration
        Helper helper = new Helper();
        Trie root = new Trie();
        Kombi kombi = new Kombi();
        
        // Get Data
        hasil = kombi.generate(helper.get_product().size());
       
        // Construct trie 
        int i;
        for (i = 0; i < hasil.size() ; i++){
            root.Insert(hasil.get(i));
        }
        
        // Transform dari String -> ArrayList
        data_transaction = helper.get_transaction();
        data_transaction.forEach(n -> {
            n.removeFalseItem();
            if(n.toString() != "[]"){
                list.add(n.toString());
            }
        });
        
        // Search tiap key pada transaksi, generate kombinasi, lalu hitung support dari setiap key
        for(i = 0; i < list.size(); i++){
            ArrayList<String> data = helper.konversiObjString(String.valueOf(list.get(i)));
            if(root.Search(data) == true){
                // Bima : Check data update support tiap search !~
                // System.out.println(list.get(i) + output[1] + " Support: " + root.getSupport(data));
                
                List<List<String>> powerSet = new LinkedList<List<String>>();
                
                String[] arr = data.toArray(new String[0]);
                for (int x = 1; x <= arr.length; x++){
                    powerSet.addAll(helper.combination(data, x));
                }
                
                powerSet.forEach(n -> {
                    root.CountSupport(helper.konversiObjString(String.valueOf(n)));                   
                });
            }
        }
        
        System.out.println("SUPPORT TIAP HIMPUNAN:");
        for(i = 0; i < hasil.size(); i++){
            root.PrintAllDataSupport(hasil.get(i));
        }
        
        int threshold = data_transaction.size() / 5;
        System.out.println("\nHIMPUNAN DIATAS THRESHOLD( > "+threshold+"):");
        for(i = 0; i < hasil.size(); i++){
            root.PrintPassedThreshold(hasil.get(i),threshold);
        }
        
        do{
            helper.MenuMain();
            choice = helper.getInput();
            helper.pilihanMenu(choice, hasil, root);
            System.out.println();
        }while(choice != 6);
    }
}