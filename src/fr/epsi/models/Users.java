/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.models;

import fr.epsi.beans.User;
import java.util.UUID;

/**
 * La classe de tous les utilisateurs
 */
public class Users {

    private final User[] userList; //la liste utilisateur
    private static Users instance; //l'instance

    /**
     * Constructeur
     */
    private Users() {
        this.userList = new User[]{
            new User(0, "test", "test"),
            new User(1, "admin", "test")
        };
    }
    
    /**
     * On recupere l'instance
     * @return l'instance
     */
    public static Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }
        return instance;
    }
    
    /**
     * Permet de retrouver un utilisateur par son id
     * @param id l'identifiant
     * @return user l'utilisateur
     */
    public User findById(int id) {
        for (User user : this.userList) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    /**
     * Retourne l'utilisateur selon son nom
     * @param username le username
     * @return le user
     */
    public User findByUsername(String username) {
        for (User user : this.userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    /**
     * Retourne un utilisateur par son guid 
     * @param guid le token
     * @return  le user
     */
    public User findByGUID(String guid) {
        UUID uuid = UUID.fromString(guid);

        for (User user : this.userList) {
            if (user.getGUID() != null && user.getGUID().equals(uuid)) {
                return user;
            }
        }

        return null;
    }
}
