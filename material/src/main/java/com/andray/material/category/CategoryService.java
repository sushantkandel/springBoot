package com.andray.material.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;


    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }


    public Category getCategoryById(Long id) throws Exception {
        Optional<Category> topic = categoryRepository.findById(id);
        if (topic == null) {
            throw new Exception("Jpt exception");
        }
        return topic.get();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category) {

        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) throws Exception {

        getCategoryById(id);
        categoryRepository.deleteById(id);

    }

}
