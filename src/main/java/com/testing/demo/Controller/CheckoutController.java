package com.testing.demo.Controller;

import com.testing.demo.Model.Request.ChargeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class CheckoutController {

    @Value("pk_test_51J8R13E0pZfHtqeOwbTMbjIavkjjILqevpElHxiuWopUuznA7SzlW2kjYV1z5PeFN6X3CZxX1OMrgTmiS4Eu0AgQ00XitZCzFs")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }

}
