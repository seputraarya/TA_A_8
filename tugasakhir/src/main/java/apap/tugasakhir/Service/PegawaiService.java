package apap.tugasakhir.Service;

import apap.tugasakhir.Model.PegawaiModel;
import apap.tugasakhir.Model.RoleModel;

import java.util.List;


public interface PegawaiService {

    PegawaiModel addPegawai(PegawaiModel pegawai);
    String encrypt (String password);
    PegawaiModel findByUsername(String username);
    boolean checkUsername(String username);
    List<PegawaiModel> findAllPegawai();
    void updatePassword(PegawaiModel pegawai, String passwordBaru);
    List<PegawaiModel> findByRole(RoleModel role);
    void incrementCounter(PegawaiModel pegawai);
}
