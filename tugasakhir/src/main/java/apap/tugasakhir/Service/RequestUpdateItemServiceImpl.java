package apap.tugasakhir.Service;

import apap.tugasakhir.Model.RequestUpdateItemModel;
import apap.tugasakhir.Repository.RequestUpdateItemDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestUpdateItemServiceImpl implements RequestUpdateItemService{

    @Autowired
    RequestUpdateItemDb requestUpdateItemDb;

    @Override
    public List<RequestUpdateItemModel> getRequestUpdateItemList() { return requestUpdateItemDb.findAll(); }
}
