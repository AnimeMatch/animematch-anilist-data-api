package teste.piProject.util;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DefaultMetods {
//   public static <K, V> Map<K, V> request(Map<String, String> corpo){
//        String url = "https://graphql.anilist.co";
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Map<K, V>> response = restTemplate.exchange(
//                url,
//                HttpMethod.POST,
//                new HttpEntity<>(corpo),
//                new ParameterizedTypeReference<Map<K, V>>() {}
//        );
//        return response.getBody();
//   }

   public static Map<String, String> query(String body){
       Map<String, String> request = new HashMap<>();
       request.put("query", body);
       return request;
   }

    public static <T> T postRequestByClass(Map<String, String> corpo, Class<T> responseType, String urlReceived){
        String url = urlReceived;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<T> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(corpo),
                responseType
//                new ParameterizedTypeReference<AnimeQuery>() {}
        );
        return response.getBody();
    }

    public static <T> T postRequestByClass(Map<String, String> corpo, Class<T> responseType){
        final String url = "https://graphql.anilist.co";
        final RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<T> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(corpo),
                responseType
        );
        return response.getBody();
    }

    public static <T> T getRequestByClass(Class<T> responseType, String url){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
                url,
                responseType);
    }

    public static <T> T getRequestByClass(Class<T> responseType, String url, Object param){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
                url,
                responseType,
                param
        );
    }
}
