package com.example.snappfood.ui.fooddetail

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.snappfood.databinding.ActivityFoodBinding
import com.example.snappfood.models.Food

class FoodActivity : AppCompatActivity() {
    var food:Food?=null
    lateinit var bundel:Bundle
    lateinit var binding: ActivityFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bundel=intent.extras!!
        food  = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("food", Food::class.java)
        } else {
            intent.getParcelableExtra<Food>("food")
        }
    }
}