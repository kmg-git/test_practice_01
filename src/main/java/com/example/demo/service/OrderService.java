package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.domain.Product;
import com.example.demo.dto.OrderLineRequest;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.MemberNotFoundException;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

// service/OrderService.java
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    public String order(Long memberId, List<OrderLineRequest> lines) {

        log.info("주문 요청 memberId = {}, 품목수 = {}", memberId, lines.size());

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        // 총 금액
        int totalPrice = 0;

        // 반복문을 통해서 여려개의 상품 목록을 조회 할 예정이다!

        for(OrderLineRequest line : lines) {

            Product product = productRepository.findById(line.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException(ErrorCode.PRODUCT_NOT_FOUND));

            log.info("재고 확인 productId = {}, 현재재고 = {}, 요청 = {}", product.getId(), product.getStock(), line.getQuantity());

            product.removeStock(line.getQuantity());

            totalPrice += product.getPrice() * line.getQuantity();

        }


        log.info("주문 완료 memberId = {}, 품목수 = {}, 총액 = {}", memberId, lines.size(), totalPrice);


        return member.getName() + "님이 " + lines.size() + "개 품목을 주문했습니다. 총 가격은 : " + totalPrice;
    }
}

// 코드는 이 친구대로 실행이 되는것입니다.
// 장애가 발생했다고합니다.
// 요청을 보내면 그 요청을 하나의 쓰레드가 받아서 끝까지 처리한다고 말씀드렸죠?

