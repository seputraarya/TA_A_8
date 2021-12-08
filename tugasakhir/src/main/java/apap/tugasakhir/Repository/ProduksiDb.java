package apap.tugasakhir.Repository;

import apap.tugasakhir.Model.ProduksiModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduksiDb extends JpaRepository<ProduksiModel, Long> {
}
