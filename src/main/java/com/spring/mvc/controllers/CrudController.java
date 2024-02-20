package com.spring.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.mvc.dao.ProductService;
import com.spring.mvc.models.Product;

@Controller
public class CrudController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/home")
	public ModelAndView showHomeView() {
		ModelAndView mv = new ModelAndView();
		List<Product> products = service.allProducts();
		mv.addObject("products", products);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/add-product")
	public String showAddProductView(Model m) {
		m.addAttribute("title", "Add Product");
		return "addProduct";
	}
	
	@RequestMapping(path="/handle-form", method = RequestMethod.POST)
	public RedirectView handleAddProductForm(@ModelAttribute Product product, HttpServletRequest request) {
		RedirectView rv = new RedirectView();
		service.createProduct(product);
		rv.setUrl(request.getContextPath() + "/");
		return rv;
	}
	
	@RequestMapping(path="/delete/{id}")
	public RedirectView handleDelete(@PathVariable("id") int p_id, HttpServletRequest request) {
		RedirectView rv = new RedirectView();
		service.removeProduct(p_id);
		rv.setUrl(request.getContextPath() + "/");
		return rv;
	}
	
	@RequestMapping(path="/update/{id}")
	public ModelAndView handleUpdate(@PathVariable("id") int p_id) {
		ModelAndView mv = new ModelAndView();
		Product product = service.oneProduct(p_id);
		mv.addObject("product",product);
		mv.setViewName("updateProduct");
		return mv;
	}
	
}
