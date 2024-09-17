package upao.Transa.Service.Impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import upao.Transa.Service.IEmailService;
import upao.Transa.Service.modelsDTO.EmailDTO;

@Service
public class EmailServiceImpl implements IEmailService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public EmailServiceImpl(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendMail(EmailDTO email) throws MessagingException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email.getDestinatario());
            helper.setSubject(email.getAsunto());

            Context context = new Context();
            context.setVariable("message", email.getMensaje());
            String contentHTML = templateEngine.process("email", context);

            helper.setText(contentHTML, true);
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar el correo: " + e.getMessage(), e);
        }
    }
}
