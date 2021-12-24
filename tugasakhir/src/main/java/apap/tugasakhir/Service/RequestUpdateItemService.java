package apap.tugasakhir.Service;

import apap.tugasakhir.Model.DeliveryModel;
import apap.tugasakhir.Model.ProduksiModel;
import apap.tugasakhir.Model.RequestUpdateItemModel;

import java.util.List;

public interface RequestUpdateItemService {
    List<RequestUpdateItemModel> getRequestUpdateItemList();
    RequestUpdateItemModel findByIdRequestUpdateItem(Long idRequestUpdateItem);
    void updateRequestUpdateItem(RequestUpdateItemModel requestUpdateItem, ProduksiModel produksi);
    void updateDelivery(RequestUpdateItemModel requestUpdateItem, DeliveryModel delivery);
}
