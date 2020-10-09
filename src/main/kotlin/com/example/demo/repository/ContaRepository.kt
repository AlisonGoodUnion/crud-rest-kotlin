package com.example.demo.repository

import com.example.demo.entity.Conta
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

//interface, camada de persistencia.
@Repository
interface ContaRepository : MongoRepository<Conta, String> {
    fun findByDocumento(documento: String): Optional<Conta> //sempre importar o optional do java util
}
