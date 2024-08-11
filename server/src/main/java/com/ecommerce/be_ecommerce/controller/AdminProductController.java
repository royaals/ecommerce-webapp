package com.royal.controller;

import com.ecommerce.be_ecommerce.exception.ProductException;
import com.ecommerce.be_ecommerce.model.Product;
import com.ecommerce.be_ecommerce.request.CreateProductRequest;
import com.ecommerce.be_ecommerce.response.ApiResponse;
import com.ecommerce.be_ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Admin Product", description = "APIs for Admin to manage products")
public class AdminProductController {
    @Autowired
    private ProductService productService;

    @Operation(summary = "Create a new product")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Product created")
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest req) {
        Product product = productService.createProduct(req);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete a product")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Product deleted")
    @DeleteMapping("/{productId}/delete")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) throws ProductException {
        productService.deleteProduct(productId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Product deleted successfully");
        res.setStatus(true);
        return new ResponseEntity<ApiResponse>(res, HttpStatus.OK);
    }

    @Operation(summary = "Get all products")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "List of products")
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

    }

    @Operation(summary = "Update a product")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Product updated")
    @PutMapping("/{productId}/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long productId)
            throws ProductException {
        Product updatedProduct = productService.updateProduct(productId, product);
        return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
    }

    @Operation(summary = "Create multiple products")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Products created")
    @PostMapping("/create-multi")
    public ResponseEntity<ApiResponse> createMultipleProducts(@RequestBody CreateProductRequest[] req) {
        for (CreateProductRequest product : req) {
            productService.createProduct(product);
        }
        ApiResponse res = new ApiResponse();
        res.setMessage("Products created successfully");
        res.setStatus(true);
        return new ResponseEntity<ApiResponse>(res, HttpStatus.CREATED);
    }

}
