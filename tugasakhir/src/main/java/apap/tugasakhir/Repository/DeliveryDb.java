package apap.tugasakhir.Repository;

import apap.tugasakhir.Model.DeliveryModel;
import apap.tugasakhir.Model.MesinModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryDb extends JpaRepository<DeliveryModel, Integer> {
    Optional<DeliveryModel> findByIdDelivery(Integer idDelivery);
}
