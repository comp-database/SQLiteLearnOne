package com.example.sqlitelearnone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlitelearnone.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.AddBtn.setOnClickListener {
            CustomerModel(-1,binding.name.text.toString(),binding.Age.text)
            Toast.makeText(this, "${CustomerModel(-1,binding.name.text.toString(),binding.Age.text)}", Toast.LENGTH_SHORT).show()

            val dbHelper = DataBaseHelper(this)

        }

        binding.ViewallBtn.setOnClickListener {
            binding.List.addHeaderView(binding.name)
        }
    }
}