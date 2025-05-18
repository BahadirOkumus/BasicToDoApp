package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentAnaSayfaBinding
import com.example.todoapp.ui.adapter.GorevlerAdapter
import com.example.todoapp.ui.viewmodel.AnaSayfaViewModel
import com.example.todoapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnaSayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnaSayfaBinding
    private lateinit var viewModel: AnaSayfaViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAnaSayfaBinding.inflate(inflater,container,false)
        binding.fab.setOnClickListener {
            //Navigation.findNavController(it).navigate(R.id.gorevKayitGecis)
            Navigation.gecisYap(it,R.id.gorevKayitGecis)
        }
        viewModel.gorevlerListesi.observe(viewLifecycleOwner){
            val gorevlerAdapter = GorevlerAdapter(requireContext(),it,viewModel)
            binding.gorevlerRv.adapter=gorevlerAdapter
        }

        binding.gorevlerRv.layoutManager= LinearLayoutManager(requireContext())

        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {//harf girdikçe ve sildikçe çalışır
                viewModel.ara(newText.toString())
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {//ara butonuna basınca çalışır
                viewModel.ara(query.toString())
                return true

            }

        })

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val tempViewModel: AnaSayfaViewModel by viewModels()
            viewModel=tempViewModel
    }

    override fun onResume() {
        super.onResume()
        Log.e("Gorev anasayfaya","dönüldü")
    }
}