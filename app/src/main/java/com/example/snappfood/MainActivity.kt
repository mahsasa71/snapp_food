package com.example.snappfood

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.radiojavannahaei.config.AppConfig
import com.example.snappfood.databinding.ActivityMainBinding
import com.example.snappfood.di.di.DaggerUserComponent
import com.example.snappfood.di.di.UserModule
import com.example.snappfood.di.sampel.ExtendedContact
import com.example.snappfood.di.sampel.SimpleContact
import com.example.snappfood.di.sampel.UserManagement
import com.example.snappfood.models.FoodModel
import com.example.snappfood.models.IView
import com.example.snappfood.models.ResturantModel
import com.example.snappfood.ui.main.CategoriPeresenter
import com.example.snappfood.ui.main.FoodsPresentor
import com.example.snappfood.ui.main.RestaurantPeresenter
import com.example.snappfood.ui.main.adapter.CategoriAdapter
import com.example.snappfood.ui.main.adapter.FoodAdapter
import com.example.snappfood.ui.main.adapter.RestaurantAdapter
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.navin.snappfood.models.CategoryModelModel

class MainActivity : AppCompatActivity(), IView<Any> {
    lateinit var binding: ActivityMainBinding
     var presenter:CategoriPeresenter=CategoriPeresenter(this)
    private var mInterstitialAd: InterstitialAd? = null

     var foodpresenter:FoodsPresentor=FoodsPresentor(this)
     var restaurnpresenter:RestaurantPeresenter= RestaurantPeresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        AppConfig.aplicationcontext()
        //presenter= CategoriPeresenter(this)
      //  foodpresenter=FoodsPresentor()
        presenter.getCategories()
        foodpresenter.getFoods()
        restaurnpresenter.getRestaurants()
        var user= UserManagement(SimpleContact())
        var user1= UserManagement(ExtendedContact())
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
        binding.adView.adListener = object: AdListener() {
            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        }
        var adRequest2 = AdRequest.Builder().build()
        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest2, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {

                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {

                mInterstitialAd = interstitialAd
                mInterstitialAd!!.show(this@MainActivity)
            }
        })
    val component=DaggerUserComponent.builder()
        .userModule(UserModule()).build()
        component.provideuser().addcontactEmail("mahsasahraei71@gmail.com")
        Toast.makeText(applicationContext,component.provideuser().mycontactEmail(),Toast.LENGTH_LONG).show()
//
//        var natijeh=component.provideuser().mycontact


//        val component2= DaggerUserComponent.builder()
//           .userModule(UserModule()).build()
//        component2.provideuser().addcontactEmail("mahsasahraei@yahoo")
//       var natije2= component2.provideuser().mycontact









    }

    override fun showprogressbar() {
        binding.progress.visibility=View.VISIBLE

    }

    override fun hideprogressbar() {
        binding.progress.visibility=View.GONE
    }

    override fun onsucess(responseMessage: Any) {
        when(responseMessage){
            is CategoryModelModel->{

                //Toast.makeText(applicationContext,"fine",Toast.LENGTH_LONG).show()
                binding.recyclerCategories.adapter= CategoriAdapter(
                    applicationContext,responseMessage.categories)
                binding.recyclerCategories.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)


            }
            is FoodModel ->{
                binding.recyclerFoods.adapter= FoodAdapter(
                    applicationContext,responseMessage.foodList)
                binding.recyclerFoods.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)

            }
            is ResturantModel ->{
                binding.recyclerRetaurants.adapter= RestaurantAdapter(
                    applicationContext,responseMessage.restaurantList)
                binding.recyclerRetaurants.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)

            }

        }



    }

    override fun onfailure(errorMessage: String) {
        Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
    }

    override fun onError(errorMessage: String) {

    }
}