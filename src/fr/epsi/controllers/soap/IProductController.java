/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.controllers.soap;

import fr.epsi.beans.Product;
import javax.jws.WebService;

/**
 * Interface pour le Soap
 */
@WebService(name="ProductService", serviceName="ProductService")
public interface IProductController {
    public Product[] getProducts();
}
