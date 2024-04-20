package com.gofar.kafka.producer.controller;

import com.gofar.kafka.dto.ClientDto;
import com.gofar.kafka.producer.ProducerService;
import com.gofar.kafka.producer.model.Client;
import com.gofar.kafka.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ProducerService producerService;

    @PostMapping
    public ResponseEntity<String> saveClient(@RequestBody ClientDto clientDto) {
        producerService.publishClientData(Mapper.clientDtoToClient(clientDto));
        return ResponseEntity.ok("Client saved successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable("id") Long id, @RequestBody ClientDto clientDto) {
        Client client = Mapper.clientDtoToClient(clientDto);
        producerService.publishClientData(client);
        return ResponseEntity.ok("Client updated successfully");
    }

}
