package net.vns.myshoppingbackend.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.vns.myshoppingbackend.dao.CategoryDAO;
import net.vns.myshoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	private static List<Category> cagegories=new ArrayList<>();
	
/*	static {
		Category category=new Category();
		category.setId(1);
		category.setName("LED");
		category.setDescription("LED description !");
		category.setImageURL("Cal_1_led.png");
		cagegories.add(category);
		
		
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Laptop description !");
		category.setImageURL("Cal_1_Lap.png");
		cagegories.add(category);
		
		category=new Category();
		category.setId(4);
		category.setName("AllInOne");
		category.setDescription("All In One description !");
		category.setImageURL("All_1_Lap.png");
		cagegories.add(category);
		
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Mobile description !");
		category.setImageURL("Cal_1_mob.png");
		cagegories.add(category);
	}*/

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}
/*
 * Getting single category based on id
 * */
	@Override
	public Category get(int id) {
		// enhance for loop
		/*for(Category category:cagegories) {
			
			if(category.getId()==id) return category;
		}*/
		
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

	@Override
	
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		
		
		try {
			//add category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}
