package apap.tugasakhir.Controller;

import apap.tugasakhir.DTO.Mesin;
import apap.tugasakhir.DTO.Pegawai;
import apap.tugasakhir.Model.MesinModel;
import apap.tugasakhir.Model.PegawaiModel;
import apap.tugasakhir.Model.RequestUpdateItemModel;
import apap.tugasakhir.Model.RoleModel;
import apap.tugasakhir.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/requestupdateitem")
public class RequestUpdateItemController {

    @Autowired
    private RequestUpdateItemService requestUpdateItemService;

    @Autowired
    private RequestUpdateItemRestService requestUpdateItemRestService;

    @Autowired
    private MesinService mesinService;

    @Autowired
    private ProduksiService produksiService;

    @GetMapping(value = "/viewall")
    public String listRequestUpdateItem(Model model) {
        List<RequestUpdateItemModel> listRequestUpdateItem = requestUpdateItemService.getRequestUpdateItemList();
        model.addAttribute("listRequestUpdateItem", listRequestUpdateItem);
        return "viewall-requestupdateitem";
    }

    @GetMapping(value = "/update/{idRequestUpdateItem}")
    public String updateRequestUpdateItem(
            @PathVariable Long idRequestUpdateItem,
            Model model
    ) {
        Long idKategori = requestUpdateItemService.findByIdRequestUpdateItem(idRequestUpdateItem).getIdKategori();
        Long stokTambahan = requestUpdateItemService.findByIdRequestUpdateItem(idRequestUpdateItem).getTambahanStok();
        List<MesinModel> listMesin = mesinService.getMesinByIdKategori(idKategori);
        model.addAttribute("listMesin", listMesin);
        model.addAttribute("mesin", new Mesin());
        model.addAttribute("stokTambahan", stokTambahan);
        return "form-update-requestupdateitem";
    }

    @PostMapping(value = "/update/{idRequestUpdateItem}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateRequestUpdateItem(
            @PathVariable Long idRequestUpdateItem,
            Mesin mesin,
            Model model
    ) {
        MesinModel mesinProduksi = mesinService.getMesinByIdMesin(mesin.getId().intValue());
        RequestUpdateItemModel requestUpdateItem = requestUpdateItemService.findByIdRequestUpdateItem(idRequestUpdateItem);
        if (requestUpdateItem.getExecuted()) {
            produksiService.createProduksi(requestUpdateItem, mesinProduksi);
            requestUpdateItemService.updateRequestUpdateItem(requestUpdateItem);
            requestUpdateItemRestService.executeRequestUpdateItem(requestUpdateItem);
        }
        return "update-requestupdateitem";
    }
}
