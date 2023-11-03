package teste.piProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import teste.piProject.domain.Personagem;

import java.util.Map;

@RestController
public class CharacterController {

    public static final String url =  "https://graphql.anilist.co";
    @Autowired
    RestTemplate restTemplate;
    @PostMapping("/getId")
    public ResponseEntity<Integer> getID(@RequestBody Map<String,String> s){
        var request = restTemplate.postForEntity(url,s, Map.class);
        var response = (Map<String, Map<String,Map<String,Map<String,String>>>>)request.getBody().get("data");

        String a = String.valueOf(response.get("Character").get("id"));
        Integer id = Integer.parseInt(a);
        return ResponseEntity.ok().body(id);
    }

    @PostMapping("/getName")
    public ResponseEntity<String> getName(@RequestBody Map<String,String> s){
        var request = restTemplate.postForEntity(url,s, Map.class);
        var response = (Map<String, Map<String,Map<String,Map<String,String>>>>)request.getBody().get("data");

        String name = String.valueOf(response.get("Character").get("name").get("full"));

        return ResponseEntity.ok().body(name);
    }

    @PostMapping("/getCharacter")
    public ResponseEntity<Personagem> getCharacter(@RequestBody Map<String,String> s){
        var request = restTemplate.postForEntity(url,s, Map.class);
        var response = (Map<String, Map<String,Map<String,Map<String,String>>>>)request.getBody().get("data");

        String idString = String.valueOf(response.get("Character").get("id"));

        int id = Integer.parseInt(idString);
        String fullName = String.valueOf(response.get("Character").get("name").get("full"));
        String imgLarge = String.valueOf(response.get("Character").get("image").get("large"));
        String imgMedium = String.valueOf(response.get("Character").get("image").get("medium"));
        String description = String.valueOf(response.get("Character").get("description"));
        String gender = String.valueOf(response.get("Character").get("gender"));
        String age = String.valueOf(response.get("Character").get("age"));


        return ResponseEntity.ok().body(new Personagem(id,fullName,imgLarge,imgMedium,description,gender,age,null));
    }
}
