package apap.tugasakhir.Controller;

import apap.tugasakhir.Model.RequestUpdateItemModel;
import apap.tugasakhir.Service.RequestUpdateItemRestService;
import apap.tugasakhir.Service.RequestUpdateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/requestupdateitem")
public class RequestUpdateItemController {

    @Autowired
    private RequestUpdateItemService requestUpdateItemService;

    @GetMapping(value = "/viewall")
    public String listRequestUpdateItem(Model model) {
        List<RequestUpdateItemModel> listRequestUpdateItem = requestUpdateItemService.getRequestUpdateItemList();
        model.addAttribute("listRequestUpdateItem", listRequestUpdateItem);
        return "viewall-requestupdateitem";
    }

}
