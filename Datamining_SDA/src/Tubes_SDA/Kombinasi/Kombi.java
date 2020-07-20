/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA.Kombinasi;

import java.util.ArrayList;

/**
 *
 * @author Urip
 * Modified by: Bima & Faza
 */
public class Kombi {

    /**
     * @param args the command line arguments
     */
    static int column[];
    static ArrayList<String> ndx;
    static ArrayList<ArrayList<String>> ndxs;
    static int ke;

    /**
     * @param args the command line arguments
     */
    
    // Tujuan : melakukan kombinasi dari nilai n
    public void combinations(int k, int r, int n) {
        column[k] = column[k - 1];
        while (column[k] < n - r + k) {
            column[k] = column[k] + 1;
            if (k < r) {
                combinations(k + 1, r, n);
            } else {
                ndx = new ArrayList<String>();
                for (int j = 1; j <= r; j++) {
                    ndx.add(String.valueOf(column[j]));
                }
                ke++;
                ndxs.add(ke, ndx);
                ndx = ndxs.get(ke);

            }
        }
    }
    
    // Tujuan : operator untuk generate kombinasi dari data n.
    public ArrayList<ArrayList<String>> generate(int n) {
        column = new int[n + 1];
        ndxs = new ArrayList<ArrayList<String>>();
        ke = -1;
        for (int r = 1; r <= n; r++) {
            column[0] = 0;
            combinations(1, r, n);
        }
        return ndxs;
    }
    
    // Tujuan : Output.
    @Override
    public String toString(){
        String tmp = null;
        
        for (int i = 0; i < ndxs.size(); i++) {
            ndx = ndxs.get(i);
            for (int j = 0; j < ndx.size(); j++) {
                tmp += ndx.get(j);
            }
            tmp += "\n";
        }
        
        return tmp;
    }
}
