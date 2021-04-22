package com.example.restapimongodb.services;


import com.example.restapimongodb.models.Product;
import com.example.restapimongodb.models.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{

        @Autowired
        private ProductRepository productRepository;

        public List<Product> getProducts()
        {
                //business logic
            return productRepository.findAll();

        }

        public void insertIntoProducts(Product product)
        {

                productRepository.insert(product);
        }

        public Optional<Product> getAProduct(String id)
        {
                return productRepository.findById(id);
        }

        public void deleteAProduct(String id)
        {
                productRepository.deleteById(id);
        }
}
