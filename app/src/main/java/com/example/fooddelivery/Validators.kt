package com.example.fooddelivery

class Validators {
    companion object{
        fun isemailvalid(email:String):Boolean{
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun ispasswordvalid(password:String,repassword:String) : Boolean{
            val ispasswordMatch= password == repassword
            val ispasswordmatchLength= password.length >8
            val check_character_pattern=password.contains(Regex("[^a-zA-Z0-9 ]")) && password.contains(Regex("[0-9]")) && password.contains(Regex("[A-Z]"))
            return ispasswordMatch && ispasswordmatchLength && check_character_pattern
        }



        fun checkaccountIsMatchData(email:String,password:String) : Boolean{

            var ismailmatch=false
            var ispasswordmatch=false
            if (Data.getList().isEmpty() == true)
                return false
            else
            {
                for (user in Data.getList())
                {
                    if (email == user.email)
                        ismailmatch=true

                    if (password==user.password)
                        ispasswordmatch=true
                }
            }

            return ismailmatch && ispasswordmatch
        }
    }

}