package com.study.zooyun3.springboot.web.dto.address;

import com.study.zooyun3.springboot.domain.address.Address;
import lombok.Getter;

@Getter
public class AddressSidoRequestDto {
    public String sido;

    public AddressSidoRequestDto(Address entity) {
        this.sido = entity.getSido();
    }
}
