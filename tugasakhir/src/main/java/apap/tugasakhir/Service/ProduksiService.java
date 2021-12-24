package apap.tugasakhir.Service;


import apap.tugasakhir.Model.MesinModel;
import apap.tugasakhir.Model.ProduksiModel;
import apap.tugasakhir.Model.RequestUpdateItemModel;

import java.util.List;

public interface ProduksiService {
    List<ProduksiModel> getProduksiList();
    ProduksiModel createProduksi(RequestUpdateItemModel requestUpdateItem, MesinModel mesin);

}
