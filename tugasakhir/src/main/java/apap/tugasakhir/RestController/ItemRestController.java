package apap.tugasakhir.RestController;

import apap.tugasakhir.DTO.Item;
import apap.tugasakhir.Model.MesinModel;
import apap.tugasakhir.Service.ItemRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ItemRestController {

    @Autowired
    ItemRestService itemRestService;

    @GetMapping(value = "/listItem")
    private List<Item> retrieveListItem(){return itemRestService.retriveAllItem();}
}
