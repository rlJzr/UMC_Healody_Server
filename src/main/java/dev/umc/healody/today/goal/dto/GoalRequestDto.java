package dev.umc.healody.today.goal.dto;

import dev.umc.healody.today.goal.Goal;
import dev.umc.healody.today.goal.type.Behavior;
import dev.umc.healody.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @NoArgsConstructor
public class GoalRequestDto {

    private Long userId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private Behavior behavior;
    private String value;

    public Goal toEntity(User user) {

        // 시작 날짜, 종료 날짜 계산
        startDate = LocalDate.now();
        endDate = LocalDate.of(startDate.getYear(), startDate.getMonth(), startDate.lengthOfMonth());

        return Goal.builder()
                .user(user)
                .startDate(startDate)
                .endDate(endDate)
                .behavior(behavior)
                .value(value)
                .build();
    }
}
