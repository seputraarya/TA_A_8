package apap.tugasakhir.Service;

import apap.tugasakhir.Model.RequestUpdateItemModel;
import apap.tugasakhir.Repository.RequestUpdateItemDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class RequestUpdateItemRestServiceImpl implements RequestUpdateItemRestService {
//    private final WebClient webClient;

    @Autowired
    RequestUpdateItemDb requestUpdateItemDb;

    @Override
    public RequestUpdateItemModel createRequestUpdateItem(RequestUpdateItemModel requestUpdateItem) {
        requestUpdateItem.setExecuted(false);
        return requestUpdateItemDb.save(requestUpdateItem);
    }

}
