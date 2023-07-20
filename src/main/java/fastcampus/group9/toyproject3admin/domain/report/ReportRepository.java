package fastcampus.group9.toyproject3admin.domain.report;

import fastcampus.group9.toyproject3admin.web.dto.ReportRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportRepository {
    void insert(ReportRequestDTO requestDTO);
}
