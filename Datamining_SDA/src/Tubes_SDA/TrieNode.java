/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA;


/**
 *
 * @author Sumit Ghosh - GFG
 * Modified by: Bima & Faza
 */
public class TrieNode {

    static final int NUMBER_SIZE = 10;
    TrieNode[] children = new TrieNode[NUMBER_SIZE];

    // isEndOfWord is true if the node represents 
    // end of a word 
    boolean isEndOfNumberSet;
    int support;
    
    // Tujuan : accessor untuk field Support
    public int getSupport(){
        return support;
    }
    
    TrieNode(){
        support = 0;
        isEndOfNumberSet = false;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            children[i] = null;
        }
    }
}
