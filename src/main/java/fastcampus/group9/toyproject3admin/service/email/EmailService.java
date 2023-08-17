package fastcampus.group9.toyproject3admin.service.email;

import fastcampus.group9.toyproject3admin._core.exception.CustomException;
import fastcampus.group9.toyproject3admin.domain.email.EmailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final ApplicationContext ac;
    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;

    public void sendMail(EmailMessage emailMessage, String username, String emailForm) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        String fromEmail = ac.getEnvironment().getProperty("spring.mail.username");
        if (fromEmail == null)
            throw new CustomException("발신자 메일 오류");

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            mimeMessageHelper.setTo(emailMessage.getTo());
            mimeMessageHelper.setSubject(emailMessage.getSubject());
            mimeMessageHelper.setText(setContext(username, emailForm), true);
            mimeMessageHelper.setFrom(fromEmail);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new CustomException("메일이 전송되지 않았습니다.");
        }
    }

    public String setContext(String username, String emailForm) {
        Context context = new Context();
        context.setVariable("username", username);
        return templateEngine.process(emailForm, context);
    }
}

