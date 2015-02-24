/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.models;

import fr.epsi.beans.Product;

/**
 * Classe de tout les produits
 */
public class Products {

    private final Product[] productList; // Liste des produits
    private static Products instance;   // Instance des produitss

    /**
     * Constructeur
     */
    private Products() {
        this.productList = new Product[]{
            new Product("5236", "Produit 1", 2),
            new Product("5237", "Produit 2", 10)
        };
    }

    public static Products getInstance() {
        if (instance == null) {
            instance = new Products();
        }
        return instance;
    }

    public Product[] getAllProduct() {
        return this.productList;
    }

    /**
     * OSEF
     *
     * @param reference
     * @return
     */
    public Product findByRef(String reference) {
        for (Product ornf : this.productList) {
            if (ornf.getReference().equals(reference)) {
                return ornf;
            }
        }
        return null;
    }
}
