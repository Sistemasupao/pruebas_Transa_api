package upao.Transa.Service;

import jakarta.mail.MessagingException;
import upao.Transa.Service.modelsDTO.EmailDTO;

public interface IEmailService {
    public void sendMail(EmailDTO email) throws MessagingException;
}
