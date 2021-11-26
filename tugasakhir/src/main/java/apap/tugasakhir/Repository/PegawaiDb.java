package apap.tugasakhir.Repository;

import apap.tugasakhir.Model.PegawaiModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PegawaiDb extends JpaRepository<PegawaiModel, Long> {
    PegawaiModel findByUsername(String username);
}
