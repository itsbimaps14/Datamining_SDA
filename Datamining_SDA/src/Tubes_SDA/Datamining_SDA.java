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
        // TODO code application logic here
        // ArrayList<Product> data = gson.fromJson(Product);
        
        Helper helper = new Helper();
        
        // Catatan : Harusnya arraylist returnnya !!!
        helper.output_product();
        
        // Catatan : Harusnya arraylist returnnya !!!
        //helper.output_transactions();
    }
    
}
