/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.beans;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe qui represente l'utilisateur
 * 
 */
public class User {

    private final int id;           // l'identifiant de l'utilisateur 
    private final String username;  // Son nom d'utilisateur
    @JsonIgnore
    private final String password;  // Le mot de passe de l'utilisateur
    private UUID guid;              // le token utilisateur

    /**
     * Genere un nouveau uuid pour l'utlisateur
     * @return un nouveau uuid
     */
    public UUID generateGUID(){
        return this.guid = UUID.randomUUID();
    }
    
    /**
     * Supprime le guuid
     */
    public void clearGUID(){
        this.guid = null;
    }

    /**
     * Constructeur
     * @param id l'identifiant de l'utilisateur
     * @param username le username de l'utilisateur 
     * @param password le password de l'utilisateur
     */
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public UUID getGUID() {
        return guid;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
