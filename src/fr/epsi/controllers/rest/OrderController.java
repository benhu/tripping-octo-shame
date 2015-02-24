/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.controllers.rest;

import fr.epsi.beans.Product;
import fr.epsi.models.Products;
import fr.epsi.models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value = "/order/{reference}/{quantity}/{guid}", method = RequestMethod.GET)
    public @ResponseBody
    String order(@PathVariable("reference") String reference, @PathVariable("quantity") int quantity, @PathVariable("guid") String guid) {

        String msg;                              // le message a retourner
        Users userModel = Users.getInstance();   //Recupere l'insatnce de user

        try {
            // Si on trouve un user correspondant au guid
            if (userModel.findByGUID(guid) != null) {
                Products productModel = Products.getInstance();
                
                // On recupere le produit par reference
                Product product = productModel.findByRef(reference);

                if (product == null) {
                    msg = "Produit inexistant";
                } else if (quantity <= 0) {
                    msg = "Erreur de quantité";
                } else if (product.getQuantity() == 0) {
                    msg = "Produit épuisé";
                } else if (product.getQuantity() < quantity) {
                    msg = "Quantité insuffisante";
                } else {
                    //On decremente la quantite du produit
                    product.setQuantity(product.getQuantity() - quantity);

                    msg = "Produit commandé !";
                }
            } else {
                msg = "User not found";
            }
        } catch (Exception e) {
            msg = "Error";
        }

        return msg;
    }
}
