/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.beans;

/**
 * Classe representant les produits
 * 
 */
public class Product {
    private String reference;   // la reference du produit
    private String name;        // Le nom du produit
    private int quantity;       // La quantite du produit

    /**
     * Constructeur
     * @param reference reference du produit
     * @param name nom du produit
     * @param quantity quantite du produit
     */
    public Product(String reference, String name, int quantity) {
        this.reference = reference;
        this.name = name;
        this.quantity = quantity;
    }

    public String getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setName(String name) {
        this.name = name;
    }
}
