package com.royal.service;

import com.ecommerce.be_ecommerce.exception.ProductException;
import com.ecommerce.be_ecommerce.model.Product;
import com.ecommerce.be_ecommerce.request.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public Product createProduct(CreateProductRequest req);

    public String deleteProduct(Long productId) throws ProductException;

    public Product updateProduct(Long productId, Product product) throws ProductException;

    public Product findProductById(Long id) throws ProductException;

    public List<Product> findProductByCategory(String category);

    public List<Product> findAllProducts();

    public Page<Product> getAllProducts(String category, List<String> colors, List<String> sizes,
            Integer minPrice, Integer maxPrice,
            Integer minDiscount, String sort, String stock,
            Integer pageNumber, Integer pageSize);
}
