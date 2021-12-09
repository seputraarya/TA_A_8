package apap.tugasakhir.Controller;

import apap.tugasakhir.DTO.Item;
import apap.tugasakhir.Model.MesinModel;
import apap.tugasakhir.Model.PegawaiModel;
import apap.tugasakhir.Repository.MesinDb;
import apap.tugasakhir.Service.ItemRestService;

import org.postgresql.translation.messages_es;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemRestService itemRestService;

    @Autowired
    private MesinDb mesinDb;

    @GetMapping(value = "/viewall")
    public String listSemuaItem(Model model){
        List<Item> listItem = itemRestService.retriveAllItem();
        model.addAttribute("listItem",listItem);
        return "viewall-item";
    }

    @GetMapping("/view/{uuid}")
    public String viewDetailCabang(
            @PathVariable String uuid,
            Model model
    ){
        List<Item> listItem = itemRestService.retriveAllItem();
        Item item = null;
        for(int i = 0; i<listItem.size();i++){
            if(listItem.get(i).getUuid().equals(uuid)){
                item = listItem.get(i);
            }
            else{}
        }
        model.addAttribute("item", item);
        return "view-item";
    }

    @GetMapping("/propose-item")
    public String proposeItemForm(Model model) {
        List<MesinModel> listMesin = mesinDb.findAll();
        List<Long> listKategori = new ArrayList<>();
        for (MesinModel mesin : listMesin) {
            if (!listKategori.contains(mesin.getIdKategori())) listKategori.add(mesin.getIdKategori());
            
        }
        model.addAttribute("listKategori", listKategori);
        return "form-propose-item";
    }

    @PostMapping("/api/v1/propose-item")
    public String proposeItemSubmit(@ModelAttribute Item item, RedirectAttributes redirect) {
        // TODO: ItemRestService
        return "redirect:/";
    }

//    @GetMapping(value = "/viewall")
//    public List<Item> listSemuaItem(Model model){
//        List<Item> listItem = itemRestService.retriveAllItem();
//        return listItem;
//    }
}
