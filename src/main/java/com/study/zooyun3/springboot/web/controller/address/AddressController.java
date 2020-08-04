package com.study.zooyun3.springboot.web.controller.address;

import com.study.zooyun3.springboot.service.address.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/json/sido.json")
    public @ResponseBody
    List<String> sido() {
        return addressService.findSido();
    }

    @GetMapping("/json/sigungu{sido}.json")
    public @ResponseBody List<String> sigunguBySido(@PathVariable String sido) {
        return addressService.findSigunguBySido(sido);
    }

    @GetMapping("/json/andoopmien{sido}.json")
    public @ResponseBody List<String> oopmienBySido(@PathVariable String sido) {
        return addressService.findOopmienBySido(sido);
    }

    @GetMapping("/json/oopmien{sigungu}.json")
    public @ResponseBody List<String> oopmienBySigungu(@PathVariable String sigungu) {
        return addressService.findOopmienBySigungu(sigungu);
    }
}
