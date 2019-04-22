package vendingmachine;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alper
 */
public class ProductReader {
    
    public  static List<Product> readProducts(){
        List<Product> productsList = new  ArrayList<>();
        try {
            Scanner txtInput = new Scanner(new File("data.txt"));
            while (txtInput.hasNextLine()) {
                String[] nextLine = txtInput.nextLine().split("##");
                String name = nextLine[0];
                String description = nextLine[1];
                double price = Double.parseDouble(nextLine[2]);
                productsList.add(new Product(name, price, description));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productsList;
    }
    
}
