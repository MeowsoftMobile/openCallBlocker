package com.meowsoft.callblocker.infrastructure

import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.domain.MenuPage

class MenuConfig {
    companion object{

        private val menu = listOf(
            MenuPage(
                0,
                R.id.action_blocked_list,
                R.layout.view_blocked_calls,
                "Blocked"
            ),
            MenuPage(
                1,
                R.id.action_filters,
                R.layout.view_filters,
                "Filters"
            ),
            MenuPage(
                2,
                R.id.third,
                R.layout.view_filters,
                "Third"
            )
        )

        val count: Int
            get() = menu.size

        fun getByPage(page: Int) = menu[page]
        fun getById(id: Int) = menu.first { it.id == id }
    }
}
