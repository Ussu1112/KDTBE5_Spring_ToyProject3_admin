package fastcampus.group9.toyproject3admin.web;

import fastcampus.group9.toyproject3admin.domain.board.Board;
import fastcampus.group9.toyproject3admin.domain.stats.Stats;
import fastcampus.group9.toyproject3admin.service.board.BoardService;
import fastcampus.group9.toyproject3admin.web.dto.BoardResponseDTO;
import fastcampus.group9.toyproject3admin.web.dto.StatsRequestDTO;
import fastcampus.group9.toyproject3admin.web.dto.StatsResponseDTO;
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
        List<Board> allPosts = boardService.findAll();
        return ResponseEntity.ok(BoardResponseDTO.listOf(allPosts));
    }

    @DeleteMapping("/api/v1/board/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        boardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/v1/board/{id}")
    public ResponseEntity<Void> updateVisible(@PathVariable Long id){
        boardService.updateVisibleById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/v1/stats")
    public ResponseEntity<List<StatsResponseDTO>> getUserStat(@RequestBody StatsRequestDTO requestDTO){
        System.out.println(requestDTO.toString());
        List<Stats> stats = boardService.getStats(requestDTO);
        return ResponseEntity.ok(StatsResponseDTO.listOf(stats));
    }
}
