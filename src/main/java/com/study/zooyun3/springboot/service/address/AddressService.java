package com.study.zooyun3.springboot.service.address;

import com.study.zooyun3.springboot.domain.address.AddressRepository;
import com.study.zooyun3.springboot.web.dto.address.AddressOoopmienRequestDto;
import com.study.zooyun3.springboot.web.dto.address.AddressSidoRequestDto;
import com.study.zooyun3.springboot.web.dto.address.AddressSigunguRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Transactional(readOnly = true)
    public List<AddressSidoRequestDto> findSido() {
        return addressRepository.findSido().stream().map(AddressSidoRequestDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<AddressSigunguRequestDto> findSigungu(String sido) {
        return addressRepository.findSigungu(sido).stream().map(AddressSigunguRequestDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<AddressOoopmienRequestDto> findOppmien(String sigundu) {
        return addressRepository.findOopmien(sigundu).stream().map(AddressOoopmienRequestDto::new).collect(Collectors.toList());
    }
}
