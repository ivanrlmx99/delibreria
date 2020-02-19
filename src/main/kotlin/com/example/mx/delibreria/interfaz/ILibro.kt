package com.example.mx.delibreria.interfaz

import com.example.mx.delibreria.entidades.Libro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository



@Repository
interface ILibro: JpaRepository<Libro,Long>{



}