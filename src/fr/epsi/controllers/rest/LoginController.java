/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.controllers.rest;

import javax.servlet.http.HttpServletResponse;

import fr.epsi.beans.User;
import fr.epsi.models.Users;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(value = "/connect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User connect(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse resp) {

        try {
            Users userModel = Users.getInstance();
            //On recuoere le user
            User user = userModel.findByUsername(username);
            
            // On retourne le guuid de l'utilisateur
            if (user.getPassword().equals(password)) {
            	user.generateGUID();
                return user;
            }

        } catch (Exception e) {
            
        }
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    /**
     * Methode qui deconnecte un utilisateur
     * @param guid le guid de l'utilisateur connecte
     */
    @RequestMapping(value = "/disconnect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    void disconnect(@RequestParam("token") String token) {

        try {
            // On recupère l'instance et on la supprime
            Users userModel = Users.getInstance();
            userModel.findByGUID(token).clearGUID();
          //TODO : HttpResponse
        } catch (Exception e) {

        }
    }
}
