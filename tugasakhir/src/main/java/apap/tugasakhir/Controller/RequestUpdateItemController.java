package apap.tugasakhir.Controller;

import apap.tugasakhir.DTO.Mesin;
import apap.tugasakhir.DTO.Pegawai;
import apap.tugasakhir.Model.*;
import apap.tugasakhir.Service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private PegawaiService pegawaiService;

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
    ) throws JsonProcessingException {
        PegawaiModel pegawai = pegawaiService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        MesinModel mesinProduksi = mesinService.getMesinByIdMesin(mesin.getId().intValue());
        RequestUpdateItemModel requestUpdateItem = requestUpdateItemService.findByIdRequestUpdateItem(idRequestUpdateItem);
        System.out.println(requestUpdateItem.getExecuted());

        if (requestUpdateItem.getExecuted() == false) {
            ProduksiModel produksi = produksiService.createProduksi(requestUpdateItem, mesinProduksi, pegawai);
            requestUpdateItemService.updateRequestUpdateItem(requestUpdateItem, produksi);
            requestUpdateItemRestService.executeRequestUpdateItem(requestUpdateItem);
        }
        return "update-requestupdateitem";
    }
}
