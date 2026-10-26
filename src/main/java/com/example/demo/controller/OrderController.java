package com.example.demo.controller;


import com.example.demo.dto.OrderRequest;
import com.example.demo.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// controller/OrderController.java
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Map<String, String> order(@Valid @RequestBody OrderRequest request) {
        String result = orderService.order(
                request.getMemberId(), request.getLines());
        return Map.of("message", result);
    }
}

// 쓰래드 라는 친구가 요청을 받아서 처리해줍니다.
// 쓰레드는 여러개입니다.
// 쓰레드는 여러개 이고 이미 생성되어서 준비되고 있습니다.
// 요청이 들어오면 대기하고 있던 쓰레드중에 하나가 할당됩니다.
// 내가 보낸 요청을 처음부터 끝까지 하나의 쓰레드에서 처리가 됩니다.