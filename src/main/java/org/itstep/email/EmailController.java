package org.itstep.email;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping("/sendsimple")
    public String sendSimple(Model model){
        Email email = new Email();
        email.setTo("demar.demidov@yandex.ru");
        email.setFrom("demar.demidov@yandex.ru");
        email.setSubject("Simple text");
        emailService.sendSimpleMessage(email);
        return "success";
    }
}
