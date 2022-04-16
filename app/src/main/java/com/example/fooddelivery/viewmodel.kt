package com.example.fooddelivery


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class viewmodel : ViewModel() {
    private var errorLiveData : MutableLiveData<String> = MutableLiveData()
    val error : LiveData<String>
        get() = errorLiveData

    private var successLiveData : MutableLiveData<Boolean> = MutableLiveData()
    val success : LiveData<Boolean>
        get() = successLiveData

    fun checkemailandpass(name:String,email: String, password: String,repassword:String)
    {
        val isEmailvalid=Validators.isemailvalid(email)
        val isPassValid=Validators.ispasswordvalid(password,repassword)

        if (!isEmailvalid)
        {
            errorLiveData.postValue("Wrong Email")
            return
        }
        if (!isPassValid)
        {
            errorLiveData.postValue("Unmatched password")
            return
        }
        if (isEmailvalid && isPassValid)
        {
            signupAccount(email,password,name)
        }

        return successLiveData.postValue(true)

    }

    fun signupAccount(email:String,password:String,name:String)
    {
        Data.addtolist(user(email,password,name))
    }
}