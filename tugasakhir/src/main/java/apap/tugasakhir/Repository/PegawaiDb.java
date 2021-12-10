package apap.tugasakhir.Repository;

import apap.tugasakhir.Model.PegawaiModel;
import apap.tugasakhir.Model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PegawaiDb extends JpaRepository<PegawaiModel, Long> {
    PegawaiModel findByUsername(String username);
    List<PegawaiModel> findByRole(RoleModel role);
}
