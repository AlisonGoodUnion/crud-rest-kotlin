package com.example.demo.entity

//no Kotlin já é gerato automaticamente construtores, getters e setters.
// Para o Spring funcionar devemos utilizar a 'data' class.
data class Conta(
        val id: String? = null, // atributo tipo string que pode ser null
        val nome: String, //Obrigatorio
        val documento: String,
        val saldo: Long? = 0
)
