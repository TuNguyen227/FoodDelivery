package com.example.fooddelivery

import androidx.lifecycle.ViewModel

class Sign_In_model :ViewModel() {
    public fun signin(email:String,password:String)
    {
        val checkAccount=Validators.checkaccountIsMatchData(email,password)
        if (checkAccount)
        {
            Data.getList().forEachIndexed { index, user ->
                if (user.email.equals(email))
                {
                    User_Sign_In.email=Data.getList()[index].email
                    User_Sign_In.name=Data.getList()[index].name
                }
            }
        }
    }

}