package apap.tugasakhir.Service;

import apap.tugasakhir.DTO.Item;
import apap.tugasakhir.Model.RequestUpdateItemModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RequestUpdateItemRestService {
    RequestUpdateItemModel createRequestUpdateItem(RequestUpdateItemModel requestUpdateItem);
    String executeRequestUpdateItem(RequestUpdateItemModel requestUpdateItem) throws JsonProcessingException;
}
