package apap.tugasakhir.Service;

import apap.tugasakhir.Model.DeliveryModel;
import apap.tugasakhir.Repository.DeliveryDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryDb deliveryDb;

    @Override
    public List<DeliveryModel> getDeliveryList() { return deliveryDb.findAll(); }
}
