package sk.umb.example.mockito;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailService {
    public void sendMail(String recipient, String mailSubject, String body) {
        log.info("Mail sent to {}, with subject {} and body {}.", recipient, mailSubject, body);
    }
}
