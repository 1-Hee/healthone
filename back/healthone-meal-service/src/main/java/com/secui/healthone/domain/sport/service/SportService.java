package com.secui.healthone.domain.sport.service;

import com.secui.healthone.domain.sport.dto.SportMapper;
import com.secui.healthone.domain.sport.dto.SportResDto;
import com.secui.healthone.domain.sport.entity.Sport;
import com.secui.healthone.domain.sport.repository.SportRepository;
import com.secui.healthone.global.error.errorcode.CustomErrorCode;
import com.secui.healthone.global.error.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SportService {

    private final SportRepository sportRepository;

    private final SportMapper sportMapper;

    // 운동데이터 가져오기
    public List<SportResDto> searchSport(String name) {
        List<Sport> result = sportRepository.findAllByNameContaining(name);
        return sportMapper.sportToSportResListDto(result);
    }

    // 운동 데이터 단건 조회
    public SportResDto getSport(Integer no) {
        Optional<Sport> result = sportRepository.findById(no);
        return sportMapper.sportToSportResDto(result.orElseThrow(()-> new RestApiException(CustomErrorCode.DB_100)));
    }
}
