package fastcampus.group9.toyproject3admin.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {
    @GetMapping("/")
    public String index() {
        return "Hello admin!";
    }
}
