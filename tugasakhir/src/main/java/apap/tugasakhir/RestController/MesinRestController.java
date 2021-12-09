package apap.tugasakhir.RestController;

import apap.tugasakhir.Model.MesinModel;
import apap.tugasakhir.Service.MesinRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MesinRestController {
    @Autowired
    private MesinRestService mesinRestService;

    @GetMapping(value = "/list-mesin")
    private List<MesinModel> retrieveListMesin(){
        return mesinRestService.retrieveListMesin();
    }

}

