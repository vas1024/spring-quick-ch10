package sq10.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sq10.model.Country;
import java.util.List;

@RestController
public class HelloController {
  @GetMapping("/hello")
  public String hello(){
    return "Hello!";
  }

  @GetMapping("ciao")
  public String ciao(){
    return "Ciao!";
  }

  @GetMapping("/france")
  public ResponseEntity<Country> france(){
    Country c = Country.of("France", 67);

    return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .header("continent","Europe")
            .header("capital","Paris")
            .body(c);

  }

  @GetMapping("/list")
  public List<Country> list(){
    Country c1 = Country.of("France", 67);
    Country c2 = Country.of("Spain", 47);
    return List.of( c1, c2 );
  }
}
