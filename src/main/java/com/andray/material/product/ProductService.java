package com.andray.material.product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct(Long categoryId);
    Product getProductById(Long id) throws Exception;
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id) throws Exception;


}
