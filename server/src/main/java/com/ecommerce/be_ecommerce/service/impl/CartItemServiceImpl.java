package com.ecommerce.be_ecommerce.service.impl;

import com.ecommerce.be_ecommerce.exception.CartItemException;
import com.ecommerce.be_ecommerce.exception.UserException;
import com.ecommerce.be_ecommerce.model.Cart;
import com.ecommerce.be_ecommerce.model.CartItem;
import com.ecommerce.be_ecommerce.model.Product;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.repository.CartItemRepository;
import com.ecommerce.be_ecommerce.repository.CartRepository;
import com.ecommerce.be_ecommerce.service.CartItemService;
import com.ecommerce.be_ecommerce.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;
    private UserService userService;
    private CartRepository cartRepository;
    public CartItemServiceImpl(CartItemRepository cartItemRepository, UserService userService, CartRepository cartRepository) {
        this.cartItemRepository = cartItemRepository;
        this.userService = userService;
        this.cartRepository = cartRepository;
    }
    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice() * cartItem.getQuantity());

        CartItem createdCartItem = cartItemRepository.save(cartItem);

        return createdCartItem;
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
        CartItem item = findCartItemById(id);
        User user = userService.findUserById(userId);

        if(user.getId().equals(userId)){
            item.setQuantity(cartItem.getQuantity());

            Product product = item.getProduct();
            if (product != null) {
                item.setPrice(product.getPrice() * item.getQuantity());
                item.setDiscountedPrice(product.getDiscountedPrice() * item.getQuantity());
            } else {
                throw new CartItemException("Product associated with the cart item is null");
            }
        } else {
            throw new UserException("User ID does not match");
        }

        return cartItemRepository.save(item);
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        CartItem cartItem = cartItemRepository.isCartItemExist(cart, product, size, userId);

        return cartItem;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
        CartItem cartItem = findCartItemById(cartItemId);
        User user = userService.findUserById(userId);
        if(user.getId().equals(userId)){
            cartItemRepository.delete(cartItem);
        }
        else {
            throw new UserException("You can't remove another users item");
        }
    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {

        Optional<CartItem> cartItem = cartItemRepository.findById(cartItemId);

        if(cartItem.isPresent()){
            return cartItem.get();
        }
        throw new CartItemException("Cart item not found");

    }
}
