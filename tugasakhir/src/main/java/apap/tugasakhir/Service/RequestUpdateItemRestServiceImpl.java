package apap.tugasakhir.Service;

import apap.tugasakhir.DTO.Item;
import apap.tugasakhir.Model.RequestUpdateItemModel;
import apap.tugasakhir.Repository.RequestUpdateItemDb;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class RequestUpdateItemRestServiceImpl implements RequestUpdateItemRestService {
    private WebClient webClient;

    @Autowired
    RequestUpdateItemDb requestUpdateItemDb;

    @Override
    public RequestUpdateItemModel createRequestUpdateItem(RequestUpdateItemModel requestUpdateItem) {
        requestUpdateItem.setExecuted(false);
        return requestUpdateItemDb.save(requestUpdateItem);
    }

    public RequestUpdateItemRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("https://si-item.herokuapp.com").build();
    }

    @Override
    public Mono<Item> executeRequestUpdateItem(RequestUpdateItemModel requestUpdateItem) {
        String uuid = requestUpdateItem.getIdItem();
        Item item = new Item();
        item.setUuid(uuid);
        item.setStok(requestUpdateItem.getTambahanStok().intValue());

        return this.webClient.put().uri("/api/item/" + uuid)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(item)
                .retrieve()
                .bodyToMono(Item.class);
    }
}
