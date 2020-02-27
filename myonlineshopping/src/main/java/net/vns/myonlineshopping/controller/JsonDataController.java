package net.vns.myonlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.vns.myshoppingbackend.dao.ProductDAO;
import net.vns.myshoppingbackend.dto.Product;


@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	@Autowired
	private ProductDAO productDAO;
	

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {		
	return productDAO.listActiveProducts();
				
	}	
	
	
	
	
	@RequestMapping("admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin() {		
	return productDAO.list();
				
	}	
	
	
	@RequestMapping("/catgory/{id}/products")
	
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {		
	
	return productDAO.listActiveProductsByCategory(id);
				
	}	

}
