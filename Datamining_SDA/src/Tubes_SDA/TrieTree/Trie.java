/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA.TrieTree;

import java.util.ArrayList;

/**
 *
 * @author Sumit Ghosh - GFG
 */
public class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    void insert(ArrayList<String> key) 
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
    
    boolean search(ArrayList<String> key) 
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
}
