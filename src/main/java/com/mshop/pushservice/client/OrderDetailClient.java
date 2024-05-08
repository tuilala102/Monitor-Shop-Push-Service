package com.mshop.pushservice.client;

import com.mshop.pushservice.dto.OrderDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "OrderDetailClient", url = "${product-service.url}/order-detail")
public interface OrderDetailClient {

    @GetMapping("/order/{id}")
    List<OrderDetail> getOrderDetailByOrderId(@PathVariable("id") Long id);

}
