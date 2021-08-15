package com.meowsoft.callblocker.presentation.filters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.databinding.FragmentFiltersBinding
import com.meowsoft.callblocker.presentation.common.RvSupplier
import com.meowsoft.callblocker.presentation.filters.list.FiltersListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FiltersFragment : Fragment() {

    private val viewModel: FiltersViewModel by viewModel()

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

        val binding = DataBindingUtil.inflate<FragmentFiltersBinding>(
            inflater,
            R.layout.fragment_filters,
            container,
            false
        ).also {
            it.viewModel = viewModel
            it.lifecycleOwner = viewLifecycleOwner
            it.filtersRvSupplier = RvSupplier(
                FiltersListAdapter(),
                layoutManager
            )
        }

        return binding.root
    }

    companion object{
        fun getInstance() = FiltersFragment()
    }
}