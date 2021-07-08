package istio.demo.customer.controllers;

import istio.demo.customer.services.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private static final String CUSTOMER_VERSION = "CUSTOMER V2";
    @Autowired
    PreferenceService preferenceService;

    @GetMapping(value = "/customer")
    public String getCustomer() {
        String preference = preferenceService.getPreference();
        return CUSTOMER_VERSION + " => " + preference;
    }
}
