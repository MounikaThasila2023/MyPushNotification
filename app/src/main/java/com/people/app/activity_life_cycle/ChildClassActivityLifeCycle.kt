package com.people.app.activity_life_cycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.people.app.R

class ChildClassActivityLifeCycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child_class_life_cycle)
    }
}