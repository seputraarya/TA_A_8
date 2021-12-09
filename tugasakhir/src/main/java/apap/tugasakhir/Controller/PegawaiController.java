package apap.tugasakhir.Controller;

import apap.tugasakhir.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import apap.tugasakhir.Model.PegawaiModel;
import apap.tugasakhir.Service.PegawaiService;
import apap.tugasakhir.Model.RoleModel;

import java.util.*;


@Controller
@RequestMapping("/pegawai")
public class PegawaiController {

    @Autowired
    private PegawaiService pegawaiService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/add")
    private String addPegawaiFormPage(Model model){
        PegawaiModel pegawai = new PegawaiModel();
        List<RoleModel> listRole = roleService.findAllRole();
        model.addAttribute("pegawai", pegawai);
        model.addAttribute("listRole", listRole);
        return "form-add-pegawai";
    }

    @PostMapping(value = "/add")
    private String addPegawaiSubmit(@ModelAttribute PegawaiModel pegawai, Model model){
        boolean checkPegawaiUsername = pegawaiService.checkUsername(pegawai.getUsername());
        if(checkPegawaiUsername){
            pegawaiService.addPegawai(pegawai);
            pegawai.setCounter(Long.valueOf(1));
        }
        else{
            return "username-checked";
        }

        model.addAttribute("pegawai",pegawai);
        return "add-pegawai";
    }

    @GetMapping(value = "/viewall")
    public String listSemuaPegawai(Model model){
        List<PegawaiModel> listPegawai = pegawaiService.findAllPegawai();
        model.addAttribute("listPegawai", listPegawai);
        return "viewall-pegawai";
    }

}
