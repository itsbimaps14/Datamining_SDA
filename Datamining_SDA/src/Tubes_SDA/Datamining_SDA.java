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
        ArrayList list = new ArrayList();
        ArrayList<ArrayList<String>> hasil, data;
        String output[] = {"Not present in trie", "Present in trie"};
        
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
            list.add(n.toString());
        });
        
        data = new ArrayList<ArrayList<String>>();
        data.add(list);
        
        // Masih Salah - Array di dalam arraynya 1x aja buat data !
        System.out.println(list);
        System.out.println(data);

    }
}