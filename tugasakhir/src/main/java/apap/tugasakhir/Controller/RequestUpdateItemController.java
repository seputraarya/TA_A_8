package apap.tugasakhir.Controller;

import apap.tugasakhir.Model.RequestUpdateItemModel;
import apap.tugasakhir.Service.RequestUpdateItemRestService;
import apap.tugasakhir.Service.RequestUpdateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/requestupdateitem")
public class RequestUpdateItemController {

    @Autowired
    private RequestUpdateItemService requestUpdateItemService;

    @Autowired
    private RequestUpdateItemRestService requestUpdateItemRestService;

    @GetMapping(value = "/viewall")
    public String listRequestUpdateItem(Model model) {
        List<RequestUpdateItemModel> listRequestUpdateItem = requestUpdateItemService.getRequestUpdateItemList();
        model.addAttribute("listRequestUpdateItem", listRequestUpdateItem);
        return "viewall-requestupdateitem";
    }

    @GetMapping(value = "/execute/{noRequestUpdateItem}")
    public String executeRequestUpdateItem(
            @PathVariable Long noRequestUpdateItem,
            Model model
    ) {
        RequestUpdateItemModel requestUpdateItem = requestUpdateItemService.findByIdRequestUpdateItem(noRequestUpdateItem);
        requestUpdateItemRestService.executeRequestUpdateItem(requestUpdateItem);
        return "viewall-requestupdateitem";
    }
}
