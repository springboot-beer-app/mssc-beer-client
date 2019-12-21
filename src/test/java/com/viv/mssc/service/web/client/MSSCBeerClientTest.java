package com.viv.mssc.service.web.client;

import com.viv.mssc.service.web.model.BeerData;
import com.viv.mssc.service.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MSSCBeerClientTest {

    @Autowired
    MSSCBeerClient msscBeerClient;

    @Test
    void getBeerById() {
        BeerData beerData = msscBeerClient.getBeerByID(UUID.randomUUID());
        assertNotNull(beerData);
    }
}