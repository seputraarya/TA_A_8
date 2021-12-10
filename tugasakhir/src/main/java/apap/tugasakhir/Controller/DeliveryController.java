package apap.tugasakhir.Controller;

import apap.tugasakhir.DTO.Pegawai;
import apap.tugasakhir.Model.*;
import apap.tugasakhir.Service.DeliveryService;
import apap.tugasakhir.Service.PegawaiService;
import apap.tugasakhir.Service.RequestUpdateItemService;
import apap.tugasakhir.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @GetMapping("/viewall")
    public String listDelivery(Model model) {
        List<DeliveryModel> listDelivery = deliveryService.getDeliveryList();
        model.addAttribute("listDelivery", listDelivery);
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

    @PostMapping("/create/{idRequestUpdateItem}")
    public String createDeliverySubmit(
            @PathVariable Long idRequestUpdateItem,
            @RequestBody Pegawai kurir,
            Model model
    ) {
        PegawaiModel pegawai = pegawaiService.findByUsername(kurir.getUsername());
        RequestUpdateItemModel requestUpdateItem = requestUpdateItemService.findByIdRequestUpdateItem(idRequestUpdateItem);
        deliveryService.createDelivery(pegawai, requestUpdateItem);
        pegawaiService.incrementCounter(pegawai);

        return "add-delivery";
    }

}
