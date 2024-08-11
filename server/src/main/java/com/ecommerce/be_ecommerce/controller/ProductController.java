package com.ecommerce.be_ecommerce.controller;

import com.ecommerce.be_ecommerce.exception.ProductException;
import com.ecommerce.be_ecommerce.model.Product;
import com.ecommerce.be_ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@SecurityRequirement(
        name = "Bearer Authentication"
)
@Tag(name = "Product", description = "APIs for Products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Get all products (with filters)")
    @ApiResponse(
            responseCode = "200",
            description = "List of products"
    )
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> findProductByCategory(@RequestParam("category") String category,
                                                               @RequestParam List<String> color,
                                                                @RequestParam List<String> size,
                                                               @RequestParam Integer minPrice,
                                                                @RequestParam Integer maxPrice,
                                                               @RequestParam Integer minDiscount,
                                                               @RequestParam String sort,
                                                               @RequestParam String stock,
                                                               @RequestParam Integer pageNumber,
                                                                @RequestParam Integer pageSize) {

        Page<Product> res = productService.getAllProducts(category, color, size, minPrice, maxPrice, minDiscount, sort, stock, pageNumber, pageSize);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Operation(summary = "Get product by id")
    @ApiResponse(
            responseCode = "200",
            description = "Product found"
    )
    @GetMapping("/products/id/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable Long productId) throws ProductException {
        Product res = productService.findProductById(productId);
        return new ResponseEntity<Product>(res, res == null ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }
//
//    @GetMapping("/products/search")
//    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword) {
//        List<Product> res = productService.searchProduct(keyword);
//        return new ResponseEntity<List<Product>>(res, res.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
//    }



}
