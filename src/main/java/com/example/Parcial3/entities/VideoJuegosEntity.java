package com.example.Parcial3.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "videojuegos")
public class VideoJuegosEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;
    //= UUID.randomUUID().toString();


    @Column(unique = true)
    @NotBlank
    @Size(min = 2, max = 100)
    private String titulo;


    @Column(name = "anio_lanzamiento")
    @Min(1900)
    @Max(2099)
        private int anioLanzamiento;

    @NotBlank
    private String plataforma;

    @Column(name = "duracion_horas")
    @Min(2)
    private int duracionHoras;
    /*
    @Version
    private Integer version = 0; // Establecer un valor predeterminado*/


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }
}