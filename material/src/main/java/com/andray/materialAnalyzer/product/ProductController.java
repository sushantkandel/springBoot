package com.andray.materialAnalyzer.product;

import com.andray.materialAnalyzer.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/categories/{id}/products")
    public List<Product> getAll(@PathVariable Long id) {
        return productService.getAllProduct(id);
    }

    @RequestMapping("/categories/{categoryId}/products/{id}")
    public Product getProduct(@PathVariable Long id) throws Exception {
        return productService.getProductById(id);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/topics")
    @PostMapping("/categories/{categoryId}/products")
    public void add(@RequestBody Product product,@PathVariable Long categoryId) {
        product.setCategory(new Category(categoryId,"",""));
        productService.addProduct(product);
    }

    //    @RequestMapping(method = RequestMethod.PUT, value = "/topics")
    @PutMapping("/categories/{categoryId}/products")
    public void update(@RequestBody Product product,@PathVariable Long categoryId) {
        product.setCategory(new Category(categoryId,"",""));
        productService.updateProduct(product);
    }

    //@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    @DeleteMapping("/categories/{categoryId}/products/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        productService.deleteProduct(id);
    }

}
