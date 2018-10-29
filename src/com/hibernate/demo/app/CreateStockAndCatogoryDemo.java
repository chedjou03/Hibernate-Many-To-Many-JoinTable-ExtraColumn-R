package com.hibernate.demo.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Category;
import com.hibernate.demo.entity.Stock;
import com.hibernate.demo.entity.StockCategory;
import com.hibernate.demo.entity.StockCategoryId;



public class CreateStockAndCatogoryDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Stock.class)
													.addAnnotatedClass(StockCategory.class)
													.addAnnotatedClass(StockCategoryId.class)
													.addAnnotatedClass(Category.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//start transaction
			session.beginTransaction();
			
			 Stock stock = new Stock();
			    stock.setStockCode("3455");
			    stock.setStockName("Toyota");
			 
			    Category category1 = new Category("Car", "Toyota COMPANY");
			    //new category, need save to get the id first
			    session.save(category1);
			    
			    StockCategory stockCategory = new StockCategory();
			    stockCategory.setStock(stock);
			    stockCategory.setCategory(category1);
			    stockCategory.setCreatedDate(new Date()); //extra column
			    stockCategory.setCreatedBy("system"); //extra column
			        
			    stock.getStockCategories().add(stockCategory);
			        
			    session.save(stock);
							
						
			//commit the transaction
			session.getTransaction().commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

	}

}
