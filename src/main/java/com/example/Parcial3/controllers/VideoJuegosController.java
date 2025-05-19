package com.example.Parcial3.controllers;

import com.example.Parcial3.entities.VideoJuegosEntity;
import com.example.Parcial3.service.VideoJuegosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/videojuegos")
public class VideoJuegosController {

    private final VideoJuegosService videoJuegosService;

    @Autowired
    public VideoJuegosController(VideoJuegosService videoJuegosService) {
        this.videoJuegosService = videoJuegosService;
    }

    // Listar con paginación
    @GetMapping
    public ResponseEntity<?> getAllVideoJuegos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return videoJuegosService.getAllVideoJuegos(pageable);
    }

    // Buscar por título
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorTitulo(
            @RequestParam String titulo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return videoJuegosService.buscarPorTitulo(titulo, pageable);
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getVideoJuegoById(@PathVariable String id) {
        return videoJuegosService.getVideoJuegoById(id);
    }

    // Crear
    @PostMapping
    public ResponseEntity<?> createVideoJuego(@RequestBody VideoJuegosEntity videoJuegosEntity) {
        return videoJuegosService.createVideoJuego(videoJuegosEntity);
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> updateVideoJuego(@PathVariable String id, @RequestBody VideoJuegosEntity videoJuegosEntity) {
        return videoJuegosService.updateVideoJuego(id, videoJuegosEntity);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVideoJuego(@PathVariable String id) {
        return videoJuegosService.deleteVideoJuego(id);
    }

    // Todos sin paginación
    @GetMapping("/todos")
    public ResponseEntity<?> obtenerTodosSinPaginacion() {
        return videoJuegosService.obtenerTodosSinPaginacion();
    }
}
