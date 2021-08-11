package com.meowsoft.callblocker.presentation.blocked

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.databinding.ActivityBlockedCallsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BlockedCallsActivity : AppCompatActivity() {

    private val viewModel: BlockedCallsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil
            .setContentView<ActivityBlockedCallsBinding>(
                this@BlockedCallsActivity,
                R.layout.activity_blocked_calls
            )
            .also {
                it.viewModel = viewModel
                it.lifecycleOwner = this@BlockedCallsActivity
            }
    }
}