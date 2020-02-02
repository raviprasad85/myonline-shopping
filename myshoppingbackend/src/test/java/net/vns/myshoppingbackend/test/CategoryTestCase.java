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
	
	@Test
	public void testGetCategory(){
		category=categoryDAO.get(1);
		assertEquals("Successfully fetch a category  the table!","LED",category.getName());
		
	}
	
}
