package com.spring.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.models.Product;

@Repository
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//Create a new product
	@Transactional
	public void create(Product product) {
		hibernateTemplate.saveOrUpdate(product);
	}
	
	//Get all products
	public List<Product> getAllProducts(){
		List<Product> products = hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//Get product of specific id
	public Product getProduct(int id) {
		Product product = hibernateTemplate.get(Product.class, id);
		return product;
	}
	
	//delete a product of specific id
	@Transactional
	public void deleteProduct(int id) {
		Product product = hibernateTemplate.load(Product.class, id);
		hibernateTemplate.delete(product);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
