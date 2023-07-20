package fastcampus.group9.toyproject3admin.service.report;

import fastcampus.group9.toyproject3admin.domain.report.ReportRepository;
import fastcampus.group9.toyproject3admin.web.dto.ReportRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public void add(ReportRequestDTO requestDTO) {
        reportRepository.insert(requestDTO);
    }
}
