package com.example.Parcial3.service;


import com.example.Parcial3.entities.VideoJuegosEntity;
import com.example.Parcial3.repositories.VideoJuegosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VideoJuegosService {

    private final VideoJuegosRepository videoJuegosRepository;

    @Autowired
    public VideoJuegosService(VideoJuegosRepository videoJuegosRepository) {
        this.videoJuegosRepository = videoJuegosRepository;
    }

    // Obtener todos con paginación
    public ResponseEntity<?> getAllVideoJuegos(Pageable pageable) {
        Page<VideoJuegosEntity> page = videoJuegosRepository.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    // Buscar por título con paginación
    public ResponseEntity<?> buscarPorTitulo(String titulo, Pageable pageable) {
        Page<VideoJuegosEntity> page = videoJuegosRepository.findAllByTituloContaining(titulo, pageable);
        return ResponseEntity.ok(page);
    }

    // Obtener por ID
    public ResponseEntity<?> getVideoJuegoById(String id) {
        Optional<VideoJuegosEntity> optional = videoJuegosRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Videojuego no encontrado");
        }
    }

    // Crear videojuego (ignorando el ID que venga)
    public ResponseEntity<?> createVideoJuego(VideoJuegosEntity videoJuegosEntity) {
        videoJuegosEntity.setId(null); // Ignorar ID para que se genere uno nuevo
        VideoJuegosEntity saved = videoJuegosRepository.save(videoJuegosEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Actualizar videojuego
    public ResponseEntity<?> updateVideoJuego(String id, VideoJuegosEntity videoJuegosEntity) {
        Optional<VideoJuegosEntity> optional = videoJuegosRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Videojuego no encontrado");
        }

        VideoJuegosEntity existente = optional.get();

        // Actualizar campos permitidos
        existente.setTitulo(videoJuegosEntity.getTitulo());
        existente.setAnioLanzamiento(videoJuegosEntity.getAnioLanzamiento());
        existente.setPlataforma(videoJuegosEntity.getPlataforma());
        existente.setDuracionHoras(videoJuegosEntity.getDuracionHoras());

        VideoJuegosEntity updated = videoJuegosRepository.save(existente);
        return ResponseEntity.ok(updated);
    }

    // Eliminar videojuego
    public ResponseEntity<?> deleteVideoJuego(String id) {
        Optional<VideoJuegosEntity> optional = videoJuegosRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Videojuego no encontrado");
        }

        videoJuegosRepository.deleteById(id);
        return ResponseEntity.ok("Videojuego eliminado correctamente");
    }

    // Obtener todos sin paginación
    public ResponseEntity<?> obtenerTodosSinPaginacion() {
        List<VideoJuegosEntity> lista = videoJuegosRepository.findAll();
        return ResponseEntity.ok(lista);
    }
}