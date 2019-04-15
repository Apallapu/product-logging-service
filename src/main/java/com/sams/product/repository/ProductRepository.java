/**
 * 
 */
package com.sams.product.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sams.product.domain.Product;

/**
 * @author ankamma pallapu
 *
 */
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	Optional<Product> findProductByProductId(Integer productId);
}
