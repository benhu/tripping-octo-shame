/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.controllers.rest;

import fr.epsi.beans.User;
import fr.epsi.models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller pour se logger
 */
@Controller
public class LoginController {
    
    /**
     * Methode qui permet de connecter un utilisateur
     * @param username le username de l'utilisateur
     * @param password le password de l'utilisateur
     * @return Un message statut de la connexion
     */
    @RequestMapping(value = "/connect/{username}/{password}", method = RequestMethod.GET)
    public @ResponseBody
    String connect(@PathVariable("username") String username, @PathVariable("password") String password) {

        try {
            Users userModel = Users.getInstance();
            //On recuoere le user
            User user = userModel.findByUsername(username);
            
            // On retourne le guuid de l'utilisateur
            if (user.getPassword().equals(password)) {
                return user.generateGUID().toString();
            }

        } catch (Exception e) {
            
        }
        return "Bad login or password";
    }

    /**
     * Methode qui deconnecte un utilisateur
     * @param guid le guid de l'utilisateur connecte
     */
    @RequestMapping(value = "/disconnect/{guid}", method = RequestMethod.GET)
    public @ResponseBody
    void disconnect(@PathVariable("guid") String guid) {

        try {
            // On recupère l'instance et on la supprime
            Users userModel = Users.getInstance();
            userModel.findByGUID(guid).clearGUID();
        } catch (Exception e) {

        }
    }
}
