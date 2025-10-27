package com.onelifedev.productservice.services;

import com.onelifedev.productservice.exceptions.ProductNotFoundException;
import com.onelifedev.productservice.models.Category;
import com.onelifedev.productservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    Product createProduct(String title,
                          String description,
                          double price,
                          Category category,
                          String image);

    List<Product> getAllProducts();

    void deleteProduct(Long id);

    Page<Product> getProductsByTitle(String title, int pageNumber, int pageSize);
}
