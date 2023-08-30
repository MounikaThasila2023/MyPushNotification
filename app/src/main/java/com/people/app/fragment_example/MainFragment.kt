package com.people.app.fragment_example

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.people.app.R
import com.people.app.databinding.MainFragmentBinding

class MainFragment: AppCompatActivity() {

    lateinit var binding: MainFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("MainFragment", "onCreate")

        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = FragmentLifeCycle()

        binding.toFragment.setOnClickListener {
            Log.e("MainFragment", "onCreate setOnClickListener")
                mFragmentTransaction.replace(R.id.main_frameLayout, mFragment).commit()
        }
    }
}