package com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel

import java.util.UUID

class MainActivity: ViewModelActivity() {

    private val userDataViewModel: UserDataViewModel = viewModelProvider[UserDataViewModel::class.java]
    private val activityKey = UUID.randomUUID().toString()

    fun onCreate() {
        super.onCreate(activityKey)
        println("MainActivity: OnCreate")
    }

    fun onStart() {
        val userDataList = userDataViewModel.userList
        println("MainActivity: OnStart. UserList = $userDataList")
    }

    fun onResume() {
        println("MainActivity: OnResume. Testing viewmodel scope")
        userDataViewModel.testViewModelScope()
    }

    fun onDestroy(isFinishing: Boolean) {
        super.onDestroy(isFinishing, activityKey)
    }
}