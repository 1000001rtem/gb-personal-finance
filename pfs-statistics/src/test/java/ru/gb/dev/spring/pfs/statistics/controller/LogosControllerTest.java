package ru.gb.dev.spring.pfs.statistics.controller;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.gb.dev.spring.pfs.statistics.controller.base.AbstractControllerTest;
import ru.gb.dev.spring.pfs.statistics.model.dto.LogoDTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogosControllerTest extends AbstractControllerTest {

    private final String uri = "/api/logos";
    private LogoDTO testLogo;

    @Before
    @Override
    public void setUp() {
        super.setUp();

        testLogo = new LogoDTO();
        testLogo.setId("test-Logo-Id");
        testLogo.setName("TestLogo");
        testLogo.setExtension("TestLogoExtension");
        testLogo.setPath("TestLogoPath");
    }

    @Test
    public void whenPostLogo_thenLogoCreated() throws Exception {
        // given

        // when
        MvcResult mvcResult = createLogo();
        int status = mvcResult.getResponse().getStatus();
        final String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.CREATED.value(), status);
        assertEquals("Logo is created successfully", content);

        deleteLogo();
    }

    @Test
    public void whenPutLogo_thenLogoUpdated() throws Exception {
        // given
        testLogo.setName("TestLogoUpdated");
        createLogo();

        // when
        String inputJson = super.mapToJson(testLogo);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/" + testLogo.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("Logo is updated successfully", content);

        deleteLogo();
    }

    @Test
    public void whenGetLogos_thenGetLogoList() throws Exception {
        // given
        createLogo();

        // when
        final MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn();
        final int status = mvcResult.getResponse().getStatus();
        final String content = mvcResult.getResponse().getContentAsString();
        final LogoDTO[] logos = super.mapFromJson(content, LogoDTO[].class);

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertTrue(logos.length > 0);

        deleteLogo();
    }

    @Test
    public void whenGetLogo_thenSuccess() throws Exception {
        // given
        createLogo();

        // when
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/" + testLogo.getId())).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        LogoDTO logo = super.mapFromJson(content, LogoDTO.class);

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("wrong result !!", testLogo.getId(), logo.getId());

        deleteLogo();
    }

    @Test
    public void whenDeleteLogo_thenSuccess() throws Exception {
        // given
        createLogo();

        // when
        MvcResult mvcResult = deleteLogo();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("Logo is deleted successfully", content);
    }

    @NotNull
    private MvcResult deleteLogo() throws Exception {
        return mvc.perform(MockMvcRequestBuilders.delete(uri + "/" + testLogo.getId())).andReturn();
    }

    @NotNull
    private MvcResult createLogo() throws Exception {
        String inputJson = super.mapToJson(testLogo);
        return mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(inputJson)).andReturn();
    }

}
