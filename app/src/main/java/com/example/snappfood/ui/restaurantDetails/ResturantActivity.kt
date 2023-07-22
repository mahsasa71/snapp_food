package com.example.snappfood.ui.restaurantDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.snappfood.databinding.ActivityResturantBinding
import com.example.snappfood.models.Resturant

class ResturantActivity : AppCompatActivity() {
    var restaurant: Resturant?=null
    lateinit var bundel:Bundle

    lateinit var binding: ActivityResturantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityResturantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bundel=intent.extras!!
        restaurant  = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("restaurant", Resturant::class.java)
        } else {
            intent.getParcelableExtra<Resturant>("restaurant")
        }
        binding.imgResturant.load(restaurant!!.restaurantImage)
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(ResturantMenuFragment(), "Menu")
        adapter.addFragment(ResturantInformationFragment(), "Information")
        adapter.addFragment(ResturantComentsFragment(), "Comments")

        // Adding the Adapter to the ViewPager
        binding.viewPager.adapter = adapter

        // bind the viewPager with the TabLayout.
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}