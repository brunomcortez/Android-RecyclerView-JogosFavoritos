package com.brunocortez.jogosfavoritos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.brunocortez.jogosfavoritos.model.Jogo
import kotlinx.android.synthetic.main.jogo_item.view.*

class JogosAdapter(
    private val context: Context,
    private var jogos: List<Jogo> = listOf(),
    val listener: (Jogo) -> Unit
): RecyclerView.Adapter<JogosAdapter.JogoViewHolder>() {

    override fun getItemCount(): Int {
        return jogos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogoViewHolder {
        return JogoViewHolder(LayoutInflater.from(context).inflate(R.layout.jogo_item, parent, false))
    }

    override fun onBindViewHolder(holder: JogoViewHolder, position: Int) {
        holder.bindView(jogos[position], listener)
    }

    fun updateJogos(jogos: List<Jogo>) {
        this.jogos = jogos
        notifyDataSetChanged()
    }

    inner class JogoViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bindView(jogo: Jogo, listener: (Jogo) -> Unit) = with(view) {
            view.setOnClickListener { listener(jogo) }
            tvTitle.text = jogo.nome
            tvDate.text = "Lançamento: ${jogo.anoLancamento}"
            tvDescription.text = jogo.descricao
            ivIcon.setImageDrawable(ContextCompat.getDrawable(context, jogo.resourceId))
        }
    }
}