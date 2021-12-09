package apap.tugasakhir.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tugasakhir.Model.PegawaiModel;
import apap.tugasakhir.Repository.PegawaiDb;
import apap.tugasakhir.Service.PegawaiService;

@Controller
public class PageController {

    @Autowired
    PegawaiDb pegawaiDb;

    @Autowired
    PegawaiService pegawaiService;
    
    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/changePass")
    public String changePassForm(Model model) {
        return "form-change-pass";
    }

    @PostMapping(value = "/changePass")
    public String changePassSubmit(@RequestParam String username, @RequestParam String passwordLama,
    @RequestParam String passwordBaru, @RequestParam String passwordBaruConfirm, Model model) {
        PegawaiModel pegawai = pegawaiDb.findByUsername(username);
        BCryptPasswordEncoder hashedPass = new BCryptPasswordEncoder();
        if (hashedPass.matches(passwordLama, pegawai.getPassword())) {
            if(passwordBaru.equals(passwordBaruConfirm)) {
                pegawaiService.updatePassword(pegawai, passwordBaru);
            }
        }
        return "redirect:/";
    }
}
