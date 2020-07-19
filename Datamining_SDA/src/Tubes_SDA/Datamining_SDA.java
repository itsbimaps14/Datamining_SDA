/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA;

import Tubes_SDA.Kombinasi.Kombi;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bima
 */
public class Datamining_SDA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Kamus Data
        ArrayList<Transaction> data_transaction;
        ArrayList<Product> data_product;
        String tmp;
        ArrayList list = new ArrayList<String>();
        ArrayList<ArrayList<String>> hasil;
        String output[] = {" Not present in trie", " Present in trie"};
        
        Helper helper = new Helper();
        Trie root = new Trie();
        Kombi kombi = new Kombi();
        
        hasil = kombi.generate(helper.get_product().size());
       
        // Construct trie 
        int i,j; 
        for (i = 0; i < hasil.size() ; i++){
            root.insert(hasil.get(i));
        }
        
        data_transaction = helper.get_transaction();
        data_transaction.forEach(n -> {
            n.removeFalseItem();
            if(n.toString() != "[]"){
                list.add(n.toString());
            }
        });
        
        for(i = 0; i < list.size(); i++){
            if(root.search(helper.konversiObjString(String.valueOf(list.get(i)))) == true) 
                System.out.println(list.get(i) + output[1] + " Support: " + root.getSupport(helper.konversiObjString(String.valueOf(list.get(i))))); 
            else System.out.println(list.get(i) + output[0]); 
        }
        
        System.out.println("\nSUPPORT TIAP HIMPUNAN:");
        for(j = 0; j < hasil.size(); j++)
        {
            if (root.search(hasil.get(j)) == true)
                System.out.println(hasil.get(j) + output[1] + ", support: " + root.getSupport(hasil.get(j)));
            else
                System.out.println(hasil.get(j) + output[0]);
        }
        
        System.out.println("\nHIMPUNAN DIATAS THRESHOLD(> 9):");
        for(j = 0; j < hasil.size(); j++)
        {
            root.PrintPassedThreshold(hasil.get(j));
        }
    }
}