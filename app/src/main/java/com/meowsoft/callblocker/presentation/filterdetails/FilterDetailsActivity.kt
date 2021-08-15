package com.meowsoft.callblocker.presentation.filterdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.databinding.ActivityFilterDetailsBinding
import com.meowsoft.callblocker.presentation.filterdetails.adapter.FilterTypeSpinnerAdapter
import com.meowsoft.callblocker.presentation.filterdetails.event.OutputEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilterDetailsActivity : AppCompatActivity() {

    private val viewModel: FilterDetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil
            .setContentView<ActivityFilterDetailsBinding>(
                this@FilterDetailsActivity,
                R.layout.activity_filter_details
            )
            .also {
                it.viewModel = viewModel
                it.spinnerAdapter = FilterTypeSpinnerAdapter(this@FilterDetailsActivity)
                it.lifecycleOwner = this@FilterDetailsActivity
            }

        setupObservers()
    }

    private fun setupObservers(){
        viewModel.outputEvent.observe(this) { event ->
            when(event){
                OutputEvent.FilterCreatedEvent -> finish()
            }
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(
                Intent(
                    context,
                    FilterDetailsActivity::class.java
                )
            )
        }
    }
}