package com.gorvic.gshop.utils;

import com.gorvic.gshop.dto.ProductDto;
import com.gorvic.gshop.models.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
public class Cart {
    private List<ProductDto> items;
    private BigDecimal price;

    @PostConstruct
    public void init(){
        this.items = new ArrayList<>();
        this.price = BigDecimal.ZERO;
    }

    public void clear(){
        items.clear();
        recalculate();
    }

    public void add(Product product){
        items.add(new ProductDto(product));
        recalculate();
    }

    private void recalculate(){
        price = BigDecimal.ZERO;
        for (ProductDto p: items){
            price = price.add(p.getPrice());
        }
    }
}
