package apap.tugasakhir.Service;

import java.util.List;

import apap.tugasakhir.Model.RoleModel;

public interface RoleService {
    List<RoleModel> findAllRole();
    RoleModel findByName(String namaRole);
}

