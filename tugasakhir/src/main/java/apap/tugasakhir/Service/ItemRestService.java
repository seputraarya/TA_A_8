package apap.tugasakhir.Service;

import apap.tugasakhir.DTO.Item;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ItemRestService {

    List<Item> retriveAllItem();
    ResponseEntity<String> proposeItem(Item item);
}
