package ru.shop.emailserver.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.exceptions.TemplateProcessingException;
import ru.shop.base.exceptions.BadRequestException;
import ru.shop.emailclient.dto.EmailDTO;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String username;

    @Value("${frontend.url}")
    private String frontendUrl;

    private final JavaMailSender javaMailSender;
    private final ITemplateEngine emailTemplateEngine;

    public EmailServiceImpl(@Qualifier("getJavaMailSender") JavaMailSender javaMailSender, ITemplateEngine emailTemplateEngine) {
        this.javaMailSender = javaMailSender;
        this.emailTemplateEngine = emailTemplateEngine;
    }


    @Override
    public void send(EmailDTO emailDTO) throws MessagingException {
        try {
            final Context ctx = new Context();
            if(emailDTO.getContent() !=  null && !emailDTO.getContent().isEmpty()) {
                emailDTO.getContent().forEach(ctx::setVariable);
                ctx.setVariable("frontendUrl", frontendUrl);
            }
            log.info(emailDTO.getContent().toString());
            String htmlContent = this.emailTemplateEngine.process(emailDTO.getTemplate(), ctx);

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setContent(htmlContent, "text/html; charset=UTF-8");
            mimeMessage.setFrom(new InternetAddress(username));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDTO.getMessageTo()));
            mimeMessage.setSubject(emailDTO.getSubject(), "UTF-8");

            javaMailSender.send(mimeMessage);
        }
        catch (TemplateProcessingException | AddressException ex) {
            throw new BadRequestException(ex);
        }
    }
}

