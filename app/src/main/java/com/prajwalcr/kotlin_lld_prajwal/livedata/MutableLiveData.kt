package com.prajwalcr.kotlin_lld_prajwal.livedata

class MutableLiveData<T>: LiveData<T>() {
    public override fun setValue(data: T) {
        super.setValue(data)
    }

    public override fun postValue(data: T) {
        super.postValue(data)
    }
}