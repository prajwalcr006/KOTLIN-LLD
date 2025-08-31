package com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel

import com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel.model.User
import com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel.viewmodel.CustomViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserDataViewModel: CustomViewModel() {
    val userList: MutableList<User> = mutableListOf(
        User("Ben", 10),
        User("Max", 65),
        User("Asmuth", 1000)
    )

    init {
        put("UserList", userList)
    }

    override fun onCleared() {
        super.onCleared()
        println("ViewModel cleared!!. dataMap is ${get("UserList")}")
    }

    fun testViewModelScope() {
        viewModelScope.launch {
            try {
                delay(3*1000)
                println("10 Seconds Completed Successfully")
            } catch (ex: CancellationException) {
                println("ViewModel coroutine cancelled!!")
                throw ex
            }
        }
    }
}