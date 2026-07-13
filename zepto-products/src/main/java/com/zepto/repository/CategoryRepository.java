package com.zepto.repository;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zepto.entity.CategoryEntity;
import com.zepto.entity.ProductEntity;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
	// for basic operation keep it empty

	 public CategoryEntity findByCategory(String input);
	 
	 @Query("select c FROM CategoryEntity c JOIN FETCH c. product")
	 public List<CategoryEntity> findAllCategories();
	 // hibernate will automatic write query
}
