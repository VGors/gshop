package com.gorvic.gshop.controllers;

import com.gorvic.gshop.dto.ProductDto;
import com.gorvic.gshop.models.Category;
import com.gorvic.gshop.models.Product;
import com.gorvic.gshop.services.CategoryService;
import com.gorvic.gshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
//    private static final Function<Product, ProductDto>
//            mapEntityToDto = p -> new ProductDto(p.getId(), p.getTitle(), p.getCategory().getTitle(), p.getPrice());

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> p = productService.findById(id);
        if (p.isPresent()) {
            return new ResponseEntity<>(new ProductDto(p.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
