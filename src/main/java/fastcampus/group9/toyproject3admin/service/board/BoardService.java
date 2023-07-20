package fastcampus.group9.toyproject3admin.service.board;

import fastcampus.group9.toyproject3admin.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

}
