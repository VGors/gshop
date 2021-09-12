package com.gorvic.gshop.repositories;

import com.gorvic.gshop.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
