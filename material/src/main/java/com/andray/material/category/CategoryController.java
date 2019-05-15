package com.andray.material.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categories")
    public List<Category> getAll() {
        return categoryService.getAllCategory();
    }

    @RequestMapping("/categories/{id}")
    public Category getCategory(@PathVariable Long id) throws Exception {
        return categoryService.getCategoryById(id);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/topics")
    @PostMapping("/categories")
    public void add(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    //    @RequestMapping(method = RequestMethod.PUT, value = "/topics")
    @PutMapping("/categories")
    public void update(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    //@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        categoryService.deleteCategory(id);
    }


}