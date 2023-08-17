package fastcampus.group9.toyproject3admin.service.board;

import fastcampus.group9.toyproject3admin._core.exception.CustomException;
import fastcampus.group9.toyproject3admin.domain.board.Board;
import fastcampus.group9.toyproject3admin.domain.board.BoardRepository;
import fastcampus.group9.toyproject3admin.domain.stats.Stats;
import fastcampus.group9.toyproject3admin.web.dto.StatsRequestDTO;
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
        final Board board = findById(id);
        if (board == null)
            throw new CustomException("해당 게시글이 없습니다.");
        boardRepository.deleteById(id);
    }

    public void updateVisibleById(Long id) {
        final Board board = findById(id);
        if (board == null)
            throw new CustomException("해당 게시글이 없습니다.");
        boardRepository.updateVisibleById(id);
    }

    public List<Stats> getStats(StatsRequestDTO requestDTO) {
        return boardRepository.getStats(requestDTO);
    }

}
