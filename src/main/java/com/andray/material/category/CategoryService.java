package com.andray.material.category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    Category getCategoryById(Long id) throws Exception;
    Category addCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long id) throws Exception;


}
