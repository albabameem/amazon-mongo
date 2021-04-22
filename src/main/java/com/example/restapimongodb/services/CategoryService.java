package com.example.restapimongodb.services;


import com.example.restapimongodb.models.CategoryRepository;
import com.example.restapimongodb.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService
{

        @Autowired
        private CategoryRepository categoryRepository;

        public List<Category> getCategories()
        {
                //business logic
            return categoryRepository.findAll();

        }

        public void insertIntoCategories(Category category)
        {

                categoryRepository.insert(category);
        }

        public Optional<Category> getACategory(String id)
        {
                return categoryRepository.findById(id);
        }

        public void deleteACategory(String id)
        {
                categoryRepository.deleteById(id);
        }
}
