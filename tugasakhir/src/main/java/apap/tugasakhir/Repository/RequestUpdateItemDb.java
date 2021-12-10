package apap.tugasakhir.Repository;

import apap.tugasakhir.Model.RequestUpdateItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestUpdateItemDb extends JpaRepository<RequestUpdateItemModel, Long> {
    RequestUpdateItemModel findByIdRequestUpdateItem(Long idRequestUpdateItem);
}
