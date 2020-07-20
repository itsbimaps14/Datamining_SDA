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
    Map<String, Integer> Data_Support = new HashMap<String, Integer>();
    
    // Object
    Trie t_Obj;
    
    // Tujuan : extracting data dari Sumber Data (JSON - product.json)
    public ArrayList get_product(){    
        Gson gson = new Gson();
        try (Reader reader = new FileReader("src/Data_JSON/product.json")){
            // Convert dari json menjadi list.   
            Type listtype = new TypeToken<ArrayList<Product>>(){}.getType();
            data_product = gson.fromJson(reader, listtype);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return data_product;
    }
    
    // Tujuan : extracting data dari Sumber Data (JSON - transaction.json)
    public ArrayList get_transaction(){
        Gson gson = new Gson();
        try (Reader reader = new FileReader("src/Data_JSON/transaction.json")){
            // Convert dari json menjadi list.   
            Type listtype = new TypeToken<ArrayList<Transaction>>(){}.getType();
            data_trans = gson.fromJson(reader, listtype);  

        }catch (IOException e) {
            e.printStackTrace();
        }
        return data_trans;
    }
    
    // Tujuan : extracting data dari tetapi items saja Sumber Data (JSON - transaction.json)
    public ArrayList get_items(){
        Gson gson = new Gson();
        try (Reader reader = new FileReader("src/Data_JSON/transaction.json")){
            Type listtype = new TypeToken<ArrayList<Items>>(){}.getType();
            data_trans = gson.fromJson(reader, listtype);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return data_trans;
    }
    
    // Tujuan : merubah String dari sebuah object menjadi ArrayList
    public ArrayList konversiObjString(String tmp){
        ArrayList myList;
        tmp = konversiStringAL(tmp);
        return myList = new ArrayList<String>(Arrays.asList(tmp.split(",")));
    }
    
    // Tujuan : menghilangkan karakter “[“, “]”, dan “ “ dari sebuah String
    public String konversiStringAL(String tmp){
        tmp = tmp.replace("[", "");
        tmp = tmp.replace("]", "");
        tmp = tmp.replace(" ", "");
        return tmp;
    }
    
    // Tujuan : menghilangkan karakter “[“, “]”, dan “ “ dari sebuah String
    public String konversiStringKey(String tmp){
        tmp = konversiStringAL(tmp);
        tmp = tmp.replace(",", "");
        return tmp;
    }
    
    // Tujuan
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
    
    // Tujuan : menampilkan menu program pada layar
    public void MenuMain(){
        System.out.println("** Main Menu\n"
                + "\t1. Show Product\n"
                + "\t2. Show Transaction\n"
                + "\t3. Best Seller Product\n"
                + "\t4. Our Recomendation Bundle\n"
                + "\t5. Product Recommendation Bundle\n"
                + "\t6. Exit");
    }
    
    // Tujuan : meminta input dari user
    public int getInput(){
        int tmp;
        // Object Initialize
        Scanner scanner = new Scanner(System.in);
        System.out.print("## Pilihan : ");
        tmp = parseInt(scanner.nextLine());
        return tmp;
    }
    
    // Tujuan : menampilkan daftar transaksi dari hasil input data pada layar 
    // saat user memilih pilihan 2 pada main menu
    public void PrintTransactions(){
        ArrayList list = new ArrayList<String>();
        data_trans.forEach(n -> {
            n.removeFalseItem();
            if (n.toString() != "[]") {
                list.add(n.toString());
            }
        });
        for (int i = 0; i < data_trans.size(); i++)
            System.out.println(data_trans.get(i).display());
    }
    
    // Tujuan : method switch yang berfungsi untuk menerima input dari user 
    // lalu menjalankan case yang sesuai dengan input dari user
    public void pilihanMenu(int choice, ArrayList hasil, Trie root){
        t_Obj = root;
        switch(choice){
            case 1:
                ch1_showProduct();
                break;
            case 2:
                PrintTransactions();
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                ch5_productRecomBundle(hasil);
                break;
        }
    }
    
    // Tujuan : menampilkan bundle barang yang direkomendasikan berdasarkan input dari user
    public void pilihanCh5(int choice, ArrayList hasil){
        String pilihan = Integer.toString(choice);
        
        for(int j = 0; j < hasil.size(); j++){
            ArrayList data = (ArrayList) hasil.get(j);
            boolean convert = konversiStringKey(String.valueOf(hasil.get(j))).contains(pilihan);
            int ukuran = data.size();
            String tinggi = hasil.get(j).toString();
            Data_Support.put(hasil.get(j).toString(), t_Obj.getSupport(data));
            
            if(ukuran == data.size() && convert && ukuran != 1){
                System.out.println(hasil.get(j).toString() +"-"+ t_Obj.getSupport(data));
                if(Data_Support.get(tinggi) >= t_Obj.getSupport(data)){
                    tinggi = hasil.get(j).toString();
                    Data_Support.clear();
                    Data_Support.put(hasil.get(j).toString(), t_Obj.getSupport(data));
                }
            }
            else{
                OutputHighHashMap(Data_Support);
                Data_Support.clear();
            }
        }
    }
    
    // Tujuan : menampilkan daftar produk dari hasil input data pada layar.
    public void ch1_showProduct(){
        System.out.println("\n-- List Product : ");
        data_product.forEach(n -> {
            System.out.println("\t"+n.toString());
        });
    }
    
    // Tujuan : menampilkan list produk menggunakan method ch1_showProduct()
    public void ch5_productRecomBundle(ArrayList hasil){
        ch1_showProduct();
        int choice = getInput();
        pilihanCh5(choice, hasil);
    }
    
    // Tujuan : menampilkan nilai terbesar (pertama) dari sebuah hashMap
    public void OutputHighHashMap(Map hashMap){
        // TreeMap to store values of HashMap 
        TreeMap<String, Integer> sorted = new TreeMap<>(); 
  
        // Copy all data from hashMap into TreeMap 
        sorted.putAll(hashMap); 
  
        // Display the TreeMap which is naturally sorted 
        for (Map.Entry<String, Integer> entry : sorted.entrySet()){
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            break;
        }
    }
}

