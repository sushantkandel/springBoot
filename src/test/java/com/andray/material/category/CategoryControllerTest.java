package com.andray.material.category;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)

public class CategoryControllerTest {
    /**
     * @TestConfiguration static class CategoryServiceImplTestContextConfiguration {
     * @Bean public CategoryService categoryService() {
     * return new CategoryServiceImpl();
     * }
     * }
     */

    @Autowired
    private MockMvc mvc;
    @MockBean
    private CategoryService categoryService;

    @Test
    public void getAll() throws Exception {
        List<Category> categories = Arrays.asList(new Category((long) 1,
                        "garment", "All these are handmade"),
                new Category((long) 2,
                        "electronics", "All these are made in italy"));
        given(categoryService.getAllCategory()).willReturn(categories);

        mvc.perform(get("/categories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("garment"));

    }

    @Test
    public void getCategory() throws Exception {
        Category category = new Category((long) 1,
                "furniture", "All these are made in italy");
        given(categoryService.getCategoryById(anyLong())).willReturn(category);

        mvc.perform(get("/categories/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("furniture"));

    }


    @Test
    public void add() throws Exception {
        Category category = new Category((long) 1,
                "furniture", "All these are made in italy");
        String categoryJson = "{\"id\":\"1\",\"name\":\"Garment\",\"description\": \"It is made in Italy\" }";

        when(categoryService.addCategory(category)).thenReturn(category);
        MvcResult result = mvc.perform(post("/categories")
                .accept(MediaType.APPLICATION_JSON)
                .content(categoryJson)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }


    @Test
    public void update() throws Exception {
        Category category = new Category((long) 1,
                "furniture", "All these are made in italy");
        String categoryJson = "{\"id\":\"1\",\"name\":\"Garment\",\"description\": \"It is made in Italy\" }";

        when(categoryService.updateCategory(category)).thenReturn(category);
        MvcResult result = mvc.perform(put("/categories")
                .accept(MediaType.APPLICATION_JSON)
                .content(categoryJson)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }

    @Test
    public void deleteCategory() throws Exception {
        Category category = new Category((long) 1,
                "furniture", "All these are made in italy");
        doAnswer((Answer) -> {
            System.out.println("Hello");
            return null;
        }).when(categoryService).deleteCategory(any(long.class));


        mvc.perform(delete("/categories/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(2)))

    }

}