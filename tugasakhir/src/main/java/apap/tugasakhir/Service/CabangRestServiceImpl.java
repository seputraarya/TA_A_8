package apap.tugasakhir.Service;

import apap.tugasakhir.DTO.Cabang;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CabangRestServiceImpl implements CabangRestService{
    private WebClient webClientCabang;
    public CabangRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientCabang = webClientBuilder.baseUrl("https://si-retail-a03.herokuapp.com/").build();
    }

    @Override
    public List<Cabang> retrieveAllcabang() {
        JsonNode jsonNode = this.webClientCabang.get().uri("/api/cabang/list-cabang")
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();

        List<Cabang> listCabang = new ArrayList<>();
        for (JsonNode json : jsonNode) {
            Cabang cabang = new Cabang();
            cabang.setId(json.get("id").asText());
            cabang.setAlamat(json.get("alamat").asText());
            listCabang.add(cabang);
        }
        return listCabang;
    }
}
