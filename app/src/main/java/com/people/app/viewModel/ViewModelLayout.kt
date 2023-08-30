package com.people.app.viewModel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.people.app.databinding.ActivityViewModelLayoutBinding

class ViewModelLayout : AppCompatActivity() {

    private lateinit var binding: ActivityViewModelLayoutBinding
    private lateinit var viewModel: SampleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[SampleViewModel::class.java]

        viewModel.count.observe(this) { value ->
            binding.counterText.text = "$value"
        }

        binding.incrementBtn.setOnClickListener {
            viewModel.incrementCounter()
        }
    }
}