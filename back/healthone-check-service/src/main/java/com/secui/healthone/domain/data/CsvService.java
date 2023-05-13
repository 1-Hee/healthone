package com.secui.healthone.domain.data;

import com.opencsv.CSVWriter;
import com.secui.healthone.domain.sleep.entity.Sleep;
import com.secui.healthone.domain.sleep.repository.SleepRepository;
import com.secui.healthone.domain.walk.entity.Walk;
import com.secui.healthone.domain.walk.repository.WalkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvService {

    private final WalkRepository walkRepository;
    private final SleepRepository sleepRepository;

    public HttpServletResponse writeWalkDtoToCsv(HttpServletResponse response, Integer userNo) throws IOException {
        try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8))) {
            writer.writeNext(new String[]{"식별번호", "유저식별번호", "기록시간", "걸음수", "이동거리"});
            List<Walk> walkList = walkRepository.findAllByUserNoOrderByCreatetimeDesc(userNo);
            for (Walk entity : walkList) {
                writer.writeNext(new String[]{
                        String.valueOf(entity.getNo()),
                        String.valueOf(entity.getUserNo()),
                        entity.getCreatetime().toString(),
                        String.valueOf(entity.getStepCount()),
                        String.valueOf(entity.getDistance())
                });
            }
            return response;
        }
    }

//    public HttpServletResponse writeSleepDtoToCsv(HttpServletResponse response, Integer userNo) throws IOException {
//        try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8))) {
//            writer.writeNext(new String[]{"식별번호", "유저식별번호", "기록시간", "취침시간", "기상시간"});
//            List<Sleep> sleepList = walkRepository(userNo);
//            for (Walk entity : walkList) {
//                writer.writeNext(new String[]{
//                        String.valueOf(entity.getNo()),
//                        String.valueOf(entity.getUserNo()),
//                        entity.getCreatetime().toString(),
//                        String.valueOf(entity.getStepCount()),
//                        String.valueOf(entity.getDistance())
//                });
//            }
//            return response;
//        }
//    }
}
