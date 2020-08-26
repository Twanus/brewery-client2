package com.antoonvereecken.breweryclient.web.client;

import com.antoonvereecken.breweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto b = client.getBeerById(UUID.randomUUID());

        assertNotNull(b);
    }

    @Test
    void testSaveNewBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        URI uri = client.saveNewBeer(beerDto);

        System.out.println(uri.toString());
        assertNotNull(uri);
    }

    @Test
    void testUpdateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New BEEEER").build();

        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer(){
         client.deleteBeer(UUID.randomUUID());
    }
}