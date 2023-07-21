package fastcampus.group9.toyproject3admin.web;

import fastcampus.group9.toyproject3admin._core.handler.exception.CustomException;
import fastcampus.group9.toyproject3admin.domain.board.Board;
import fastcampus.group9.toyproject3admin.service.board.BoardService;
import fastcampus.group9.toyproject3admin.service.report.ReportService;
import fastcampus.group9.toyproject3admin.web.dto.ReportRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReportApiController {
    private final ReportService reportService;
    private final BoardService boardService;

    @PostMapping("/api/v1/report")
    public ResponseEntity<Void> create(@RequestBody ReportRequestDTO requestDTO){
        Board board = boardService.findById(requestDTO.getBoardId());
        if (board == null)
            throw new CustomException("해당 게시글이 없습니다.");
        boardService.updateVisibleById(requestDTO.getBoardId());
        reportService.add(requestDTO);
        return ResponseEntity.noContent().build();
    }
}
