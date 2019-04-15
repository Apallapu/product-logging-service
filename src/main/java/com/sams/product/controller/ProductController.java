package com.sams.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sams.product.domain.Product;
import com.sams.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ankamma pallapu
 *
 */
@RestController
@Slf4j
public class ProductController {
	private final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService ProductService;

	public ProductController(ProductService ProductService) {
		super();
		this.ProductService = ProductService;
	}

	@PostMapping(value = "/product")
	public Product save(@RequestBody Product product) {
		logger.info("start of ProductController class save method{}" ,product.toString());
		return ProductService.save(product);
	}

	@GetMapping(value = "/product")
	public Iterable<Product> all() {
		logger.info("start of ProductController class all method{}");
		return ProductService.all();
	}

	@GetMapping(value = "/product/{productId}")
	public Product findByProductId(@PathVariable Integer productId) {
		logger.info("start of ProductController class findByProductId method{}", productId.toString());
		return ProductService.findByProductId(productId);
	}
}
