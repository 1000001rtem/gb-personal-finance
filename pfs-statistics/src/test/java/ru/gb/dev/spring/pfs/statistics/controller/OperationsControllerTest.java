package ru.gb.dev.spring.pfs.statistics.controller;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.gb.dev.spring.pfs.statistics.controller.base.AbstractControllerTest;
import ru.gb.dev.spring.pfs.statistics.model.dto.OperationDTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OperationsControllerTest extends AbstractControllerTest {

    private final String uri = "/api/operations";
    private OperationDTO testOperation;

    @Before
    @Override
    public void setUp() {
        super.setUp();

        testOperation = new OperationDTO();
        testOperation.setId("test-Operation-Id");
        testOperation.setAmount("10");
    }

    @Test
    public void whenPostOperation_thenOperationCreated() throws Exception {
        // given

        // when
        MvcResult mvcResult = createOperation();
        int status = mvcResult.getResponse().getStatus();
        final String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.CREATED.value(), status);
        assertEquals("Operation is created successfully", content);

        deleteOperation();
    }

    @Test
    public void whenPutOperation_thenOperationUpdated() throws Exception {
        // given
        testOperation.setAmount("20");
        createOperation();

        // when
        String inputJson = super.mapToJson(testOperation);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/" + testOperation.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("Operation is updated successfully", content);

        deleteOperation();
    }

    @Test
    public void whenGetOperations_thenGetOperationList() throws Exception {
        // given
        createOperation();

        // when
        final MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn();
        final int status = mvcResult.getResponse().getStatus();
        final String content = mvcResult.getResponse().getContentAsString();
        final OperationDTO[] operations = super.mapFromJson(content, OperationDTO[].class);

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertTrue(operations.length > 0);

        deleteOperation();
    }

    @Test
    public void whenGetOperation_thenSuccess() throws Exception {
        // given
        createOperation();

        // when
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/" + testOperation.getId())).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        OperationDTO operation = super.mapFromJson(content, OperationDTO.class);

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("wrong result !!", testOperation.getId(), operation.getId());

        deleteOperation();
    }

    @Test
    public void whenDeleteOperation_thenSuccess() throws Exception {
        // given
        createOperation();

        // when
        MvcResult mvcResult = deleteOperation();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("Operation is deleted successfully", content);
    }

    @NotNull
    private MvcResult deleteOperation() throws Exception {
        return mvc.perform(MockMvcRequestBuilders.delete(uri + "/" + testOperation.getId())).andReturn();
    }

    @NotNull
    private MvcResult createOperation() throws Exception {
        String inputJson = super.mapToJson(testOperation);
        return mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(inputJson)).andReturn();
    }

}
