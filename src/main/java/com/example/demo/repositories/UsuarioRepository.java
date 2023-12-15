package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface UsuarioRepository extends JpaRepository<User, Long> {

    @Query("SELECT new com.example.demo.DTO.DTOINDIC.UserCountDTO(count(u.id)) FROM User u")
    Long getTotalUsuariosCount();

}
