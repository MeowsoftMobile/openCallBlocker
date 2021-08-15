package com.meowsoft.callblocker.presentation.blocked

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.databinding.FragmentBlockedCallsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BlockedCallsFragment : Fragment() {

    private val viewModel: BlockedCallsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentBlockedCallsBinding>(
            inflater,
            R.layout.fragment_blocked_calls,
            container,
            false
        ).also {
            it.viewModel = viewModel
            it.lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    companion object{
        fun getInstance() = BlockedCallsFragment()
    }
}