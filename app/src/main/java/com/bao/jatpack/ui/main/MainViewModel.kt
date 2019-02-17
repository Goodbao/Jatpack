package com.bao.jatpack.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //xml上绑定MutableLiveData后，这里message改变的时候，可以直接显示
    var message = MutableLiveData<String>()

    init {
        message.postValue("我是包子")
    }

    fun setMessage(){
        message.postValue("我被改变了")
    }
}
