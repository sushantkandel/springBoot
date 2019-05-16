package com.andray.material.product;

import com.andray.material.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * This method is GET mapped with URI /categories/{id}/products and call the method getAllProduct() of ProductService Class.
     * @param id
     * @return list of product
     */
    @RequestMapping("/categories/{id}/products")
    public List<Product> getAll(@PathVariable Long id) {
        return productService.getAllProduct(id);
    }

    /**
     * This method is GET mapped with URI /categories/{id}/products/{id} and call the method getAllProductById(id) of ProductService Class.
     * @param id
     * @return product
     * @throws Exception
     */
    @RequestMapping("/categories/{categoryId}/products/{id}")
    public Product getProduct(@PathVariable Long id) throws Exception {
        return productService.getProductById(id);
    }

    /**
     * This method is POST mapped with URI /categories/{categoryId}/products and use to add the new product in the  given categoryID.
     * @param product
     * @param categoryId
     */
    //@RequestMapping(method = RequestMethod.POST, value = "/topics")
    @PostMapping("/categories/{categoryId}/products")
    public void add(@RequestBody Product product,@PathVariable Long categoryId) {
        product.setCategory(new Category(categoryId,"",""));
        productService.addProduct(product);
    }

    /**
     * This method is PUT mapped with URI /categories/{categoryId}/products and used to update the uploaded product object with new product
     * object of mentioned categoryId.
     * @param product
     * @param categoryId
     */

    //    @RequestMapping(method = RequestMethod.PUT, value = "/topics")
    @PutMapping("/categories/{categoryId}/products")
    public void update(@RequestBody Product product,@PathVariable Long categoryId) {
        product.setCategory(new Category(categoryId,"",""));
        productService.updateProduct(product);
    }

    /**
     * This method is DELETE mapped with URI /categories/{id}/products/{id} and help to delete the product object from
     * the mentioned categoryId.
     * @param id
     * @throws Exception
     */
    //@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    @DeleteMapping("/categories/{categoryId}/products/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        productService.deleteProduct(id);
    }

}
