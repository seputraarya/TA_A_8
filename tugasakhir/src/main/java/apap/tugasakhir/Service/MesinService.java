package apap.tugasakhir.Service;

import apap.tugasakhir.Model.MesinModel;

import java.util.List;

public interface MesinService {
    List<MesinModel> getMesinList();
    MesinModel getMesinByIdMesin(int idMesin);
}
