package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyle;
import java.util.UUID;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
  private final static Logger log = Logger.getLogger(BeerServiceV2Impl.class);

  @Override
  public BeerDtoV2 getBeerById(UUID beerId) {
    // demonstrative object
    return BeerDtoV2.builder()
        .id(beerId)
        .beerName("Galaxy Cat")
        .beerStyle(BeerStyle.GOSE)
        .build();
  }

  @Override
  public BeerDtoV2 createBeerDto(BeerDtoV2 beerDto) {
    return BeerDtoV2.builder()
        .id(UUID.randomUUID())
        .beerName(beerDto.getBeerName())
        .beerStyle(beerDto.getBeerStyle())
        .upc(beerDto.getUpc())
        .build();
  }

  @Override
  public BeerDtoV2 updateBeer(UUID id, BeerDtoV2 beer) {
    return BeerDtoV2.builder()
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
