package com.andray.material.category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategory();
    public Category getCategoryById(Long id) throws Exception;
    public void addCategory(Category category);
    public void updateCategory(Category category);
    public void deleteCategory(Long id) throws Exception;

}
