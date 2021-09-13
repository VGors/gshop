package com.gorvic.gshop.controllers;

import com.gorvic.gshop.dto.ProductDto;
import com.gorvic.gshop.exceptions.ResourceNotFoundException;
import com.gorvic.gshop.models.Product;
import com.gorvic.gshop.services.ProductService;
import com.gorvic.gshop.utils.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final Cart cart;
    private final ProductService productService;

    @GetMapping
    public Cart getCart() {
        return cart;
    }

    @GetMapping("/add/{id}")
    public void add(@PathVariable Long id) {
        Product p = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to add product to cart - not found, id: " + id));
        cart.add(p);
    }
}
