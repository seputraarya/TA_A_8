package apap.tugasakhir.Service;

import apap.tugasakhir.DTO.Item;
import apap.tugasakhir.DTO.ProposeItem;
import reactor.core.publisher.Mono;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ItemRestService {

    List<Item> retriveAllItem();

    void proposeItem(ProposeItem item);

    
}
