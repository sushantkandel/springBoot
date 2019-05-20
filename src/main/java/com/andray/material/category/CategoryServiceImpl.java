package com.andray.material.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    /**
     * This method is used to get all the categories from the database and return the result in the form of list by calling the method find all
     * of the JPA repository which is extended by the interface Category Repository.
     *
     * @return list of category through categories list
     */
    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    /**
     * This method is used to return the category according to the mentioned id in @param which return category through the method findBYId
     * of Jpa repository extended by the CategoryRepository.
     *
     * @param id
     * @return Category
     * @throws Exception
     */
    public Category getCategoryById(Long id) throws Exception {
        Optional<Category> category = categoryRepository.findById(id);
        if (category == null) {
            throw new Exception("Jpt exception");
        }
        return category.get();
    }

    /**
     * This method is used to save the @param category by calling save methof of jpa repository.
     *
     * @param category
     */
    public Category addCategory(Category category) {
        return categoryRepository.save(category);

    }

    /**
     * This is used to update the existing category by new category.
     *
     * @param category
     */
    public Category updateCategory(Category category) {
         return categoryRepository.save(category);


    }

    /**
     * This method is used to delete the category with the help of id.At first, we examine weather the mentioned category is present in database or not
     * by executing the method getCategoryById ,in the case of absence then the method throw the exception otherwise the next deletion method is operated.
     *
     * @param id
     * @throws Exception
     */
    public void deleteCategory(Long id) throws Exception {

        getCategoryById(id);
        categoryRepository.deleteById(id);


    }

}
