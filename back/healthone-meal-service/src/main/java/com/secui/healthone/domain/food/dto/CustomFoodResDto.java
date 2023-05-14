package com.secui.healthone.domain.food.dto;

import com.secui.healthone.domain.food.entity.CustomFood;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(description = "사용자 음식 응답 DTO")
public class CustomFoodResDto {
    @Schema(description = "사용자 음식 식별번호")
    private Integer no;
    @Schema(description = "회원 식별번호")
    private Integer userNo;
    @Schema(description = "사용자 음식 이름")
    @NotNull(message = "음식 이름은 null 일 수 없습니다.")
    private String name;
    @Schema(description = "사용자 음식 1인분당 칼로리")
    @NotNull(message = "음식 1인분당 칼로리는 null 일 수 없습니다.")
    private Integer kcal;
    @Schema(description = "사용자 음식 1인분당 그램 수")
    @NotNull(message = "음식 1인분당 그램수는 null 일 수 없습니다.")
    private Float gram;

    @Builder
    public CustomFoodResDto(CustomFood entity) {
        this.no = entity.getNo();
        this.userNo = entity.getUserNo();
        this.name = entity.getName();
        this.kcal = entity.getKcal();
        this.gram = entity.getGram();
    }
}
