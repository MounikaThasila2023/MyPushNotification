package com.people.app.activity_life_cycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.people.app.R
import com.people.app.databinding.ActivityMainClassLifeCycleBinding
import com.people.app.fragment_example.FragmentLifeCycle


class MainClassActivityLifeCycle : AppCompatActivity() {

    private lateinit var binding: ActivityMainClassLifeCycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainClassLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e("Activity LifeCycle", "-----------This is onCreate child method")

        binding.clickMe.setOnClickListener {
            Log.e("Activity LifeCycle", "the button is clicked on OnCreate")
            val intent = Intent(this, ChildClassActivityLifeCycle::class.java)
            startActivity(intent)
        }

        val transaction = supportFragmentManager.beginTransaction()
        val mFragment = FragmentLifeCycle()
        binding.fragmentLifecycle.setOnClickListener {
            transaction.replace(R.id.frame_layout, mFragment).commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("Activity LifeCycle", "-----------This is onStart child method")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Activity LifeCycle", "-----------This is onResume child method")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Activity LifeCycle", "-----------This is onPause child method")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Activity LifeCycle", "-----------This is onStop child method")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("Activity LifeCycle", "-----------This is onRestart child method")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Activity LifeCycle", "-----------This is onDestroy child method")
    }
}