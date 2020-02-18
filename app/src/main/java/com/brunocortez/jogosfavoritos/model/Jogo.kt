package com.brunocortez.jogosfavoritos.model

data class Jogo(
    val nome: String,
    val resourceId: Int,
    val anoLancamento: Int,
    val descricao: String
)