package com.example.fooddelivery

import android.util.Log
import androidx.lifecycle.ViewModel

class SignUpModel : ViewModel() {
    fun signupAccount(email:String,password:String,name:String)
    {
        Data.addtolist(user(email,password,name))
    }

    fun checkemailandpass(email: String, password: String,repassword:String):Boolean
    {
        val isEmailvalid=Validators.isemailvalid(email)
        val isPassValid=Validators.ispasswordvalid(password,repassword)
        Log.d("test1", isEmailvalid.toString()+ " "+ isPassValid.toString())
        return isEmailvalid && isPassValid
    }
}