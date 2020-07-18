/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA.Trie;

/**
 *
 * @author Sumit Ghosh - GFG
 */
public class TrieMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any", 
                         "by", "bye", "their"}; 
       
        String output[] = {"Not present in trie", "Present in trie"}; 
       
       
        Trie root = new Trie(); 
       
        // Construct trie 
        int i; 
        for (i = 0; i < keys.length ; i++) 
            root.insert(keys[i]); 
       
        // Search for different keys 
        if(root.search("the") == true) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]); 
          
        if(root.search("these") == true) 
            System.out.println("these --- " + output[1]); 
        else System.out.println("these --- " + output[0]); 
          
        if(root.search("their") == true) 
            System.out.println("their --- " + output[1]); 
        else System.out.println("their --- " + output[0]); 
          
        if(root.search("thaw") == true) 
            System.out.println("thaw --- " + output[1]); 
        else System.out.println("thaw --- " + output[0]); 
         
    }
    
}
