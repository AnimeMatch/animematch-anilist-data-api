package teste.piProject.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import teste.piProject.service.anime.AnimeMedia;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Defaults {
   public static <K, V> Map<K, V> request(Map<String, String> corpo){
        String url = "https://graphql.anilist.co";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map<K, V>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(corpo),
                new ParameterizedTypeReference<Map<K, V>>() {}
        );
        return response.getBody();
   }

   public static Map<String, String> query(String body){
       Map<String, String> request = new HashMap<>();
       request.put("query", body);
       return request;
   }
}
