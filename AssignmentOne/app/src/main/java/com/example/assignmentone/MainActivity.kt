package com.example.assignmentone

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.assignmentone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    var count = 10;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.buttonToast.setOnClickListener {
            Toast.makeText(applicationContext,"Hello "
            .plus(binding.textViewNumber.text.toString()),Toast.LENGTH_SHORT).show()
        }

        binding.textViewNumber.text = count.toString()

        binding.buttonCountDown.setOnClickListener {
            --count
            binding.textViewNumber.text = count.toString()
        }

        binding.buttonCountUp.setOnClickListener {
            ++count
            binding.textViewNumber.text = count.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val number : Int = count
        outState.putInt("savedInt",number)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val number :Int = savedInstanceState.getInt("savedInt",10)
        count = number
        binding.textViewNumber.text = count.toString()
    }

}