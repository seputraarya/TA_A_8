package apap.tugasakhir.Service;

import apap.tugasakhir.Model.RoleModel;
import apap.tugasakhir.Repository.RoleDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDb roleDb;

    @Override
    public List<RoleModel> findAllRole() {
        return roleDb.findAll();
    }
}
