package ru.gb.dev.spring.pfs.statistics.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.dev.spring.pfs.statistics.controller.dto.SuccessDTO;
import ru.gb.dev.spring.pfs.statistics.model.dto.ClientDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Client;
import ru.gb.dev.spring.pfs.statistics.model.service.ClientService;

import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

    private final ClientService service;

    private final ModelMapper modelMapper;

    @Autowired
    public ClientsController(ClientService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/ping")
    public ResponseEntity<Object> ping() {
        return new ResponseEntity<>(new SuccessDTO(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Object> getClient(@PathVariable("id") String id) {
        return new ResponseEntity<>(
                service.findById(id)
                        .map(client -> modelMapper.map(client, ClientDTO.class))
                        .orElseGet(ClientDTO::new),
                HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<Object> getAllClient() {
        return new ResponseEntity<>(
                StreamSupport.stream(service.findAll().spliterator(), false)
                        .map(client -> modelMapper.map(client, ClientDTO.class))
                        .toArray(),
                HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createClient(@RequestBody ClientDTO clientDto) {
        service.save(clientDto);
        return new ResponseEntity<>("Client is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateClient(@PathVariable("id") String id, @RequestBody ClientDTO clientDto) {
        Optional<Client> optional = service.findById(id);
        if (!optional.isPresent()) return new ResponseEntity<>("Client is not found", HttpStatus.NOT_FOUND);
        Client client = optional.get();
        clientDto.setId(id);
        clientDto.setCreated(client.getCreated());
        clientDto.setUpdated(client.getUpdated());
        service.save(clientDto);
        return new ResponseEntity<>("Client is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteClient(@PathVariable("id") String clientId) {
        service.deleteById(clientId);
        return new ResponseEntity<>("Client is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAllClient() {
        service.deleteAll();
        return new ResponseEntity<>("Clients are deleted successfully", HttpStatus.OK);
    }

}
