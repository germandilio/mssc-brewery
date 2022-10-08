package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import java.util.UUID;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class BeerServiceImpl implements BeerService {
  private final static Logger log = Logger.getLogger(BeerServiceImpl.class);

  @Override
  public BeerDto getBeerById(UUID beerId) {
    // demonstrative object
    return BeerDto.builder()
        .id(beerId)
        .beerName("Galaxy Cat")
        .beerStyle("Pale Ale")
        .build();
  }

  @Override
  public BeerDto createBeerDto(BeerDto beerDto) {
    return BeerDto.builder()
        .id(UUID.randomUUID())
        .beerName(beerDto.getBeerName())
        .beerStyle(beerDto.getBeerStyle())
        .upc(beerDto.getUpc())
        .build();
  }

  @Override
  public BeerDto updateBeer(UUID id, BeerDto beer) {
    return BeerDto.builder()
        .id(id)
        .beerName(beer.getBeerName())
        .beerStyle(beer.getBeerStyle())
        .upc(beer.getUpc())
        .build();
  }

  @Override
  public void deleteBeer(UUID id) {
    log.debug("Deleted beer with uuid: " + id);
  }
}
