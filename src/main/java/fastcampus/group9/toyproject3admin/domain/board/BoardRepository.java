package fastcampus.group9.toyproject3admin.domain.board;

import fastcampus.group9.toyproject3admin.web.dto.BoardResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {

    List<BoardResponseDTO> findAll();

    Board findById(Long id);

    void deleteById(Long id);

    void updateReportFlagById(Long id);
}
