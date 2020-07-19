/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tubes_SDA;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Author = Bima Putra S | 191524038 | D4-1B "2019
 *          M Faza I R | 191524050 | D4-1B'19
 * Politeknik Negeri Bandung
 * Tanggal :
 * Deskripsi :
 */
public class Helper {
    // Kamus Data
    private ArrayList<Transaction> data_trans;
    private ArrayList<Product> data_product;
    
    Map<Integer, Integer> Mapping_Support = new HashMap<Integer, Integer>();
    
    public ArrayList get_product(){    
        Gson gson = new Gson();
        
        try (Reader reader = new FileReader("src/Data_JSON/product.json")){
            
            // Convert dari json menjadi list.   
            Type listtype = new TypeToken<ArrayList<Product>>(){}.getType();
            data_product = gson.fromJson(reader, listtype);  
            
            // Print output data.
            // data_product.forEach(System.out::println);

        }catch (IOException e) {
            e.printStackTrace();
        }
        
        return data_product;
    }
    
    public ArrayList get_transaction(){
        Gson gson = new Gson();
        
        try (Reader reader = new FileReader("src/Data_JSON/transaction.json")){
            
            // Convert dari json menjadi list.   
            Type listtype = new TypeToken<ArrayList<Transaction>>(){}.getType();
            data_trans = gson.fromJson(reader, listtype);  
            
            // Print output data.
            // data_trans.forEach(System.out::println);

        }catch (IOException e) {
            e.printStackTrace();
        }
        
        return data_trans;
    }
    
    public ArrayList get_items(){
        Gson gson = new Gson();
        
        try (Reader reader = new FileReader("src/Data_JSON/transaction.json")){
            
            // Convert dari json menjadi list.   
            Type listtype = new TypeToken<ArrayList<Items>>(){}.getType();
            data_trans = gson.fromJson(reader, listtype);  
            
            // Print output data.
            // data_trans.forEach(System.out::println);

        }catch (IOException e) {
            e.printStackTrace();
        }
        
        return data_trans;
    }
    
    public ArrayList konversiObjString(String tmp){
        ArrayList myList;
        tmp = konversiStringAL(tmp);
        return myList = new ArrayList<String>(Arrays.asList(tmp.split(",")));
    }
    
    public String konversiStringAL(String tmp){
        tmp = tmp.replace("[", "");
        tmp = tmp.replace("]", "");
        tmp = tmp.replace(" ", "");
        return tmp;
    }
    
    public String konversiStringKey(String tmp){
        tmp = konversiStringAL(tmp);
        tmp = tmp.replace(",", "");
        return tmp;
    }
    
    public static <T> List<List<T>> combination(List<T> values, int size) {

        if (0 == size) {
            return Collections.singletonList(Collections.<T> emptyList());
        }

        if (values.isEmpty()) {
            return Collections.emptyList();
        }

        List<List<T>> combination = new LinkedList<List<T>>();

        T actual = values.iterator().next();

        List<T> subSet = new LinkedList<T>(values);
        subSet.remove(actual);

        List<List<T>> subSetCombination = combination(subSet, size - 1);

        for (List<T> set : subSetCombination) {
            List<T> newSet = new LinkedList<T>(set);
            newSet.add(0, actual);
            combination.add(newSet);
        }

        combination.addAll(combination(subSet, size));

        return combination;
    }
    
    public void MenuMain(){
        System.out.println("-- Main Menu\n"
                + "\t1. Show Product\n"
                + "\t2. Show Transaction\n"
                + "\t3. Best Seller Product\n"
                + "\t4. Our Recomendation Bundle\n"
                + "\t5. Product Recommendation Bundle\n"
                + "\t6. Exit");
    }
    
    public int getInput(){
        int tmp;
        
        // Object Initialize
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("##Pilihan : ");
        tmp = parseInt(scanner.nextLine());
        
        return tmp;
    }
    
    public void pilihanMenu(int choice){
        switch(choice){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
        }
    }
//    public void CreateMappingSupport(ArrayList hasil){
//        hasil.forEach(n -> {
//            Mapping_Support.put(parseInt(konversiStringKey(String.valueOf(n))), 0);
//        });
//        SortHashMap();
//    }
//    
//    public void SortHashMap(){
//        // TreeMap to store values of HashMap 
//        TreeMap<Integer, Integer> sorted = new TreeMap<>(); 
//  
//        // Copy all data from hashMap into TreeMap 
//        sorted.putAll(Mapping_Support); 
//  
//        // Display the TreeMap which is naturally sorted 
//        for (Map.Entry<Integer, Integer> entry : sorted.entrySet())  
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//    }
}
