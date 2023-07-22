package com.example.snappfood.ui.main

import com.example.snappfood.models.IResponseMessage
import com.example.snappfood.models.IView
import com.navin.snappfood.models.CategoryModelModel

class CategoriPeresenter(View: IView<CategoryModelModel>) : IResponseMessage<CategoryModelModel> {
    val apiCaller=ApiCaller()
     var iView: IView<CategoryModelModel> =View
    fun getCategories(){
        iView.showprogressbar()
        apiCaller.getcategories(this)


    }

    override fun onsuccess(responseMessage: CategoryModelModel) {
        iView.hideprogressbar()
        iView.onsucess(responseMessage)

    }

    override fun onfailure(error: String) {
        iView.hideprogressbar()
       iView.onError(error)
    }
}