package com.example.mx.delibreria.entidades

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
@Entity
data class Libro (
                  val titulo:String,
                  val genero:String,
                  @Id @GeneratedValue (strategy = GenerationType.AUTO)
                  val id:Long=-1)

{
 constructor():this("","")
}