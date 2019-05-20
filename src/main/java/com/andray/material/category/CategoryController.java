package com.andray.material.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * This method is GET mapped with URI /categories and call the method getAllCategory() of CategoryService Class.
     * @return List of categories obtain from method getAllCategory.
     */
    @RequestMapping("/categories")
    public List<Category> getAll() {
        return categoryService.getAllCategory();
    }

    /**
     * This method is GET mapped with the URI /categories/{id} and call the method getCategoryById(id) of CategoryService Class.
     * @param id
     * @return Category Object returned from getCategoryByID(id) method.
     * @throws Exception
     */
    @RequestMapping("/categories/{id}")
    public Category getCategory(@PathVariable Long id) throws Exception {
        return categoryService.getCategoryById(id);
    }

    /**
     * This method is POST mapped with URI /categories and used to add the new Category object.
     * @param category
     */
    //@RequestMapping(method = RequestMethod.POST, value = "/topics")
    @PostMapping("/categories")
    public ResponseEntity<?> add(@RequestBody Category category) {

        Category categorySaved= categoryService.addCategory(category);
        return new ResponseEntity<>(categorySaved, HttpStatus.CREATED);
    }

    /**
     * This method is PUT mapped with URI /categories and used to update the uploaded Category object with new Category object.
     * @param category
     */
    //    @RequestMapping(method = RequestMethod.PUT, value = "/topics")
    @PutMapping("/categories")
    public ResponseEntity<?>  update(@RequestBody Category category) {

        categoryService.updateCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * This method is DELETE mapped with URI /categories/{id} and help to delete the Category object of given id.
     * @param id
     * @throws Exception
     */
    //@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable Long id) throws Exception {
        categoryService.deleteCategory(id);
    }


}