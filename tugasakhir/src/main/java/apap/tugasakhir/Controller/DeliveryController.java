package apap.tugasakhir.Controller;

import apap.tugasakhir.DTO.Cabang;
import apap.tugasakhir.DTO.Pegawai;
import apap.tugasakhir.Model.*;
import apap.tugasakhir.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
    @Qualifier("deliveryServiceImpl")
    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PegawaiService pegawaiService;

    @Autowired
    private RequestUpdateItemService requestUpdateItemService;

    @Autowired
    private CabangRestService cabangRestService;

    @GetMapping("/viewall")
    public String listDelivery(Model model) {
        List<DeliveryModel> listDelivery = deliveryService.getDeliveryList();
        model.addAttribute("listDelivery", listDelivery);
        String exist = "";
        String alamat = "";
        model.addAttribute("exist",exist);
        model.addAttribute("alamat",alamat);
        return "viewall-delivery";
    }

    @GetMapping("/create/{idRequestUpdateItem}")
    public String createDelivery(
            @PathVariable Long idRequestUpdateItem,
            Model model) {
        RoleModel role = roleService.findByName("STAFF_KURIR");
        List<PegawaiModel> listKurir = pegawaiService.findByRole(role);
        model.addAttribute("listKurir", listKurir);
        model.addAttribute("kurir", new Pegawai());

        return "form-add-delivery";
    }

    @PostMapping(value = "/create/{idRequestUpdateItem}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createDeliverySubmit(
            @PathVariable Long idRequestUpdateItem,
            Pegawai kurir,
            Model model
    ) {
        PegawaiModel pegawai = pegawaiService.findByUsername(kurir.getUsername());
        RequestUpdateItemModel requestUpdateItem = requestUpdateItemService.findByIdRequestUpdateItem(idRequestUpdateItem);
        DeliveryModel delivery = deliveryService.createDelivery(pegawai, requestUpdateItem);
        pegawaiService.incrementCounter(pegawai);
        requestUpdateItemService.updateDelivery(requestUpdateItem, delivery);

        return "add-delivery";
    }
    @GetMapping("/{id}")
    public String sendDelivery(
            @PathVariable Integer id,
            Model model){
        List<Cabang> listCabang = cabangRestService.retrieveAllcabang();
//        String idcabang = deliveryService.getIdCabang(id);
        DeliveryModel delivery = deliveryService.getDeliveryById(id);
        String exist = "false";
        String alamat = "";
        PegawaiModel pegawai = delivery.getPegawai();
        for(Cabang cabang : listCabang){
            if(String.valueOf(delivery.getIdCabang()).equals(cabang.getId())){
                exist = "true";
                alamat = cabang.getAlamat();
                delivery.setSent(1);
                pegawaiService.incrementCounter(pegawai);
            }
        }
        model.addAttribute("exist",exist);
        model.addAttribute("alamat",alamat);
        List<DeliveryModel> listDelivery = deliveryService.getDeliveryList();
        model.addAttribute("listDelivery", listDelivery);
        return "viewall-delivery";
    }
}
