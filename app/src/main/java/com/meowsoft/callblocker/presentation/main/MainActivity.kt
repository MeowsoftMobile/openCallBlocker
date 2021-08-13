package com.meowsoft.callblocker.presentation.main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.databinding.ActivityMainBinding
import com.meowsoft.callblocker.infrastructure.MenuConfig
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
                it.lifecycleOwner = this@MainActivity
            }

        view_pager.adapter = ViewPagerAdapter()
        view_pager.currentItem = 0

        view_pager.registerOnPageChangeCallback( object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottom_nav.selectedItemId = MenuConfig.getByPage(position).id
            }
        })

        bottom_nav.setOnItemSelectedListener { menuItem ->

            val pageNumber = MenuConfig.getById(menuItem.itemId).number
            view_pager.currentItem = pageNumber

            true
        }
    }
}