package apap.tugasakhir.Controller;

import apap.tugasakhir.DTO.Item;
import apap.tugasakhir.DTO.ProposeItem;
import apap.tugasakhir.Model.MesinModel;
import apap.tugasakhir.Model.PegawaiModel;
import apap.tugasakhir.Model.ProduksiModel;
import apap.tugasakhir.Repository.MesinDb;
import apap.tugasakhir.Service.ItemRestService;

import apap.tugasakhir.Service.ProduksiService;
import reactor.core.publisher.Mono;

import org.postgresql.translation.messages_es;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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

    @Autowired
    private ProduksiService produksiService;

    @GetMapping(value = "/viewall")
    public String listSemuaItem(Model model) {
        List<Item> listItem = itemRestService.retriveAllItem();
        model.addAttribute("listItem", listItem);
        return "viewall-item";
    }

    @GetMapping("/view/{uuid}")
    public String viewDetailCabang(
            @PathVariable String uuid,
            Model model) {
        List<Item> listItem = itemRestService.retriveAllItem();
        List<ProduksiModel> produksiAll = produksiService.getProduksiList();
        List<ProduksiModel> produksiItem = new ArrayList<>();
        Item item = null;
        for (int i = 0; i < listItem.size(); i++) {
            if (listItem.get(i).getUuid().equals(uuid)) {
                item = listItem.get(i);
            } else {
            }
        }

        for (int i = 0; i < produksiAll.size(); i++) {
            if (produksiAll.get(i).getIdItem().equals(uuid)) {
                produksiItem.add(produksiAll.get(i));
            } else {
            }
        }
        model.addAttribute("item", item);
        model.addAttribute("listProduksi", produksiItem);
        return "view-item";
    }

    @GetMapping(value = "/update/{uuid}")
    public String updateItemForm(@PathVariable String uuid, Model model) {
        List<Item> listItem = itemRestService.retriveAllItem();
        Item itemNew = new Item();
        List<MesinModel> listMesin = mesinDb.findAll();
        List<MesinModel> listMesinKategori = new ArrayList<>();

        for (Item item : listItem) {
            if (item.getUuid().equals(uuid)) {
                itemNew = item;
            }
        }

        for (MesinModel mesin : listMesin) {
                String kategori = "";
                switch (mesin.getIdKategori().intValue()) {
                    case 1:
                        kategori = "BUKU";
                        break;
                    case 2:
                        kategori = "DAPUR";
                        break;
                    case 3:
                        kategori = "MAKANAN & MINUMAN";
                        break;
                    case 4:
                        kategori = "ELEKTRONIK";
                        break;
                    case 5:
                        kategori = "FASHION";
                        break;
                    case 6:
                        kategori = "KECANTIKAN & PERAWATAN DIRI";
                        break;
                    case 7:
                        kategori = "FILM & MUSIK";
                        break;
                    case 8:
                        kategori = "GAMING";
                        break;
                    case 9:
                        kategori = "GADGET";
                        break;
                    case 10:
                        kategori = "KESEHATAN";
                        break;
                    case 11:
                        kategori = "RUMAH TANGGA";
                        break;
                    case 12:
                        kategori = "FURNITURE";
                        break;
                    case 13:
                        kategori = "ALAT & PERANGKAT KERAS";
                        break;
                    case 14:
                        kategori = "WEDDING";
                        break;
                }
                if (itemNew.getKategori().equals(kategori) && !listMesinKategori.contains(mesin)) {
                    listMesinKategori.add(mesin);
                }
        }

        model.addAttribute("item", itemNew);
        model.addAttribute("listMesinKategori", listMesinKategori);
        return "form-update-stok-item";
    }

    @RequestMapping(value = "/update/{uuid}", method = RequestMethod.PUT)
    public String updateItemSubmit(@PathVariable String uuid, @ModelAttribute Item item, RedirectAttributes redirect) {
        item.setStok(item.getStok());
        return "redirect:/";
    }

    @GetMapping("/propose-item")
    public String proposeItemForm(Model model) {
        List<MesinModel> listMesin = mesinDb.findAll();
        List<Long> listKategori = new ArrayList<>();
        ProposeItem item = new ProposeItem();
        for (MesinModel mesin : listMesin) {
            if (!listKategori.contains(mesin.getIdKategori()))
                listKategori.add(mesin.getIdKategori());
        }
        model.addAttribute("item", item);
        model.addAttribute("listKategori", listKategori);
        return "form-propose-item";
    }

    @RequestMapping(value = "/propose-item", method = RequestMethod.POST)
    public String proposeItemSubmit(@ModelAttribute ProposeItem item, RedirectAttributes redirect) {
        // System.out.println("nama item dari form propose item");
        // System.out.println(item.getNama());
        itemRestService.proposeItem(item);
        // System.out.println(proposeItem);
        return "redirect:/";
    }

    // @GetMapping(value = "/viewall")
    // public List<Item> listSemuaItem(Model model){
    // List<Item> listItem = itemRestService.retriveAllItem();
    // return listItem;
    // }
}