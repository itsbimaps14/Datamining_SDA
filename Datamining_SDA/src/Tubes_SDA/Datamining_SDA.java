/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA;

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
        
        Helper helper = new Helper();
        
        data_product = helper.get_product();
        data_product.forEach(System.out::println);
        
        data_transaction = helper.get_transaction();
        data_transaction.forEach(System.out::println);
    }
    
}
