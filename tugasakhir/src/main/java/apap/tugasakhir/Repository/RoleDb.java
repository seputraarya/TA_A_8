package apap.tugasakhir.Repository;

import apap.tugasakhir.Model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDb extends JpaRepository<RoleModel, Long> {

}
