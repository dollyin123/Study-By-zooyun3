package com.study.zooyun3.springboot.web.dto.address;

import com.study.zooyun3.springboot.domain.address.Address;
import lombok.Getter;

@Getter
public class AddressOoopmienRequestDto {
    public String oopmien;

    public AddressOoopmienRequestDto(Address entity) {
        this.oopmien = entity.getOopmien();
    }
}