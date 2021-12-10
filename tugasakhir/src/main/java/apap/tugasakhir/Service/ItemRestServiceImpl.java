package apap.tugasakhir.Service;
import apap.tugasakhir.DTO.Item;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemRestServiceImpl implements ItemRestService{
    private WebClient webClient;

    public ItemRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("https://si-item.herokuapp.com").build();
    }

    @Override
    public List <Item> retriveAllItem(){
        JsonNode jsonNode = this.webClient.get().uri("/api/item")
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block().get("result");

        List<Item> listItem = new ArrayList<>();
        for(JsonNode json: jsonNode){
            Item item = new Item();
            item.setUuid(json.get("uuid").asText());
            item.setNama(json.get("nama").asText());
            item.setHarga(json.get("harga").asInt());
            item.setStok(json.get("stok").asInt());
            item.setKategori(json.get("kategori").asText());
            listItem.add(item);
        }

        return listItem;
    }

    @Override
    public ResponseEntity<String> proposeItem(Item item) {
        // TODO Auto-generated method stub
        String url = "https://sibusiness-7.herokuapp.com/api/item/request-item";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> map = new HashMap<>();
        map.put("nama", item.getNama());
        map.put("harga", item.getHarga());
        map.put("stok", item.getStok());
        map.put("kategori", Integer.parseInt(item.getKategori()));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        return response;
    }
}
