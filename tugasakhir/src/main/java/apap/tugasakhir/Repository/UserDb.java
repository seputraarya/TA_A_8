package apap.tugasakhir.Repository;

import apap.tugasakhir.Model.PegawaiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDb extends JpaRepository<PegawaiModel, Long>{
    PegawaiModel findByUsername(String username);
}
