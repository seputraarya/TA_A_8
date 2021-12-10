package apap.tugasakhir.Service;

import apap.tugasakhir.Model.RequestUpdateItemModel;

import java.util.List;

public interface RequestUpdateItemService {
    List<RequestUpdateItemModel> getRequestUpdateItemList();
    RequestUpdateItemModel findByIdRequestUpdateItem(Long idRequestUpdateItem);
    void updateRequestUpdateItem(RequestUpdateItemModel requestUpdateItem);
}
