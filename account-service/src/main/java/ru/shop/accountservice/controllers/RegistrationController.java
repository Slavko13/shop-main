package ru.shop.accountservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shop.accountservice.dto.RegistrationDTO;
import ru.shop.accountservice.service.RegistrationService;

@RestController
@CrossOrigin(maxAge = 3600)
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

//    @GetMapping("/registration")
//    public void showForm() {
//        RegistrationDTO registrationDTO = new RegistrationDTO("dafsf", "slava", "fdsf0", "fdsaf", "firepoint.pro@gmail.com");
//        registrationService.registration(registrationDTO);
//    }

    @PostMapping("/registration")
    @CrossOrigin
    public String registrateUser(@ModelAttribute RegistrationDTO registrationDTO) {
        registrationService.registration(registrationDTO);
        return "redirect:/login";
    }

}
