package fastcampus.group9.toyproject3admin.web;

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
        boardService.updateVisibleById(requestDTO.getBoardId());
        reportService.add(requestDTO);
        return ResponseEntity.noContent().build();
    }
}
