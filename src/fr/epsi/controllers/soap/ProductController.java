/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.controllers.soap;

import fr.epsi.beans.Product;
import fr.epsi.models.Products;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Controller pour les produits
 */
public class ProductController implements IProductController {

    @Autowired
    private fr.epsi.controllers.soap.ProductController productController;

    /**
     * Renvoie une liste de produit
     * @return la liste de produit
     */
    @Override
    public Product[] getProducts() {
        Products products = Products.getInstance();
        
        return products.getAllProduct();
    }

}
