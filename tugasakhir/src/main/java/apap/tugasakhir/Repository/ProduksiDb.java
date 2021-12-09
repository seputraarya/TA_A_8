package apap.tugasakhir.Repository;

import apap.tugasakhir.Model.ProduksiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduksiDb extends JpaRepository<ProduksiModel, Long> {
}
