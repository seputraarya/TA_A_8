package apap.tugasakhir.Service;

import apap.tugasakhir.Model.PegawaiModel;
import apap.tugasakhir.Model.RoleModel;
import apap.tugasakhir.Repository.PegawaiDb;
import apap.tugasakhir.Repository.ProduksiDb;
import apap.tugasakhir.Repository.RequestUpdateItemDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Objects;

import java.util.List;
import java.util.Objects;

@Service
public class PegawaiServiceImpl implements PegawaiService{

    @Autowired
    private PegawaiDb pegawaiDb;

    @Autowired
    private RequestUpdateItemDb requestUpdateItemDb;

    @Autowired
    private ProduksiDb produksiDb;

    @Override
    public PegawaiModel addPegawai(PegawaiModel pegawai){
        String pass = encrypt(pegawai.getPassword());
        pegawai.setPassword(pass);
        return pegawaiDb.save(pegawai);
    }

    @Override
    public String encrypt (String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public PegawaiModel findByUsername(String username){
        return pegawaiDb.findByUsername(username);
    }

    @Override
    public boolean checkUsername(String username){
        boolean check;
        PegawaiModel pegawaiUsername = pegawaiDb.findByUsername(username);

        if(Objects.isNull(pegawaiUsername)){
            check = true;
        }
        else{
            check = false;
        }

        return check;
    }

    @Override
    public List<PegawaiModel> findAllPegawai(){
        return pegawaiDb.findAll();
    }

    @Override
    public void updatePassword(PegawaiModel pegawai, String passwordBaru) {
        pegawai.setPassword(passwordBaru);
        pegawaiDb.save(pegawai);
        
    }

    @Override
    public List<PegawaiModel> findByRole(RoleModel role) { return pegawaiDb.findByRole(role); }

    @Override
    public void incrementCounter(PegawaiModel pegawai) {
        pegawai.setCounter(pegawai.getCounter() + 1);
        pegawaiDb.save(pegawai);
    }
}
