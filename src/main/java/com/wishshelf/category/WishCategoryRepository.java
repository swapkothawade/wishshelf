package com.wishshelf.category;

import com.wishshelf.category.WishCategory;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishCategoryRepository extends MongoRepository<WishCategory, String>{

	public List<WishCategory> findAll();
 
}
