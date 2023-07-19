package fastcampus.group9.toyproject3admin.web;

import fastcampus.group9.toyproject3admin.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;

}
