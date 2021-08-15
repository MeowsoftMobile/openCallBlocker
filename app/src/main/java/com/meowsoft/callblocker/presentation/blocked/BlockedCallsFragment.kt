package com.meowsoft.callblocker.presentation.blocked

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.databinding.FragmentBlockedCallsBinding
import com.meowsoft.callblocker.presentation.blocked.list.BlockedCallsAdapter
import com.meowsoft.callblocker.presentation.common.RvSupplier
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class BlockedCallsFragment : Fragment() {

    private val viewModel: BlockedCallsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )

        val binding = DataBindingUtil.inflate<FragmentBlockedCallsBinding>(
            inflater,
            R.layout.fragment_blocked_calls,
            container,
            false
        ).also {
            it.viewModel = viewModel
            it.lifecycleOwner = viewLifecycleOwner
            it.callLogsRvSupplier = RvSupplier(
                BlockedCallsAdapter(),
                layoutManager
            )
        }

        return binding.root
    }

    companion object {
        fun getInstance() = BlockedCallsFragment()
    }
}