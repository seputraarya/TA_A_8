package apap.tugasakhir.Controller;

import apap.tugasakhir.Model.MesinModel;
import apap.tugasakhir.Service.MesinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mesin")
public class MesinController {
    @Qualifier("mesinServiceImpl")
    @Autowired
    private MesinService mesinService;

    @GetMapping("/viewall")
    public String listMesin(Model model) {
        List<MesinModel> listMesin = mesinService.getMesinList();
        model.addAttribute("listMesin", listMesin);
        return "list-mesin";
    }

    @GetMapping("/{idMesin}")
    public String viewDetailMesin(
            @PathVariable int idMesin,
            Model model
    ) {
        MesinModel mesin = mesinService.getMesinByIdMesin(idMesin);
        model.addAttribute("mesin", mesin);
        return "detail-mesin";
    }

}
