package com.example.myapp.utils

import com.example.myapp.models.NewUser

//class DataHolder {
////    companion object{
////        lateinit var user: NewUser
////    }
//}

object DataHolder{
    lateinit var user: NewUser

    internal fun getUser():NewUser{
        return user;
    }

    internal fun getUserEmail(): String? {
        return user.email
    }
}