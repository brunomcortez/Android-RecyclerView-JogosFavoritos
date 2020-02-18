package com.brunocortez.jogosfavoritos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.brunocortez.jogosfavoritos.model.Jogo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: JogosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = JogosAdapter(this) { jogoPressed(it) }
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        adapter.updateJogos(carregaJogos())
    }

    private fun jogoPressed(jogo: Jogo) {

    }

    private fun carregaJogos(): List<Jogo> {
        return listOf(
            cod(),
            sot(),
            godOfWar()
        )
    }

    private fun godOfWar(): Jogo {
        return Jogo(
            "God Of War",
            R.drawable.jogo_1,
            2018,
            "bla bla bla"
        )
    }

    private fun cod(): Jogo {
        return Jogo(
            "Call Of Duty",
            R.drawable.jogo_2,
            2019,
            "bla bla bla"
        )
    }

    private fun sot(): Jogo {
        return Jogo(
            "Sea Of Thieves",
            R.drawable.jogo_3,
            2019,
            "bla bla bla"
        )
    }
}
