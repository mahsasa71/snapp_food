package com.example.snappfood.di.di

import javax.inject.Inject

class User @Inject constructor(contact: Contact)  {

    var mycontact:Contact=contact


    fun addcontactEmail(email:String){
        mycontact.addEmail(email)
    }

    fun mycontactEmail():String{
        return mycontact.email
    }
    fun removeContactEmail(){
        mycontact.delerEmail()
    }


}