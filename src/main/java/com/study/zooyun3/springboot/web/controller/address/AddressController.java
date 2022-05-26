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

    @GetMapping("/json/getSido.json")
    public @ResponseBody
    List<String> selectSido() {
        return addressService.selectSido();
    }

    @GetMapping("/json/getSigungu{sido}.json")
    public @ResponseBody List<String> selectSigunguBySido(@PathVariable String sido) {
        return addressService.selectSigunguBySido(sido);
    }

    @GetMapping("/json/getOopmienBySido{sido}.json")
    public @ResponseBody List<String> selectOopmienBySido(@PathVariable String sido) {
        return addressService.selectOopmienBySido(sido);
    }

    @GetMapping("/json/getOopmienBySigungu{sigungu}.json")
    public @ResponseBody List<String> selectOopmienBySigungu(@PathVariable String sigungu) {
        return addressService.selectOopmienBySigungu(sigungu);
    }
}
