package apap.tugasakhir.Service;

import apap.tugasakhir.Model.MesinModel;
import apap.tugasakhir.Repository.MesinDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MesinRestServiceImpl implements MesinRestService{

    @Autowired
    MesinDb mesinDb;
    @Override
    public List<MesinModel> retrieveListMesin(){
        return mesinDb.findAll();
    }

}
