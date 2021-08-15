package com.meowsoft.callblocker.presentation.blocked

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.meowsoft.callblocker.R

class BlockedCallsFragment : Fragment() {

    companion object{
        fun getInstance() = BlockedCallsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blocked_calls, container, false)
    }
}