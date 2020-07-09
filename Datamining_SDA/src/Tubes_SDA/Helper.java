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

/**
 *
 * Author = Bima Putra S | 191524038 | D4-1B "2019
 * Politeknik Negeri Bandung
 * Tanggal :
 * Deskripsi :
 */
public class Helper {
    
   Gson gson = new Gson();
    
    public void output_product(){
        try (Reader reader = new FileReader("src/Data_JSON/product.json")){
            
            // Convert dari json menjadi list.   
            Type listtype = new TypeToken<ArrayList<Product>>(){}.getType();
            ArrayList<Product> data = gson.fromJson(reader, listtype);  
            
            // Print output data.
            data.forEach(System.out::println);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void output_transactions(){
        try (Reader reader = new FileReader("src/Data_JSON/transaction.json")){
            
            // Convert dari json menjadi list.   
            Type listtype = new TypeToken<ArrayList<Transaction>>(){}.getType();
            ArrayList<Transaction> data = gson.fromJson(reader, listtype);  
            
            // Print output data.
            data.forEach(System.out::println);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
