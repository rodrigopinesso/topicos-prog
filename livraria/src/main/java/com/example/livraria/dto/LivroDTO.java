package com.example.livraria.dto;

import com.example.livraria.enums.Genero;

public record LivroDTO(String titulo, String autor, Genero genero) {
}
