package apap.tugasakhir.Controller;

import apap.tugasakhir.DTO.Item;
import apap.tugasakhir.Model.PegawaiModel;
import apap.tugasakhir.Model.ProduksiModel;
import apap.tugasakhir.Service.ItemRestService;
import apap.tugasakhir.Service.ProduksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemRestService itemRestService;

    @Autowired
    private ProduksiService produksiService;

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
        List<ProduksiModel> produksiAll = produksiService.getProduksiList();
        List<ProduksiModel> produksiItem = new ArrayList<>();
        Item item = null;
        for(int i = 0; i<listItem.size();i++){
            if(listItem.get(i).getUuid().equals(uuid)){
                item = listItem.get(i);
            }
            else{}
        }

        for(int i=0; i< produksiAll.size();i++){
            if(produksiAll.get(i).getIdItem().equals(uuid)){
                produksiItem.add(produksiAll.get(i));
            }else{}
        }
        model.addAttribute("item", item);
        model.addAttribute("listProduksi", produksiItem);
        return "view-item";
    }

//    @GetMapping(value = "/viewall")
//    public List<Item> listSemuaItem(Model model){
//        List<Item> listItem = itemRestService.retriveAllItem();
//        return listItem;
//    }
}
