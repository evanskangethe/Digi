package com.example.digifarm.resources;

import com.example.digifarm.repository.OrderRepository;
import com.example.digifarm.repository.entity.Order;
import com.example.digifarm.wrapper.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private  OrderRepository orderRepository;


    @PostMapping(value = "/create")
    public ResponseEntity<ResponseWrapper<Order>> create(Order order){
        ResponseWrapper wrapper = new ResponseWrapper();
        wrapper.setData(orderRepository.save(order));
        wrapper.setCode(HttpStatus.OK.value());
        wrapper.setMessage("Order Created Successfully");

        return ResponseEntity.ok(wrapper);
    }
}
