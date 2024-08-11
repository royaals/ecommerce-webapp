package com.ecommerce.be_ecommerce.service.impl;

import com.ecommerce.be_ecommerce.exception.ProductException;
import com.ecommerce.be_ecommerce.model.Cart;
import com.ecommerce.be_ecommerce.model.CartItem;
import com.ecommerce.be_ecommerce.model.Product;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.repository.CartRepository;
import com.ecommerce.be_ecommerce.request.AddItemRequest;
import com.ecommerce.be_ecommerce.service.CartItemService;
import com.ecommerce.be_ecommerce.service.CartService;
import com.ecommerce.be_ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;
    private CartItemService cartItemService;
    private ProductService productService;

    public CartServiceImpl(CartRepository cartRepository, CartItemService cartItemService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.cartItemService= cartItemService;
        this.productService = productService;
    }
    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
        Cart cart = cartRepository.findByUserId(userId);

        Product product = productService.findProductById(req.getProductId());

        CartItem isPresent = cartItemService.isCartItemExist(cart, product, req.getSize(), userId);

        if(isPresent == null){
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(req.getQuantity());
            cartItem.setUserId(userId);

            int price = req.getQuantity() * product.getDiscountedPrice();
            cartItem.setPrice(price);
            cartItem.setSize(req.getSize());

            CartItem createdCartItem = cartItemService.createCartItem(cartItem);
            cart.getCartItems().add(createdCartItem);
        }

        return "Item added to cart";

    }

    @Override
    public Cart findUserCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);
        int totalPrice = 0;
        int totalDiscountedPrice = 0;
        int totalItems = 0;

        for (CartItem cartItem : cart.getCartItems()) {
            totalPrice += cartItem.getPrice();
            totalDiscountedPrice += cartItem.getDiscountedPrice();
            totalItems += cartItem.getQuantity();
        }
        cart.setTotalPrice(totalPrice);
        cart.setTotalDiscountedPrice(totalDiscountedPrice);
        cart.setTotalItem(totalItems);
        cart.setDiscount(totalPrice - totalDiscountedPrice);
        return cartRepository.save(cart);



    }
}
