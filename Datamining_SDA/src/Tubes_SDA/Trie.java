/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA;

import java.util.ArrayList;

/**
 *
 * @author Sumit Ghosh - GFG
 * Modified by: Bima & Faza
 */
public class Trie {
    public TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    void Insert(ArrayList<String> key) 
    { 
        int level; 
        int length = key.size();
        int index; 
       
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.get(level).charAt(0)-'1';
            if (pCrawl.children[index] == null) 
                pCrawl.children[index] = new TrieNode(); 
       
            pCrawl = pCrawl.children[index]; 
        } 
       
        // mark last node as leaf 
        pCrawl.isEndOfNumberSet = true; 
    }
    
    boolean Search(ArrayList<String> key) 
    { 
        int level; 
        int length = key.size(); 
        int index; 
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.get(level).charAt(0)-'1'; 
       
            if (pCrawl.children[index] == null) 
                return false; 
       
            pCrawl = pCrawl.children[index]; 
        }
        return (pCrawl != null && pCrawl.isEndOfNumberSet); 
    }
    
    void CountSupport(ArrayList<String> key) 
    { 
        int level; 
        int length = key.size(); 
        int index; 
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.get(level).charAt(0)-'1';
            if (pCrawl.children[index] == null)
                System.out.println("No key found!");
            pCrawl = pCrawl.children[index]; 
        } 
        //Setiap key found, maka support +1 untuk key tersebut
        pCrawl.support++; 
    }
    
    int getSupport(ArrayList<String> key)
    {
        int level; 
        int length = key.size(); 
        int index; 
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.get(level).charAt(0)-'1'; 
       
            if (pCrawl.children[index] == null) 
                return 0;
       
            pCrawl = pCrawl.children[index]; 
        } 
        
        return (pCrawl.support); 
    }
    
    void PrintPassedThreshold (ArrayList<String> key, int Threshold){
        int level; 
        int length = key.size(); 
        int index; 
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++){ 
            index = key.get(level).charAt(0)-'1'; 
            if (pCrawl.children[index] == null)
                System.out.println("NULL");
            pCrawl = pCrawl.children[index]; 
        }
        if(pCrawl.support > Threshold)
            System.out.println(key + " Dengan Support = " + pCrawl.support);
    }
    
    void PrintAllDataSupport (ArrayList<String> key){
        int level; 
        int length = key.size(); 
        int index; 
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++){ 
            index = key.get(level).charAt(0)-'1'; 
            if (pCrawl.children[index] == null)
                System.out.println("NULL");
            pCrawl = pCrawl.children[index]; 
        }
        if(pCrawl.support > 0)
            System.out.println(key + " Dengan Support = " + pCrawl.support);
    }
}