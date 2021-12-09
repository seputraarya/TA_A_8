package apap.tugasakhir.Repository;

import apap.tugasakhir.Model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleDb extends JpaRepository<RoleModel, Long> {

}
