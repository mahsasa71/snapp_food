package com.example.snappfood.di.di

import android.util.Log

class Contact {
    var email:String=""
    fun addEmail(email:String){
        this.email=email
       Log.e("","${email}")

    }
    @JvmName("getEmail1")
    fun getEmail():String{
        Log.e("","${email}")
        return email




    }
    fun delerEmail(){
        this.email=""
    }

}