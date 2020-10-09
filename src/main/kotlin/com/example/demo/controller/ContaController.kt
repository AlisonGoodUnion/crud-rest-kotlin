package com.example.demo.controller

import com.example.demo.entity.Conta
import com.example.demo.repository.ContaRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("contas")
class ContaController(val repository: ContaRepository) {


// Ex: mais proximo ao java
//    @PostMapping
//    fun create(@RequestBody conta: Conta): ResponseEntity<Conta> { //annotation request body faz o match do json com o objeto conta.
//        var contaSave = repository.save(conta)
//        return ResponseEntity.ok(contaSave)
//    }

    //Kotlin nos prove ex: metodo feito em uma linha :)
    @PostMapping
    fun create(@RequestBody conta: Conta) = ResponseEntity.ok(repository.save(conta))

    @GetMapping
    fun read() = ResponseEntity.ok(repository.findAll())

    @PutMapping("{documento}")
    fun read(@PathVariable documento: String, @RequestBody conta: Conta): ResponseEntity<Conta> {
        val contaAlterada = repository.findByDocumento(documento)
                .orElseThrow { RuntimeException("Conta documento: $documento não existente") }
                .copy(nome = conta.nome, saldo = conta.saldo, documento = conta.documento)

        return ResponseEntity.ok(repository.save(contaAlterada))
    }

    @DeleteMapping("{documento}")
    fun delete(@PathVariable documento: String): ResponseEntity<Unit> {
        val contaExcluida = repository
                .findByDocumento(documento)
                .orElseThrow {RuntimeException("Conta documento: $documento não existente")};

        return ResponseEntity.ok(repository.delete(contaExcluida))
    }
}
