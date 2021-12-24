package apap.tugasakhir.Service;

import apap.tugasakhir.Model.DeliveryModel;
import apap.tugasakhir.Model.PegawaiModel;
import apap.tugasakhir.Model.ProduksiModel;
import apap.tugasakhir.Model.RequestUpdateItemModel;
import apap.tugasakhir.Repository.PegawaiDb;
import apap.tugasakhir.Repository.RequestUpdateItemDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestUpdateItemServiceImpl implements RequestUpdateItemService {

    @Autowired
    RequestUpdateItemDb requestUpdateItemDb;

    @Autowired
    PegawaiDb pegawaiDb;

    @Override
    public List<RequestUpdateItemModel> getRequestUpdateItemList() { return requestUpdateItemDb.findAll(); }

    @Override
    public  RequestUpdateItemModel findByIdRequestUpdateItem(Long idRequestUpdateItem) {
        return requestUpdateItemDb.findByIdRequestUpdateItem(idRequestUpdateItem);
    }

    @Override
    public void updateRequestUpdateItem(RequestUpdateItemModel requestUpdateItem, ProduksiModel produksi) {
        if (produksi == null) {
            System.out.println("bebas");
        }
        PegawaiModel pegawai = produksi.getPegawai();
        pegawai.setCounter(pegawai.getCounter() + 1);
        pegawaiDb.save(pegawai);
        requestUpdateItem.setExecuted(true);
        requestUpdateItemDb.save(requestUpdateItem);
    }

    @Override
    public void updateDelivery(RequestUpdateItemModel requestUpdateItem, DeliveryModel delivery) {
        requestUpdateItem.setDelivery(delivery);
        requestUpdateItemDb.save(requestUpdateItem);
    }
}
