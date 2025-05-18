package com.example.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.entity.Gorevler
import com.example.todoapp.databinding.CardTasarimBinding
import com.example.todoapp.ui.fragment.AnaSayfaFragmentDirections
import com.example.todoapp.ui.viewmodel.AnaSayfaViewModel
import com.example.todoapp.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class GorevlerAdapter(var mContext: Context ,
                      var gorevlerListesi: List<Gorevler>,
                      var viewModel: AnaSayfaViewModel)
    : RecyclerView.Adapter<GorevlerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(tasarim)

    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val gorev = gorevlerListesi.get(position)
        val t=holder.tasarim
        t.textViewGorevAd.text = gorev.gorev_ad
        t.textViewGorevDetay.text = gorev.gorev_detay

        t.cardViewSatir.setOnClickListener {
            val gecis = AnaSayfaFragmentDirections.gorevDetayGecis(gorev=gorev)
            Navigation.gecisYap(it,gecis)
        }
        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${gorev.gorev_ad} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    viewModel.sil(gorev.gorev_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return gorevlerListesi.size
    }
}