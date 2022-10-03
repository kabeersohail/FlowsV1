package com.example.flows.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.flows.databinding.FragmentLaunchBinding
import com.example.flows.viewmodels.LaunchViewModel
import kotlinx.coroutines.launch


class LaunchFragment : Fragment() {

    private lateinit var binding: FragmentLaunchBinding
    private val viewModel: LaunchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLaunchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.adminLock.setOnClickListener {
            viewModel.squareNumber(3)
        }

        lifecycleScope.launch {
            viewModel.sharedFlow.collect {
                binding.updateText.text = it.toString()
            }
        }
    }

}