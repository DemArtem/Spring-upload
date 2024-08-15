package org.itstep.email;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping("/sendsimple")
    public String sendSimple(Model model){
        Email email = new Email();
        email.setTo("prizrak220V.AD@gmail.com");
        email.setFrom("prizrak220V.AD@gmail.com");
        email.setSubject("Simple text");
        email.setText("Simple text");
        Map<String, Object> properties = new HashMap<>();
        emailService.sendSimpleMessage(email);
        return "success";
    }
}
