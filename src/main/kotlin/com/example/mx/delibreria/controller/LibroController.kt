package com.example.mx.delibreria.controller

import com.example.mx.delibreria.entidades.Libro
import com.example.mx.delibreria.interfaz.ILibro
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong
import javax.validation.Valid

@RestController
class LibroController(@Autowired val repository: ILibro){

    //val counter = AtomicLong()
    @GetMapping("/books")
    fun getAllLibros(): List<Libro> =
            repository.findAll()

    @PostMapping("/books")
    fun createBooks(@Valid @RequestBody libro : Libro):Libro=
            repository.save(libro)



    @PutMapping("/books/{id}")
    fun updateArticleById(@PathVariable(value = "id") libroId: Long,
                          @Valid @RequestBody newLibro: Libro): ResponseEntity<Libro> {

        return repository.findById(libroId).map { existingLibro->
            val updatedArticle: Libro = existingLibro
                    .copy(titulo = newLibro.titulo, genero = newLibro.genero)
            ResponseEntity.ok().body(repository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/books/{id}")
    fun deleteArticleById(@PathVariable(value = "id") libroId: Long): ResponseEntity<Void> {

        return repository.findById(libroId).map { libro  ->
            repository.delete(libro)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }
}



