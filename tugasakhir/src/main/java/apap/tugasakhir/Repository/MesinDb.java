package apap.tugasakhir.Repository;

import apap.tugasakhir.Model.MesinModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MesinDb extends JpaRepository<MesinModel, Long>{
    Optional<MesinModel> findByIdMesin(Long idMesin);
}
