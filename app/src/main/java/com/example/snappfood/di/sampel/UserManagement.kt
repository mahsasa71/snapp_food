package com.example.snappfood.di.sampel

class UserManagement {
     var contact: ContactManagement

    constructor(contact: ContactManagement){
        this.contact=contact
    }
}