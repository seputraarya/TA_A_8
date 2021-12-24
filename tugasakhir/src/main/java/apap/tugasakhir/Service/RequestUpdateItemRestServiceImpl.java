package apap.tugasakhir.Service;

import apap.tugasakhir.DTO.Item;
import apap.tugasakhir.Model.RequestUpdateItemModel;
import apap.tugasakhir.Repository.RequestUpdateItemDb;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RequestUpdateItemRestServiceImpl implements RequestUpdateItemRestService {
    private WebClient webClient;

    @Autowired
    RequestUpdateItemDb requestUpdateItemDb;

    @Override
    public RequestUpdateItemModel createRequestUpdateItem(RequestUpdateItemModel requestUpdateItem) {
        requestUpdateItem.setExecuted(false);
        requestUpdateItem.setTanggalRequest(Date.valueOf(LocalDate.now()));
        return requestUpdateItemDb.save(requestUpdateItem);
    }

    public RequestUpdateItemRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("https://si-item.herokuapp.com").build();
    }

    @Override
    public String executeRequestUpdateItem(RequestUpdateItemModel requestUpdateItem) throws JsonProcessingException {
        String uuid = requestUpdateItem.getIdItem();

        JsonNode jsonNode = this.webClient.get().uri("/api/item/" + uuid)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block().get("result");

        int stok = jsonNode.get("stok").asInt();

        String json = "{\"stok\": " + String.valueOf(stok + requestUpdateItem.getTambahanStok().intValue()) + "}";
        String out = this.webClient.put().uri("/api/item/" + uuid)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(json)
                .retrieve()
                .bodyToMono(String.class).block();

        return out;
    }
}
