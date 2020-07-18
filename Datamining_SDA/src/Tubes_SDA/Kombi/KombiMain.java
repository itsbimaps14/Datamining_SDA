/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA.Kombi;

import Tubes_SDA.Helper;
import java.util.ArrayList;

/**
 *
 * @author Faza
 */
public class KombiMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Helper helper = new Helper();
        
        Kombi kombi = new Kombi();
        ArrayList<ArrayList<String>> hasil = kombi.generate(5);
        //ArrayList<ArrayList<Product>> hasil = kombi.generate(helper.get_product());
        
        hasil.forEach(System.out::println);
    }
    
}
