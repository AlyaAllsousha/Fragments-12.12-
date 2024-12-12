package ru.example.a1212

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ru.example.a1212.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var state:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        val fragment = BlankFragment()
        supportFragmentManager.beginTransaction().add(R.id.FrameLayout, fragment).commit()
        binding.btn.setOnClickListener {
            when(state){
                2 -> {
                    val fragment = BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.FrameLayout, fragment).commit()
                }
                1  ->{
                    val fragment2 = BlankFragment2.newInstance("Math", 5)
                    supportFragmentManager.beginTransaction().replace(R.id.FrameLayout, fragment2).commit()
                }
                0 ->{
                    val fragment3 = SettingsFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.FrameLayout, fragment3).commit()
                }
                else ->{

                }
            }
            state = (state +1) % 3
        }
    }
}