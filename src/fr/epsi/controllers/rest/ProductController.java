/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.controllers.rest;

import javax.servlet.http.HttpServletResponse;

import fr.epsi.beans.Product;
import fr.epsi.models.Products;

import org.springframework.http.MediaType;
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
public class ProductController {

	@RequestMapping(value = "/product/{reference}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product order(@PathVariable("reference") String reference, HttpServletResponse resp) {

		try {
			Products productModel = Products.getInstance();

			// On recupere le produit par reference
			Product product = productModel.findByRef(reference);
			
			if (product != null) {
				return product;
			} else {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
			return null;
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product[] order(HttpServletResponse resp) {

		try {
			Products productModel = Products.getInstance();

			// On recupere le produit par reference
			Product[] product = productModel.getAllProduct();
			
			if (product != null) {
				return product;
			} else {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
			return null;
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
}
