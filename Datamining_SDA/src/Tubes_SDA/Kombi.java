/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA;

import java.util.ArrayList;

/**
 *
 * @author Blek
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
    public void combinations(int k, int r, int n) {
        column[k] = column[k - 1];
        while (column[k] < n - r + k) {
            column[k] = column[k] + 1;
            if (k < r) {
                combinations(k + 1, r, n);
            } else {
// System.out.print("\n{");
                ndx = new ArrayList<String>();
                for (int j = 1; j <= r; j++) {
// System.out.print(column[j]);
                    ndx.add(String.valueOf(column[j]));
// if(j!=r)
// System.out.print(",");

                }
// System.out.print("}");
                ke++;
                ndxs.add(ke, ndx);
                ndx = ndxs.get(ke);

            }
        }
    }

    public ArrayList<ArrayList<String>> generate(int n) {
    // TODO code application logic here
        column = new int[n + 1];
        ndxs = new ArrayList<ArrayList<String>>();
        ke = -1;
        for (int r = 1; r <= n; r++) {
            column[0] = 0;
            combinations(1, r, n);
            System.out.printf("\nke=%d", r);
        }
        System.out.print("\n\nHASIL:");
        for (int i = 0; i < ndxs.size(); i++) {
            ndx = ndxs.get(i);
            System.out.print("\t\tUkuran ndxs[" + i + "]=" + ndx.size());
            System.out.print("\n\t{");
            for (int j = 0; j < ndx.size(); j++) {
                if (j > 0) {
                    System.out.print("," + ndx.get(j));
                } else {
                    System.out.print(ndx.get(j));
                }
            }
            System.out.print("}");
        }
        return ndxs;
    }
}
