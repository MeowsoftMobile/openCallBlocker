package com.meowsoft.callblocker.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.databinding.ActivityMainBinding
import com.meowsoft.callblocker.presentation.main.viewpager.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(){

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil
            .setContentView<ActivityMainBinding>(
                this@MainActivity,
                R.layout.activity_main
            )
            .also {
                it.viewModel = viewModel
                it.pageAdapter = ViewPagerAdapter()
                it.lifecycleOwner = this@MainActivity
            }
    }
}