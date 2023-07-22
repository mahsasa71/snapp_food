package com.example.snappfood.models

interface IResponseMessage<T> {
    fun onsuccess(responseMessage:T)
    fun onfailure(error:String)

}