package com.viv.mssc.service.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerData {
    private  String beerName;
    private BeerStyleEnum beerStyleEnum;
    private String upc;
    private Integer quantityOnHand;
    private Float price;
    private UUID id;
    private Integer version;
    private OffsetDateTime creationDate;
    private OffsetDateTime lastModifiedDate;
}
