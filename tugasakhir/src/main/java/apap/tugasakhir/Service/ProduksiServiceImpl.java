package apap.tugasakhir.Service;

import apap.tugasakhir.Model.MesinModel;
import apap.tugasakhir.Model.ProduksiModel;
import apap.tugasakhir.Model.RequestUpdateItemModel;
import apap.tugasakhir.Repository.ProduksiDb;
import apap.tugasakhir.Repository.RequestUpdateItemDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
@Service
@Transactional
public class ProduksiServiceImpl implements ProduksiService{
    @Autowired
    ProduksiDb produksiDb;

    @Autowired
    RequestUpdateItemDb requestUpdateItemDb;

    @Override
    public List<ProduksiModel> getProduksiList(){ return produksiDb.findAll(); }

    @Override
    public ProduksiModel createProduksi(RequestUpdateItemModel requestUpdateItem, MesinModel mesin) {
        ProduksiModel produksi = new ProduksiModel();
        produksi.setIdItem(requestUpdateItem.getIdItem());
        produksi.setIdKategori(requestUpdateItem.getIdKategori());
        produksi.setTambahanStok(requestUpdateItem.getTambahanStok());
        produksi.setTanggalProduksi(Date.valueOf(LocalDate.now()));
        produksi.setRequestUpdateItem(requestUpdateItem);
        produksi.setMesin(mesin);


        return produksiDb.save(produksi);
    }
}
