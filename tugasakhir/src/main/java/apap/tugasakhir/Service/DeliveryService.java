package apap.tugasakhir.Service;

import apap.tugasakhir.Model.DeliveryModel;
import apap.tugasakhir.Model.PegawaiModel;
import apap.tugasakhir.Model.RequestUpdateItemModel;

import java.util.List;

public interface DeliveryService {
    List<DeliveryModel> getDeliveryList();
    DeliveryModel createDelivery(PegawaiModel pegawai, RequestUpdateItemModel requestUpdateItem);
}
