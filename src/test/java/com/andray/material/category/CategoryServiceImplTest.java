package com.andray.material.category;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class CategoryServiceImplTest {

    @TestConfiguration
    static class CategoryServiceImplTestContextConfiguration {

        @Bean
        public CategoryService categoryService() {
            return new CategoryServiceImpl();
        }
    }

    @Autowired
    private CategoryService categoryService;

    @MockBean
    CategoryRepository categoryRepository;

    @Before
    public void setUp() {
        Category electronics = new Category((long) 1, "electronics", "it is electronics device");
        when(categoryRepository.findById((long) 1))
                .thenReturn(Optional.of(electronics));

    }


    @Test
    public void getCategoryBYIdTest() throws Exception {
        String name = "electronics";

        Category category = categoryService.getCategoryById((long) 1);

        Assert.assertEquals(category.getName(), name);

    }

    @Test
    public void addCategoryTest() {
        Category category = new Category((long) 2,
                "furniture", "All these are wood furniture");
        when(categoryRepository.save(category)).thenReturn(category);
        Assert.assertEquals(category, categoryService.addCategory(category));
    }

    @Test
    public void updateCategoryTest() {
        Category category = new Category((long) 2,
                "garment", "All these are handmade");
        when(categoryRepository.save(category)).thenReturn(category);
        Assert.assertEquals(category, categoryService.updateCategory(category));
    }

    @Test
    public void deleteCategoryTest() throws Exception {
        doAnswer((Answer) -> {
            System.out.println("Hello");
            return null;
        }).when(categoryRepository).deleteById(any(long.class));
        categoryService.deleteCategory((long) 1);

    }

    @Test
    public void getAllCategoryTest() {

        List<Category> list = Arrays.asList(new Category((long) 1,
                        "garment", "All these are handmade"),
                new Category((long) 2,
                        "electronics", "All these are made in italy")
        );
        when(categoryRepository.findAll()).thenReturn(list);
        Assert.assertEquals(list, categoryService.getAllCategory());
    }
}






