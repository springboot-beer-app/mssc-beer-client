package com.viv.mssc.service.web.client;

import com.viv.mssc.service.web.model.BeerData;
import com.viv.mssc.service.web.model.BeerStyleEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
@ConfigurationProperties(ignoreUnknownFields = true)
public class MSSCBeerClient {
    /**
     * You need network endpoint:
     * 1. hostpath
     * 2. url
     * 3. port
     */
    private RestTemplate restTemplate;
    @Value("${apihost}")
    private String apihost;
    private final String API_URL = "/api/v1/";

    //Autowired
    public MSSCBeerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost){
        this.apihost  = apihost;
    }

    //TODO : Pass query param
    public List<BeerData> getBeer(String name, BeerStyleEnum style){
        List<BeerData> beer_list = null;
        BeerData [] beers = restTemplate.getForObject(this.apihost + API_URL + "beer", BeerData[].class);
        if(beers != null && beers.length>0){
            beer_list = Arrays.asList(beers);
        }
        return beer_list;
    }

    public BeerData getBeerByID(UUID uuid) {
        BeerData beerData = restTemplate.getForObject(this.apihost + API_URL + "beer/" + uuid, BeerData.class);
        return beerData;
    }

}
