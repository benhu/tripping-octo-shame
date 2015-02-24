/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.controllers.rest;

import fr.epsi.beans.Product;
import fr.epsi.models.Products;
import fr.epsi.models.Users;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller pour faire une commande
 * 
 */
@Controller
public class OrderController {
    
    /**
     * Methode pour les commandes
     * @param reference la reference du produit
     * @param quantity la quantite voulue
     * @param guid l'identifiant de l'utilisateur
     * @return Un message selon le statut de la commande
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Product order(@RequestParam("reference") String reference, @RequestParam("quantity") int quantity, @RequestParam("token") String token) {

        Users userModel = Users.getInstance();   //Recupere l'instance de user

        try {
            // Si on trouve un user correspondant au guid
            if (userModel.findByGUID(token) != null) {
                Products productModel = Products.getInstance();
                
                // On recupere le produit par reference
                Product product = productModel.findByRef(reference);

                if (product == null) {
                	//TODO : HttpResponse
                    //msg = "Produit inexistant";
                } else if (quantity <= 0) {
                	//TODO : HttpResponse
                    //msg = "Erreur de quantité";
                } else if (product.getQuantity() == 0) {
                	//TODO : HttpResponse
                    //msg = "Produit épuisé";
                } else if (product.getQuantity() < quantity) {
                	//TODO : HttpResponse
                    //msg = "Quantité insuffisante";
                } else {
                    //On decremente la quantite du produit
                    product.setQuantity(product.getQuantity() - quantity);
                    
                    return new Product(product.getReference(),product.getName(),quantity);
                }
            } else {
            	//TODO : HttpResponse
                //msg = "User not found";
            }
        } catch (Exception e) {
        	//TODO : HttpResponse
        	//msg = "Error";
        }

        return null;
    }
}
