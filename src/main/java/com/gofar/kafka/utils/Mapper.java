package com.gofar.kafka.utils;

import com.gofar.kafka.dto.ClientDto;
import com.gofar.kafka.dto.ProductDto;
import com.gofar.kafka.producer.model.Client;
import com.gofar.kafka.producer.model.Product;

public class Mapper {

    public static Product productDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setAmount(productDto.getAmount());
        product.setName(productDto.getName());
        product.setQuantity(productDto.getQuantity());
        product.setReference(productDto.getReference());
        return product;
    }

    public static ProductDto productToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setAmount(product.getAmount());
        productDto.setName(product.getName());
        productDto.setQuantity(product.getQuantity());
        productDto.setReference(product.getReference());
        return productDto;
    }

    public static Client clientDtoToClient(ClientDto clientDto) {
        Client client = new Client();
        client.setCin(clientDto.getCin());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setDateOfBirth(clientDto.getDateOfBirth());
        return client;
    }

    public static ClientDto clientToClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setCin(client.getCin());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setDateOfBirth(client.getDateOfBirth());
        return clientDto;
    }
}
