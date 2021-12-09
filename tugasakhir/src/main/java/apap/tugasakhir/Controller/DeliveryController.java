package apap.tugasakhir.Controller;

import apap.tugasakhir.Model.DeliveryModel;
import apap.tugasakhir.Model.MesinModel;
import apap.tugasakhir.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
    @Qualifier("deliveryServiceImpl")
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/viewall")
    public String listDelivery(Model model) {
        List<DeliveryModel> listDelivery = deliveryService.getDeliveryList();
        model.addAttribute("listDelivery", listDelivery);
        return "viewall-delivery";
    }
}
