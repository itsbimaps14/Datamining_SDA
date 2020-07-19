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
import java.util.LinkedList;
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
        
        // Transform dari String -> ArrayList
        data_transaction = helper.get_transaction();
        data_transaction.forEach(n -> {
            n.removeFalseItem();
            if(n.toString() != "[]"){
                list.add(n.toString());
            }
        });
        
        for(i = 0; i < list.size(); i++){
            ArrayList<String> data = helper.konversiObjString(String.valueOf(list.get(i)));
            if(root.search(data) == true){
                // Bima : Check data update support tiap search !~
                // System.out.println(list.get(i) + output[1] + " Support: " + root.getSupport(data));
                
                List<List<String>> powerSet = new LinkedList<List<String>>();
                
                String[] arr = data.toArray(new String[0]);
                //System.out.println(arr.length);
                for (int x = 1; x <= arr.length; x++){
                    powerSet.addAll(helper.combination(data, x));
                }
                
                powerSet.forEach(n -> {
                    if(root.search(helper.konversiObjString(String.valueOf(n)))){
                        //donothing
                    }
                });
            }
            else System.out.println(list.get(i) + output[0]); 
        }
        
        System.out.println("\nSUPPORT TIAP HIMPUNAN:");
        for(j = 0; j < hasil.size(); j++){
            root.PrintAllDataSupport(hasil.get(j));
        }
        
        int treeshold = data_transaction.size() / 5;
        System.out.println("\nHIMPUNAN DIATAS THRESHOLD( > "+treeshold+"):");
        for(j = 0; j < hasil.size(); j++){
            root.PrintPassedThreshold(hasil.get(j),treeshold);
        }

    }
}