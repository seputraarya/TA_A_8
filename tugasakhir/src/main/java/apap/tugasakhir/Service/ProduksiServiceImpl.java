package apap.tugasakhir.Service;

import apap.tugasakhir.Model.ProduksiModel;
import apap.tugasakhir.Repository.ProduksiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ProduksiServiceImpl implements ProduksiService{
    @Autowired
    ProduksiDb produksiDb;

    @Override
    public List<ProduksiModel> getProduksiList(){
        return produksiDb.findAll();
    }
}
