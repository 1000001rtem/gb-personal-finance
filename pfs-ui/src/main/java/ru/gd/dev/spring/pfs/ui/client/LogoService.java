package ru.gd.dev.spring.pfs.ui.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gd.dev.spring.pfs.ui.controller.dto.ResultDto;
import ru.gd.dev.spring.pfs.ui.dto.LogoDto;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping("/api/logos")
@FeignClient(name = "statistics")
public interface LogoService {

    @GetMapping(value = "/ping", produces = APPLICATION_JSON_UTF8_VALUE)
    ResultDto ping();

    @GetMapping(value = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    LogoDto get(@PathVariable("id") final String id);

    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    List<LogoDto> getAll();

    @PostMapping(
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    ResultDto post(final LogoDto logoDto);

    @PutMapping(
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    ResultDto put(final LogoDto logoDto);

    @DeleteMapping(
            value = "{id}",
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    ResultDto delete(@PathVariable("id") final String logoId);

    @DeleteMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    ResultDto deleteAll();

}
