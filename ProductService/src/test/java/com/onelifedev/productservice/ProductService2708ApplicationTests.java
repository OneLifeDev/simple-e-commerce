package com.onelifedev.productservice;

import com.onelifedev.productservice.repositories.CategoryRepository;
import com.onelifedev.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductService2708ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

//    @Test
//    void contextLoads() {
//    }

//    @Test
//    public void testFetchTypes() {
////        Optional<Product> optionalProduct = productRepository.findById(1L);
//
//        Optional<Category> categoryOptional = categoryRepository.findById(1L);
//
//        //Category category = categoryOptional.get();
//
////        List<Product> products = category.getProducts();
////
////        for (Product product : products) {
////            System.out.println(product.getTitle());
////        }
//
//        System.out.println("DEBUG");
//    }

}
