package com.example.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentKayitBinding
import com.example.todoapp.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: KayitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentKayitBinding.inflate(inflater,container,false)
        binding.buttonKaydet.setOnClickListener {
            val kisi_ad=binding.editTextGorevAd.text.toString()
            val kisi_tel=binding.editTextGorevIcerigi.text.toString()
            viewModel.kaydet(kisi_ad,kisi_tel)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KayitViewModel by viewModels()
        viewModel=tempViewModel
    }
}