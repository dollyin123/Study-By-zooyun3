package com.study.zooyun3.springboot.domain.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("SELECT p FROM Address p GROUP BY p.sido")
    List<Address> findSido();

    @Query("SELECT sigungu FROM Address WHERE sido = :sido GROUP BY sigungu")
    List<Address> findSigungu(@Param("sido") String sido);

    @Query("SELECT oopmien  FROM Address WHERE sigungu = :sigungu GROUP BY oopmien")
    List<Address> findOopmien(@Param("sigungu") String sigungu);
}
