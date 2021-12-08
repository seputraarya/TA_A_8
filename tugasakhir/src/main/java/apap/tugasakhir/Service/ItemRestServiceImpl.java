package apap.tugasakhir.Service;
import apap.tugasakhir.DTO.Item;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
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
}
