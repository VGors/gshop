package com.gorvic.gshop.controllers;

import com.gorvic.gshop.dto.ProductDto;
import com.gorvic.gshop.models.Product;
import com.gorvic.gshop.services.CategoryService;
import com.gorvic.gshop.services.ProductService;
import com.gorvic.gshop.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
//    private static final Function<Product, ProductDto>
//            mapEntityToDto = p -> new ProductDto(p.getId(), p.getTitle(), p.getCategory().getTitle(), p.getPrice());

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        Product p = productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found: " + id));
        return new ProductDto(p);
//        return mapEntityToDto.apply(productService.findById(id));
    }


    @GetMapping
    public Page<ProductDto> findAll(@RequestParam(name = "p", defaultValue = "1") int pageIndex) {
        return productService.findPage(pageIndex - 1, 7).map(ProductDto::new);
//        return productService.findPage(pageIndex - 1, 7).map(mapEntityToDto);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto newProductDto) {
        Product product = new Product();
        product.setTitle(newProductDto.getTitle());
        product.setPrice(newProductDto.getPrice());
        product.setCategory(categoryService.findByTitle(newProductDto.getCategoryTitle()));
        return new ProductDto(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
