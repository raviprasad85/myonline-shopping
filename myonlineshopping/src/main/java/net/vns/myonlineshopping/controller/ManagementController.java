package net.vns.myonlineshopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.vns.myshoppingbackend.dao.CategoryDAO;
import net.vns.myshoppingbackend.dao.ProductDAO;
import net.vns.myshoppingbackend.dto.Category;
import net.vns.myshoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation) {
		ModelAndView mv=new ModelAndView("page1");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		Product nProduct = new Product();
		//set of few fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product",nProduct);
		
		if(operation!=null) {
			if(operation.equals("product")) {
				mv.addObject("message","Product submitted Succesfully!");
			}
		}
		return mv;
	}
	//handling product submission
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@ModelAttribute("product")Product MProduct) {
		
		logger.info(MProduct.toString());
		//create a new product record
        productDAO.add(MProduct);
		
		return "redirect:/manage/products?operation=product";
		
	}
	
	//returning all the categories
	@ModelAttribute("categories") 
	public List<Category> modelCategories() {
		return categoryDAO.list();
	}

}
