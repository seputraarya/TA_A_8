package apap.tugasakhir.Repository;

import apap.tugasakhir.Model.DeliveryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryDb extends JpaRepository<DeliveryModel, Long> {
}
