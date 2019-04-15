package com.sams.product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sams.product.domain.Product;
import com.sams.product.exception.ProductNotFoundException;
import com.sams.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	private final Logger logger = LoggerFactory.getLogger(ProductService.class);
	@Autowired
	ProductRepository productRepository;

	public Product save(Product product) {
		logger.info("start of ProductController class save method{}", product.toString());
		return productRepository.save(product);
	}

	public Iterable<Product> all() {
		logger.info("start of ProductController class all method{}");
		return productRepository.findAll();
	}

	public Product findByProductId(Integer productId) {
		logger.info("start of ProductController class findByProductId method{}", productId.toString());
		return productRepository.findProductByProductId(productId).orElseThrow(
				() -> new ProductNotFoundException(HttpStatus.NOT_FOUND.toString(), "Products are Not Found"));
	}
}
