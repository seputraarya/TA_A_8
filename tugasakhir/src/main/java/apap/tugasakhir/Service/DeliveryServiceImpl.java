package apap.tugasakhir.Service;

import apap.tugasakhir.Model.DeliveryModel;
import apap.tugasakhir.Model.PegawaiModel;
import apap.tugasakhir.Model.RequestUpdateItemModel;
import apap.tugasakhir.Repository.DeliveryDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryDb deliveryDb;

    @Override
    public List<DeliveryModel> getDeliveryList() { return deliveryDb.findAll(); }

    @Override
    public DeliveryModel createDelivery(PegawaiModel pegawai, RequestUpdateItemModel requestUpdateItem) {
        DeliveryModel delivery = new DeliveryModel();

        delivery.setPegawai(pegawai);
        delivery.setRequestUpdateItem(requestUpdateItem);
        delivery.setIdCabang(requestUpdateItem.getIdCabang().intValue());
        delivery.setTanggalDibuat(Date.valueOf(LocalDate.now()));
        delivery.setSent(false);

        return deliveryDb.save(delivery);
    }
}
