/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tubes_SDA;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Author = Bima Putra S | 191524038 | D4-1B "2019
 *          M Faza I R | 191524050 | D4-1B'19
 * Politeknik Negeri Bandung
 * Tanggal :
 * Deskripsi :
 */
public class Helper {
    // Kamus Data
    private ArrayList<Transaction> data_trans;
    private ArrayList<Product> data_product;
    private ArrayList<String> data_trans_item;
    
    public ArrayList get_product(){    
        Gson gson = new Gson();
        
        try (Reader reader = new FileReader("src/Data_JSON/product.json")){
            
            // Convert dari json menjadi list.   
            Type listtype = new TypeToken<ArrayList<Product>>(){}.getType();
            data_product = gson.fromJson(reader, listtype);  
            
            // Print output data.
            // data_product.forEach(System.out::println);

        }catch (IOException e) {
            e.printStackTrace();
        }
        
        return data_product;
    }
    
    public ArrayList get_transaction(){
        Gson gson = new Gson();
        
        try (Reader reader = new FileReader("src/Data_JSON/transaction.json")){
            
            // Convert dari json menjadi list.   
            Type listtype = new TypeToken<ArrayList<Transaction>>(){}.getType();
            data_trans = gson.fromJson(reader, listtype);  
            
            // Print output data.
            // data_trans.forEach(System.out::println);

        }catch (IOException e) {
            e.printStackTrace();
        }
        
        return data_trans;
    }
    
    public ArrayList get_items(){
        Gson gson = new Gson();
        
        try (Reader reader = new FileReader("src/Data_JSON/transaction.json")){
            
            // Convert dari json menjadi list.   
            Type listtype = new TypeToken<ArrayList<Items>>(){}.getType();
            data_trans = gson.fromJson(reader, listtype);  
            
            // Print output data.
            // data_trans.forEach(System.out::println);

        }catch (IOException e) {
            e.printStackTrace();
        }
        
        return data_trans;
    }
    
    public ArrayList konversiObjString(String tmp){
        ArrayList myList;
        
        tmp = tmp.replace("[", "");
        tmp = tmp.replace("]", "");
        tmp = tmp.replace(" ", "");
        
        return myList = new ArrayList<String>(Arrays.asList(tmp.split(",")));
    }
}
