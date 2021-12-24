package apap.tugasakhir.Service;

import apap.tugasakhir.Model.MesinModel;
import apap.tugasakhir.Repository.MesinDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MesinServiceImpl implements MesinService{

    @Autowired
    MesinDb mesinDb;

    @Override
    public List<MesinModel> getMesinList() {
        return mesinDb.findAll();
    }

    @Override
    public MesinModel getMesinByIdMesin(int idMesin) {
        Long idlong = Long.valueOf(idMesin);
        Optional<MesinModel> mesin = mesinDb.findByIdMesin(idlong);
        if(mesin.isPresent()){
            return mesin.get();
        }
        return null;
    }

    @Override
    public List<MesinModel> getMesinByIdKategori(Long idKategori) { return mesinDb.findByIdKategori(idKategori); }
}
