package ru.gb.dev.spring.pfs.statistics.controller;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.gb.dev.spring.pfs.statistics.controller.base.AbstractControllerTest;
import ru.gb.dev.spring.pfs.statistics.model.dto.CategoryDTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CategoriesControllerTest extends AbstractControllerTest {

    private final String uri = "/api/categories";
    private CategoryDTO testCategory;

    @Before
    @Override
    public void setUp() {
        super.setUp();

        testCategory = new CategoryDTO();
        testCategory.setId("test-Category-Id");
        testCategory.setName("TestCategory");
        testCategory.setActive(true);
    }

    @Test
    public void whenPostCategory_thenCategoryCreated() throws Exception {
        // given

        // when
        MvcResult mvcResult = createCategory();
        int status = mvcResult.getResponse().getStatus();
        final String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.CREATED.value(), status);
        assertEquals("Category is created successfully", content);

        deleteCategory();
    }

    @Test
    public void whenPutCategory_thenCategoryUpdated() throws Exception {
        // given
        testCategory.setName("TestCategoryUpdated");
        createCategory();

        // when
        String inputJson = super.mapToJson(testCategory);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/" + testCategory.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("Category is updated successfully", content);

        deleteCategory();
    }

    @Test
    public void whenGetCategories_thenGetCategoryList() throws Exception {
        // given
        createCategory();

        // when
        final MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn();
        final int status = mvcResult.getResponse().getStatus();
        final String content = mvcResult.getResponse().getContentAsString();
        final CategoryDTO[] categories = super.mapFromJson(content, CategoryDTO[].class);

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertTrue(categories.length > 0);

        deleteCategory();
    }

    @Test
    public void whenGetCategory_thenSuccess() throws Exception {
        // given
        createCategory();

        // when
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/" + testCategory.getId())).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        CategoryDTO category = super.mapFromJson(content, CategoryDTO.class);

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("wrong result !!", testCategory.getId(), category.getId());

        deleteCategory();
    }

    @Test
    public void whenDeleteCategory_thenSuccess() throws Exception {
        // given
        createCategory();

        // when
        MvcResult mvcResult = deleteCategory();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("Category is deleted successfully", content);
    }

    @NotNull
    private MvcResult deleteCategory() throws Exception {
        return mvc.perform(MockMvcRequestBuilders.delete(uri + "/" + testCategory.getId())).andReturn();
    }

    @NotNull
    private MvcResult createCategory() throws Exception {
        String inputJson = super.mapToJson(testCategory);
        return mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(inputJson)).andReturn();
    }

}
