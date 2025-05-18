package com.example.todoapp.ui.fragment


import android.content.Context

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentDetayBinding
import com.example.todoapp.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetayBinding.inflate(inflater,container,false)

        val bundle: DetayFragmentArgs by navArgs()
        val gelenGorev= bundle.gorev

        binding.editTextGorevAd.setText(gelenGorev.gorev_ad)
        binding.editTextGorevIcerigi.setText(gelenGorev.gorev_detay)

        binding.buttonGuncelle.setOnClickListener {
            val gorev_ad = binding.editTextGorevAd.text.toString()
            val gorev_detay = binding.editTextGorevIcerigi.text.toString()
            viewModel.guncelle(gelenGorev.gorev_id, gorev_ad , gorev_detay)
        }
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetayViewModel by viewModels()
        viewModel=tempViewModel
    }
}
