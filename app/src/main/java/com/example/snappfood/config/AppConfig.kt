package com.example.radiojavannahaei.config

import android.app.Application
import android.content.Context
import com.google.android.gms.ads.MobileAds

class AppConfig:Application() {
    init {
        instance=this
    }
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)

    }

companion object{
    private var instance:AppConfig?=null
    fun aplicationcontext():Context{
        return instance!!.applicationContext
    }
}

}