package com.mshop.pushservice.client;

import com.mshop.pushservice.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "UserClient", url = "${auth-service.url}")
public interface UserClient {

    @GetMapping("/users/exist-by-user-id")
    Boolean existsById(@RequestParam("userId") Long userId);

    @GetMapping("/users/exist-by-email")
    Boolean existsByEmail(@RequestParam("email") String email);

    @GetMapping("/users/{id}")
    User getOne(@PathVariable("id") Long id);

}
