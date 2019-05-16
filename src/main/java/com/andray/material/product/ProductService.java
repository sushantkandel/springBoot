package com.andray.material.product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct(Long categoryId);
    public Product getProductById(Long id) throws Exception;
    public void addProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(Long id) throws Exception;

}
