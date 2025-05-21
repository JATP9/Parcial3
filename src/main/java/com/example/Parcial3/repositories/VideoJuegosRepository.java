package com.example.Parcial3.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Parcial3.entities.VideoJuegosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface VideoJuegosRepository extends JpaRepository<VideoJuegosEntity, String> {
    // Paginación basada en coincidencia parcial del título
    Page<VideoJuegosEntity> findAllByTituloContaining(String titulo, Pageable pageable);

    // Búsqueda simple sin paginación
    List<VideoJuegosEntity> findAllByTituloContaining(String titulo);

    // Verificación exacta por título (sin distinción entre mayúsculas y minúsculas)
    Optional<VideoJuegosEntity> findByTituloIgnoreCase(String titulo);
}