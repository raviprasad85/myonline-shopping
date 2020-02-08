package net.vns.myshoppingbackend.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.vns.myshoppingbackend.dao.CategoryDAO;
import net.vns.myshoppingbackend.dto.Category;


public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private static Category category;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.vns.myshoppingbackend");
		context.refresh();
		categoryDAO =(CategoryDAO)context.getBean("categoryDAO");
	}
	
	
	/*@Test
	public void testAddCategory() {
		category = new Category();
		category.setId(1);
		category.setName("LED");
		category.setDescription("LED description !");
		category.setImageURL("Cal_1_led.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
	}*/
	
/*	@Test
	public void testGetCategory(){
		category=categoryDAO.get(1);
		assertEquals("Successfully fetch a category  the table!","LED",category.getName());
		
	}*/
	
	
	/*	@Test
	public void testUpdateCategory(){
		category=categoryDAO.get(1);
		category.setName("LCD");
		assertEquals("Successfully updadte a category  the table!",true,categoryDAO.update(category));
		
	}*/
	
	
	/*	@Test
	public void testDeleteCategory(){
		category=categoryDAO.get(1);
		
		assertEquals("Successfully delete a category  the table!",true,categoryDAO.delete(category));
		
	}*/
	
	
	/*@Test
	public void testListCategory(){
		category=categoryDAO.get(1);
		
		assertEquals("Successfully fatch of the list category  the table!",3,categoryDAO.list().size());
		
	}*/
	
	
	@Test
	public void testCRUDCategory() {
		category = new Category();
	    category.setName("Laptop");
		category.setDescription("Laptop description !");
		category.setImageURL("Cat_1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		category = new Category();
		category.setName("Television");
		category.setDescription("Television description !");
		category.setImageURL("Cat_2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		//fetching and update the category
		category=categoryDAO.get(2);
		category.setName("LCD");
		assertEquals("Successfully updadte a category  the table!",true,categoryDAO.update(category));
		
		//delete the category
		assertEquals("Successfully delete a category  the table!",true,categoryDAO.delete(category));
		
		//fetching the list
		assertEquals("Successfully fatch of the list category  the table!",1,categoryDAO.list().size());
	}
	
}
