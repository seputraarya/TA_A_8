package apap.tugasakhir.Rest;

import apap.tugasakhir.Model.RequestUpdateItemModel;
import apap.tugasakhir.Service.RequestUpdateItemRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class RequestUpdateItemRestController {
    @Autowired
    RequestUpdateItemRestService requestUpdateItemRestService;

    @PostMapping(value = "/requestupdateitem")
    private RequestUpdateItemModel createRequestUpdateItem(@Valid @RequestBody RequestUpdateItemModel requestUpdateItem, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field."
            );

        } else {
            return requestUpdateItemRestService.createRequestUpdateItem(requestUpdateItem);
        }
    }

}
