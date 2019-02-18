package com.bao.jatpack

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bao.jatpack.ui.binding.BindingFragment

class BindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.binding_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, BindingFragment.newInstance())
                    .commitNow()
        }
    }
}