package com.example.demo.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Slf4j
@Component("member")
@RequiredArgsConstructor
public class MemberHealthIndicator implements HealthIndicator {

    private final  MemberRepository memberRepository;

    @Override
    public Health health() {
        try{
            int count = memberRepository.count();

            return Health.up()
                    .withDetail("memberCount", count)
                    .withDetail("storage", "in-memory")
                    .build();

        } catch (Exception e) {
            log.error("회원 저장소 상태를 확인하세요");
            return Health.down()
                    .withDetail("reason", "회원 저장소에 접근할수없습니다.")
                    .build();
        }
    }
}



// actuator/health 를 수행하면

// 이에 관려된 컴포넌트 들에서 한번씩 메서드를 실행한다!