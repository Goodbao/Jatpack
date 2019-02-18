package com.bao.jatpack.ui.binding

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class BindingViewModel : ViewModel() {
    val phone = MutableLiveData<String>()

    init {
        phone.postValue("16600001111")
    }
}