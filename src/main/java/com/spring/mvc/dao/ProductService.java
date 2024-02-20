package com.spring.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.models.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	//create product
	public void createProduct(Product product) {
		productDao.create(product);
	}
	
	//Get all products
	public List<Product> allProducts(){
		List<Product> products = productDao.getAllProducts();
		return products;
	}
	
	//Get product of specific id
	public Product oneProduct(int id) {
		Product product = productDao.getProduct(id);
		return product;
	}
	
	//delete a product of specific id
	public void removeProduct(int id) {
		productDao.deleteProduct(id);
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
}
