package net.vns.myonlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.vns.myonlineshopping.exception.ProductNotFoundException;
import net.vns.myshoppingbackend.dao.CategoryDAO;
import net.vns.myshoppingbackend.dao.ProductDAO;
import net.vns.myshoppingbackend.dto.Category;
import net.vns.myshoppingbackend.dto.Product;


@Controller
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
    @RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("page1");
		mv.addObject("title","Home");
		logger.info("inside page controller index method-info");
		logger.debug("inside page controller index method -Debug");
		/*mv.addObject("greeting", "welcome to my page");*/
		//passing list of category
		mv.addObject("cagegories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		
		return mv;
	}
    
    
    @RequestMapping(value= "/about")
  	public ModelAndView about() {
  		ModelAndView mv=new ModelAndView("page1");
  		mv.addObject("title","About Us");
  		/*mv.addObject("greeting", "welcome to my page");*/
  		mv.addObject("userClickAbout", true);
  		
  		return mv;
  	}
    
    @RequestMapping(value= "/contact")
  	public ModelAndView contact() {
  		ModelAndView mv=new ModelAndView("page1");
  		mv.addObject("title","Contact Us");
  		/*mv.addObject("greeting", "welcome to my page");*/
  		mv.addObject("userClickContact", true);
  		
  		return mv;
  	}
  /*  @RequestMapping(value= "/about")
	public ModelAndView about() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
  
    @RequestMapping(value= "/contact")
   	public ModelAndView contact() {
   		ModelAndView mv=new ModelAndView("page");
   		mv.addObject("title","Contact Us");
   		mv.addObject("userClickContact", true);
   		return mv;
   	}*/
    
    /*
     * method load all the product and depends upon the category
     * */
    
    @RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv=new ModelAndView("page1");
		mv.addObject("title","All Products");
		/*mv.addObject("greeting", "welcome to my page");*/
		//passing list of category
		mv.addObject("cagegories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		
		return mv;
	}
    
    @RequestMapping(value="/show/category/{id}/products")
   	public ModelAndView showCategoryProducts(@PathVariable("id")int id) {
   		ModelAndView mv=new ModelAndView("page1");
   		//categoryDAO to fetch single category
   		Category category=null;
   		category=categoryDAO.get(id);
   		
   		mv.addObject("title",category.getName());
   		/*mv.addObject("greeting", "welcome to my page");*/
   		//passing list of category
   		mv.addObject("cagegories", categoryDAO.list());
   		//passing the single category object
   		mv.addObject("category", category);
   		mv.addObject("userClickCategoryProducts", true);
   		
   		return mv;
   	}
    
    @RequestMapping(value="/show/{id}/product")
    public ModelAndView showSingleProduct(@PathVariable int id)throws ProductNotFoundException {
    	ModelAndView mv=new ModelAndView("page1");
    	Product product=productDAO.get(id);
    	if(product==null)throw new ProductNotFoundException();
    	//update the View count
    	product.setViews(product.getViews()+1);
    	productDAO.update(product);
    	mv.addObject("title",product.getName());
    	mv.addObject("product",product);
    	mv.addObject("userClickShowProducts", true);
    	
    	
    	
    	return mv;
    	
    }
    
    
}
