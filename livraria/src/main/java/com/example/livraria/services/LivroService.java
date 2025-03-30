package com.example.livraria.services;

import com.example.livraria.dto.LivroDTO;
import com.example.livraria.models.Livro;
import com.example.livraria.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public Livro criarLivro(LivroDTO dto) {
        Livro livro = new Livro(null, dto.titulo(), dto.autor(), dto.genero());
        return livroRepository.save(livro);
    }

    public Livro atualizarLivro(Long id, LivroDTO dto) {
        Livro livro = buscarPorId(id);
        livro.setTitulo(dto.titulo());
        livro.setAutor(dto.autor());
        livro.setGenero(dto.genero());
        return livroRepository.save(livro);
    }

    public void deletarLivro(Long id) {
        Livro livro = buscarPorId(id);
        livroRepository.delete(livro);
    }
}
