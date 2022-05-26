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
    public List<String> selectSido() {
        return addressRepository.selectSido().stream().map(String::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<String> selectSigunguBySido(String sido) {
        List<String> sigunguList;
        try {
            sigunguList = addressRepository.selectSigunguBySido(sido).stream().map(String::new).collect(Collectors.toList());
        } catch (NullPointerException e) {
            return null;
        }
        return sigunguList;
    }

    @Transactional(readOnly = true)
    public List<String> selectOopmienBySido(String sido) {
        List<String> oopmienList;
        try {
            oopmienList = addressRepository.selectOopmienBySido(sido).stream().map(String::new).collect(Collectors.toList());
        } catch (NullPointerException e) {
            return null;
        }
        return oopmienList;
    }

    @Transactional(readOnly = true)
    public List<String> selectOopmienBySigungu(String sigundu) {
        List<String> oopmienList;
        try {
            oopmienList = addressRepository.selectOopmienBySigungu(sigundu).stream().map(String::new).collect(Collectors.toList());
        } catch (NullPointerException e) {
            return null;
        }
        return oopmienList;
    }
}
