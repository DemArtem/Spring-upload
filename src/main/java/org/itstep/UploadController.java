package org.itstep;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @GetMapping( value = {"/", "/index"} )
    public String index() {
        return "index";
    }

    @PostMapping
    public String upload(@RequestParam( "file" ) MultipartFile file, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Success uploaded " +
                file.getOriginalFilename());
        String fileName = file.getOriginalFilename();
        File uploadedDirectory = new File("src/main/resources/uploaded");
        System.out.println(uploadedDirectory);
        try {
            file.transferTo(new File(uploadedDirectory.getAbsolutePath() +
                    "/" +
                    fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "index";
    }
}
