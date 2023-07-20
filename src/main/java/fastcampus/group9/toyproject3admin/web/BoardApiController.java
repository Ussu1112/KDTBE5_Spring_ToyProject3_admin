package fastcampus.group9.toyproject3admin.web;

import fastcampus.group9.toyproject3admin._core.handler.exception.CustomException;
import fastcampus.group9.toyproject3admin.domain.board.Board;
import fastcampus.group9.toyproject3admin.service.board.BoardService;
import fastcampus.group9.toyproject3admin.web.dto.BoardResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;

    @GetMapping("/api/v1/posts")
    public ResponseEntity<List<BoardResponseDTO>> getAllPosts(){
        List<BoardResponseDTO> allPosts = boardService.findAll();
        return ResponseEntity.ok(allPosts);
    }

    @DeleteMapping("/api/v1/board/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        validation(id);
        boardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/v1/board/{id}")
    public ResponseEntity<Void> updateVisible(@PathVariable Long id){
        validation(id);
        boardService.updateReportFlagById(id);
        return ResponseEntity.noContent().build();
    }

    private void validation(Long id) {
        final Board board = boardService.findById(id);
        if (board == null)
            throw new CustomException("해당 게시글이 없습니다.");
    }
}
