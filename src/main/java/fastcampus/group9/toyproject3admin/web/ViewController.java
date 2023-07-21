package fastcampus.group9.toyproject3admin.web;

import fastcampus.group9.toyproject3admin.service.board.BoardService;
import fastcampus.group9.toyproject3admin.service.user.UserService;
import fastcampus.group9.toyproject3admin.web.dto.BoardResponseDTO;
import fastcampus.group9.toyproject3admin.web.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ViewController {

    private final UserService userService;
    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", (UserResponseDTO.listOf(userService.findAll())));
        return "admin.html";
    }

    @GetMapping("/board")
    public String board(Model model) {
        model.addAttribute("boards", (BoardResponseDTO.listOf(boardService.findAll())));
        return "board.html";
    }

    @GetMapping("/stats")
    public String stats(Model model){
        return "stats.html";
    }
}
