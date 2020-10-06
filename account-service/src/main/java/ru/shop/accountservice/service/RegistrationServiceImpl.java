package ru.shop.accountservice.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.shop.accountservice.dto.RegistrationDTO;
import ru.shop.accountservice.utils.EmailUtils;
import ru.shop.base.exceptions.BadRequestException;
import ru.shop.base.exceptions.InternalServerException;
import ru.shop.dbtools.models.ConfirmCode;
import ru.shop.dbtools.models.user.Status;
import ru.shop.dbtools.models.user.User;
import ru.shop.dbtools.services.ConfirmCodeService;
import ru.shop.dbtools.services.UserService;
import ru.shop.emailclient.dto.EmailDTO;
import ru.shop.emailclient.service.EmailClientService;

import java.util.Map;
import java.util.Set;
import java.util.UUID;


@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final EmailClientService emailClientService;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmCodeService confirmCodeService;


    public RegistrationServiceImpl(UserService userService, EmailClientService emailClientService, PasswordEncoder passwordEncoder, ConfirmCodeService confirmCodeService) {
        this.userService = userService;
        this.emailClientService = emailClientService;
        this.passwordEncoder = passwordEncoder;
        this.confirmCodeService = confirmCodeService;
    }


    @Override
    public void registration(RegistrationDTO registrationDTO) {
        boolean emailBusy = userService.existsByEmail(registrationDTO.getEmail());
        boolean phoneNumber = userService.existsByPhoneNumber(registrationDTO.getPhoneNumber());


        if (emailBusy) {
            throw new BadRequestException(Map.of("email", Set.of("{RegistrationServiceImpl.registration.emailBusy}")));
        }

        if(phoneNumber) {
            throw new BadRequestException(Map.of("phoneNumber", Set.of("{RegistrationServiceImpl.registration.phoneNumber}")));
        }

        try {
            User user = User.builder()
                    .id(UUID.randomUUID())
                    .firstName(registrationDTO.getFirstName())
                    .lastName(registrationDTO.getLastName())
                    .email(registrationDTO.getEmail())
                    .phoneNumber(registrationDTO.getPhoneNumber())
                    .password(passwordEncoder.encode(registrationDTO.getPassword()))
                    .status(Status.NOT_ACTIVE)
                    //.role(new Role("ROLE_GUEST"))
                    .build();
            userService.saveUser(user);

            ConfirmCode confirmCode  = confirmCodeService.prepareAndSave(user, ConfirmCode.Action.REGISTRATION);
            EmailDTO emailDTO = EmailUtils.createEmailToSend(confirmCode);
            emailClientService.sendEmailFromRegistration(emailDTO);
        }
        catch (Exception ex) {
            throw new InternalServerException("{RegistrationServiceImpl.registration.internalServerException}", ex);
        }
    }

    @Override
    public void confirm(UUID confirmCode, String login) {

    }

}
