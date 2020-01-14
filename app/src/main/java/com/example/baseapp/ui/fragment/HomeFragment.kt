package com.example.baseapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.baseapp.R
import com.example.baseapp.databinding.FragmentHomeBinding
import com.example.baseapp.ui.adapter.RepoAdapter
import com.example.baseapp.util.InjectorUtils
import com.example.baseapp.viewmodel.HomeViewModel
import com.example.baseapp.vo.Resource.Status

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by viewModels {
        InjectorUtils.provideHomeViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        binding.recyclerViewRepos.adapter = RepoAdapter()

        viewModel.repos.observe(viewLifecycleOwner, Observer {
            if (it.state.status == Status.SUCCESS) {
                (binding.recyclerViewRepos.adapter as RepoAdapter).submitList(it.data)
            }
        })

        return binding.root
    }
}
