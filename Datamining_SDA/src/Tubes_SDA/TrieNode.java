/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA;

/**
 *
 * @author Sumit Ghosh - GFG
 */
public class TrieNode {

    static final int ALPHABET_SIZE = 26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];

    // isEndOfWord is true if the node represents 
    // end of a word 
    boolean isEndOfWord;

    TrieNode() 
    {
        isEndOfWord = false;
        for (int i = 0; i < ALPHABET_SIZE; i++) 
        {
            children[i] = null;
        }
    }
}
