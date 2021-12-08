package apap.tugasakhir.Controller;

import apap.tugasakhir.Model.ProduksiModel;
import apap.tugasakhir.Service.ProduksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/produksi")
@Controller
public class ProduksiController {
    @Qualifier("produksiServiceImpl")
    @Autowired
    private ProduksiService produksiService;

    @GetMapping("/viewall")
    public String listProduksi(Model model) {
        List<ProduksiModel> listProduksi = produksiService.getProduksiList();
        model.addAttribute("listProduksi", listProduksi);
        return "list-produksi";
    }
}
