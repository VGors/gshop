package com.gorvic.gshop.utils;

import com.gorvic.gshop.dto.OrderItemDto;
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
    private List<OrderItemDto> items;
    private BigDecimal price;

    @PostConstruct
    public void init() {
        this.items = new ArrayList<>();
        this.price = BigDecimal.ZERO;
    }

    public void clear() {
        items.clear();
        recalculate();
    }

    public void add(Product product) {
        for (OrderItemDto o : items) {
            if (o.getId().equals(product.getId())) {
                o.changeQuantity(1);
                recalculate();
                return;
            }
        }
        items.add(new OrderItemDto(product));
        recalculate();
    }

    private void recalculate() {
        price = BigDecimal.ZERO;
        for (OrderItemDto orderItemDto : items) {
            price = price.add(orderItemDto.getPrice());
        }
    }
}
