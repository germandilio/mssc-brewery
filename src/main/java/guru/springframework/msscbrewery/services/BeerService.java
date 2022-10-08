package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto createBeerDto(BeerDto beerDto);

    BeerDto updateBeer(UUID id, BeerDto beer);

    void deleteBeer(UUID id);
}
