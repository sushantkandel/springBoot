package com.andray.materialAnalyzer.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
   @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct(Long categoryId) {
        List<Product> products = new ArrayList<>();
        productRepository.findByCategoryId(categoryId).forEach(products::add);
        return products;
    }

    public Product getProductById(Long id) throws Exception {
        Optional<Product> topic = productRepository.findById(id);
        if (topic == null) {
            throw new Exception("Jpt exception");
        }
        return topic.get();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product) {

        productRepository.save(product);
    }

    public void deleteProduct(Long id) throws Exception {

        getProductById(id);
        productRepository.deleteById(id);

    }

}

