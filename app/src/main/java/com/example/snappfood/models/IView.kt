package com.example.snappfood.models

interface IView<in T> {
    fun showprogressbar()
    fun hideprogressbar()
    fun onsucess(responseMessage:T)
    fun onfailure(errorMessage:String)
    fun onError(errorMessage: String)
}