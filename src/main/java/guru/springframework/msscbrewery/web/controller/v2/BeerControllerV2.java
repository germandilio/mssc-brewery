package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
  private final BeerServiceV2 beerService;

  @Autowired
  public BeerControllerV2(BeerServiceV2 beerService) {
    this.beerService = beerService;
  }

  @GetMapping("/{pathId}")
  public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("pathId") UUID id) {
    return new ResponseEntity<>(beerService.getBeerById(id), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<HttpHeaders> createBeer(@RequestBody BeerDtoV2 beer) {
    var beerDto = beerService.createBeerDto(beer);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", "/api/v1/beer/" + beerDto.getId().toString());

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity<Void> handleUpdate(@PathVariable("beerId") UUID id, @RequestBody BeerDtoV2 beerDto) {
    beerService.updateBeer(id, beerDto);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void handleDelete(@PathVariable("beerId") UUID id) {
    beerService.deleteBeer(id);
  }
}