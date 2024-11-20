package com.example.demo.CatFact;

import com.example.demo.CatFactEntity.CatFactEntity;
import com.example.demo.CatFactEntity.CatFactRepository;
import com.example.demo.Exceptions.ExternalCatFactsDownException;
import com.example.demo.Exceptions.SimpleResponse;
import com.example.demo.Query;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatFactQueryHandler implements Query<Void,CatFactDTO> {
    private final RestTemplate restTemplate;
    private final CatFactRepository catFactRepository;

    public CatFactQueryHandler(RestTemplate restTemplate,CatFactRepository catFactRepository){
        this.restTemplate = restTemplate;
        this.catFactRepository = catFactRepository;
    }

    private CatFact getCatFact(){
        try {
            String CAT_FACT_URL = "https://catfact.ninja/fact";
            CatFact catFact = restTemplate.getForObject(CAT_FACT_URL, CatFact.class);
            // save a copy to database
            catFactRepository.save(new CatFactEntity(catFact));
            return catFact;
        }catch (Exception exception){
            throw new ExternalCatFactsDownException(
                    HttpStatus.SERVICE_UNAVAILABLE,
                    new SimpleResponse("The external API is down. Not our fault"
                    ));
        }
    }

    @Override
    public ResponseEntity<CatFactDTO> execute(Void input) {
        CatFact catFact = getCatFact();
        CatFactDTO catFactDTO = new CatFactDTO(catFact.getFact());
        return ResponseEntity.ok(catFactDTO);
    }
}
