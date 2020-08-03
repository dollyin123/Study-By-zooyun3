package com.study.zooyun3.springboot.service.address;

import com.study.zooyun3.springboot.domain.address.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Transactional(readOnly = true)
    public List<String> findSido() {
        return addressRepository.findSido().stream().map(String::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<String> findSigunguBySido(String sido) {
        List<String> sigunguList;
        try {
            sigunguList = addressRepository.findSigunguBySido(sido).stream().map(String::new).collect(Collectors.toList());
        } catch (NullPointerException e) {
            return null;
        }
        return sigunguList;
    }

    @Transactional(readOnly = true)
    public List<String> findOopmienBySido(String sido) {
        List<String> oopmienList;
        try {
            oopmienList = addressRepository.findOopmienBySido(sido).stream().map(String::new).collect(Collectors.toList());
        } catch (NullPointerException e) {
            return null;
        }
        return oopmienList;
    }

    @Transactional(readOnly = true)
    public List<String> findOopmienBySigungu(String sigundu) {
        List<String> oopmienList;
        try {
            oopmienList = addressRepository.findOopmienBySigungu(sigundu).stream().map(String::new).collect(Collectors.toList());
        } catch (NullPointerException e) {
            return null;
        }
        return oopmienList;
    }
}
