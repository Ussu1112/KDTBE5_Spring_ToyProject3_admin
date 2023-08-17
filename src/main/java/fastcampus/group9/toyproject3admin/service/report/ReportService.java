package fastcampus.group9.toyproject3admin.service.report;

import fastcampus.group9.toyproject3admin._core.exception.CustomException;
import fastcampus.group9.toyproject3admin.domain.board.Board;
import fastcampus.group9.toyproject3admin.domain.board.BoardRepository;
import fastcampus.group9.toyproject3admin.domain.report.ReportRepository;
import fastcampus.group9.toyproject3admin.web.dto.ReportRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final BoardRepository boardRepository;

    public void add(ReportRequestDTO requestDTO) {
        Board board = boardRepository.findById(requestDTO.getBoardId());
        if (board == null)
            throw new CustomException("해당 게시글이 없습니다.");
        reportRepository.insert(requestDTO);
    }
}
