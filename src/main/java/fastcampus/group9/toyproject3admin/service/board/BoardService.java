package fastcampus.group9.toyproject3admin.service.board;

import fastcampus.group9.toyproject3admin.domain.board.Board;
import fastcampus.group9.toyproject3admin.domain.board.BoardRepository;
import fastcampus.group9.toyproject3admin.web.dto.BoardResponseDTO;
import fastcampus.group9.toyproject3admin.web.dto.StatsRequestDTO;
import fastcampus.group9.toyproject3admin.web.dto.StatsResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Board findById(Long id){
        return boardRepository.findById(id);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    public void updateReportFlagById(Long id) {
        boardRepository.updateReportFlagById(id);
    }

    public List<StatsResponseDTO> getStats(StatsRequestDTO requestDTO) {
        return boardRepository.getStats(requestDTO);
    }
}
