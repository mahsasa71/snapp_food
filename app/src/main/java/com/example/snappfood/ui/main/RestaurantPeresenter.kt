package com.example.snappfood.ui.main

import com.example.snappfood.models.IResponseMessage
import com.example.snappfood.models.IView
import com.example.snappfood.models.ResturantModel

class RestaurantPeresenter(View: IView<ResturantModel>) : IResponseMessage<ResturantModel> {
    val apiCaller=ApiCaller()
     var iView: IView<ResturantModel> =View
    fun getRestaurants(){
        iView.showprogressbar()
        apiCaller.getRestaurants(this)


    }

    override fun onsuccess(responseMessage: ResturantModel) {
        iView.hideprogressbar()
        iView.onsucess(responseMessage)

    }

    override fun onfailure(error: String) {
        iView.hideprogressbar()
       iView.onError(error)
    }
}