package ru.shop.accountservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import ru.shop.accountservice.dto.ConfirmCodeDTO;
import ru.shop.accountservice.dto.RegistrationDTO;
import ru.shop.accountservice.service.RegistrationService;
import ru.shop.dbtools.services.UserService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final UserService userService;

    @Autowired
    public RegistrationController(RegistrationService registrationService, UserService userService) {
        this.registrationService = registrationService;
        this.userService = userService;
    }

   @GetMapping("/registration")
        public void showForm() {
        RegistrationDTO registrationDTO = new RegistrationDTO("dafsfa", "slava", "fdsf0", "fdsaf", "firepoint.pro@gmail.com");
        registrationService.registration(registrationDTO);
    }


    @PostMapping("/newUser")
    @CrossOrigin
    public ResponseEntity registrateUser(@RequestBody RegistrationDTO registrationDTO) {
        registrationService.registration(registrationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/confirm")
    @CrossOrigin
    public ResponseEntity confirmEmail(@RequestBody ConfirmCodeDTO confirmCodeDTO) {
        registrationService.confirm(confirmCodeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete")
    public void pressF() {
        userService.deleteUserByEmail("firepoint.pro@gmail.com");
    }


}
