package com.study.zooyun3.springboot.domain.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("SELECT sido FROM Address GROUP BY sido")
    List<String> selectSido();

    @Query("SELECT sigungu FROM Address WHERE sido = :sido GROUP BY sigungu")
    List<String> selectSigunguBySido(@Param("sido") String sido);

    @Query("SELECT oopmien FROM Address WHERE sido = :sido AND NOT oopmien IS NULL GROUP BY oopmien")
    List<String> selectOopmienBySido(@Param("sido") String sido);

    @Query("SELECT oopmien  FROM Address WHERE sigungu = :sigungu GROUP BY oopmien")
    List<String> selectOopmienBySigungu(@Param("sigungu") String sigungu);
}
