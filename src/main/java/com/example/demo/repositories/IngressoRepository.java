package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.DTOINDIC.IngressoCountDTO;
import com.example.demo.DTO.DTOINDIC.ValorCountDTO;
import com.example.demo.models.Ingresso;

import java.util.List;
 
@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Long> {

    List<Ingresso> findByUser_id(Long id);

    @Query(value = "SELECT i FROM Ingresso i WHERE i.user.id = :user_id")
    List<Ingresso> findPeloUserID(@Param("user_id") Long id);

    @Query("SELECT new com.example.demo.DTO.DTOINDIC.IngressoCountDTO(count(i.id)) FROM Ingresso i")
    IngressoCountDTO countTotalIngressos();

    @Query("SELECT new com.example.demo.DTO.DTOINDIC.IngressoValorTotalDTO(sum(i.valor)) FROM Ingresso i")
    ValorCountDTO sumTotalValorIngressos();
    
}