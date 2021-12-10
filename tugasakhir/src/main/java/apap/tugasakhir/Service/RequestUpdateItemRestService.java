package apap.tugasakhir.Service;

import apap.tugasakhir.DTO.Item;
import apap.tugasakhir.Model.RequestUpdateItemModel;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RequestUpdateItemRestService {
    RequestUpdateItemModel createRequestUpdateItem(RequestUpdateItemModel requestUpdateItem);
    Mono<Item> executeRequestUpdateItem(RequestUpdateItemModel requestUpdateItem);
}
