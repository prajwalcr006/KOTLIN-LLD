package com.prajwalcr.kotlin_lld_prajwal.livedata

import com.prajwalcr.kotlin_lld_prajwal.livedata.lifecycle.Activity1
import com.prajwalcr.kotlin_lld_prajwal.livedata.lifecycle.Activity2

fun main() {

    val mutableLiveData1: MutableLiveData<Int> = MutableLiveData()
    val mutableLiveData2: MutableLiveData<Int> = MutableLiveData()

    val activity1 = Activity1(mutableLiveData1)
    val activity2 = Activity2(mutableLiveData2)

    activity1.onStart()
    activity1.onResume()

    mutableLiveData1.setValue(2)
    activity1.onStop()
    mutableLiveData1.setValue(3)
}