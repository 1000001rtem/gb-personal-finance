package ru.gb.dev.spring.pfs.statistics.controller;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.gb.dev.spring.pfs.statistics.controller.base.AbstractControllerTest;
import ru.gb.dev.spring.pfs.statistics.model.dto.ClientDTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClientsControllerTest extends AbstractControllerTest {

    private final String uri = "/api/clients";
    private ClientDTO testClient;

    @Before
    @Override
    public void setUp() {
        super.setUp();

        testClient = new ClientDTO();
        testClient.setId("test-Client-Id");
        testClient.setName("TestClient");
        testClient.setActive(true);
    }

    @Test
    public void whenPostClient_thenClientCreated() throws Exception {
        // given

        // when
        MvcResult mvcResult = createClient();
        int status = mvcResult.getResponse().getStatus();
        final String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.CREATED.value(), status);
        assertEquals("Client is created successfully", content);

        deleteClient();
    }

    @Test
    public void whenPutClient_thenClientUpdated() throws Exception {
        // given
        testClient.setName("TestClientUpdated");
        createClient();

        // when
        String inputJson = super.mapToJson(testClient);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/" + testClient.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("Client is updated successfully", content);

        deleteClient();
    }

    @Test
    public void whenGetClients_thenGetClientList() throws Exception {
        // given
        createClient();

        // when
        final MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn();
        final int status = mvcResult.getResponse().getStatus();
        final String content = mvcResult.getResponse().getContentAsString();
        final ClientDTO[] clients = super.mapFromJson(content, ClientDTO[].class);

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertTrue(clients.length > 0);

        deleteClient();
    }

    @Test
    public void whenGetClient_thenSuccess() throws Exception {
        // given
        createClient();

        // when
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/" + testClient.getId())).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        ClientDTO client = super.mapFromJson(content, ClientDTO.class);

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("wrong result !!", testClient.getId(), client.getId());

        deleteClient();
    }

    @Test
    public void whenDeleteClient_thenSuccess() throws Exception {
        // given
        createClient();

        // when
        MvcResult mvcResult = deleteClient();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("Client is deleted successfully", content);
    }

    @NotNull
    private MvcResult deleteClient() throws Exception {
        return mvc.perform(MockMvcRequestBuilders.delete(uri + "/" + testClient.getId())).andReturn();
    }

    @NotNull
    private MvcResult createClient() throws Exception {
        String inputJson = super.mapToJson(testClient);
        return mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(inputJson)).andReturn();
    }

}
