/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA.TrieTree;

import Tubes_SDA.Helper;
import Tubes_SDA.Kombinasi.Kombi;
import java.util.ArrayList;

/**
 *
 * @author Sumit Ghosh - GFG
 */
public class TrieMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        String output[] = {"Not present in trie", "Present in trie"};
        
        Helper helper = new Helper();       
        Kombi kombi = new Kombi();
        ArrayList<ArrayList<String>> hasil = kombi.generate(helper.get_product().size());
        System.out.println("\n");
        System.out.println(hasil);
        System.out.println("\n");
       
       
        Trie root = new Trie(); 
       
        // Construct trie 
        int i,j; 
        for (i = 0; i < hasil.size() ; i++)
        {
            root.insert(hasil.get(i));
        }
            
       
        // Search for different keys 
        if(root.search(hasil.get(0)) == true) 
            System.out.println(hasil.get(0) + output[1]); 
        else System.out.println("the --- " + output[0]); 
          
        if(root.search(hasil.get(1)) == true) 
            System.out.println(hasil.get(1) + output[1]); 
        else System.out.println("these --- " + output[0]); 
          
        if(root.search(hasil.get(12)) == true) 
            System.out.println(hasil.get(12) + output[1]); 
        else System.out.println("their --- " + output[0]); 
          
        if(root.search(hasil.get(30)) == true) 
            System.out.println(hasil.get(30) + output[1]); 
        else System.out.println("thaw --- " + output[0]); 
         
    }
    
}
