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
import java.util.Optional;

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
        delivery.setSent(1);

        return deliveryDb.save(delivery);
    }

    @Override
    public DeliveryModel getDeliveryById(Integer id) {
        Optional<DeliveryModel> delivery = deliveryDb.findByIdDelivery(id);
        return delivery.get();
    }
}
