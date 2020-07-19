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
        String output[] = {" Not present in trie", " Present in trie"};
        
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
        for(j = 0; j < hasil.size(); j++)
        {
            if (root.search(hasil.get(j)) == true)
                System.out.println(hasil.get(j) + output[1]);
            else
                System.out.println(hasil.get(j) + output[0]);
        }        
    }
    
}
