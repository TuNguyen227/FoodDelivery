package com.example.fooddelivery

object Data {
    private var ListOfUsers = mutableListOf<user>()

    fun getList(): MutableList<user> {
        return ListOfUsers
    }

    fun addtolist(user: user) {
        ListOfUsers.add(user)
    }



}