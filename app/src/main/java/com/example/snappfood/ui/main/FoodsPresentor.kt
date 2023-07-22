package com.example.snappfood.ui.main

import com.example.snappfood.models.IResponseMessage
import com.example.snappfood.models.FoodModel
import com.example.snappfood.models.IView

class FoodsPresentor(View: IView<FoodModel>) : IResponseMessage<FoodModel> {
    val apiCaller=ApiCaller()
     var iView: IView<FoodModel> =View
    fun getFoods(){
        iView.showprogressbar()
        apiCaller.getFoods(this)


    }

    override fun onsuccess(responseMessage: FoodModel) {
        iView.hideprogressbar()
        iView.onsucess(responseMessage)

    }

    override fun onfailure(error: String) {
        iView.hideprogressbar()
       iView.onError(error)
    }
}