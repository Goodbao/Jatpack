package com.bao.jatpack.base

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.widget.TextView

//设置字体颜色
@BindingAdapter("app:textColor")
fun setTextColor(textView: TextView, color: Int?) {
    color?.let {
        textView.setTextColor(ContextCompat.getColor(textView.context, color))
    }
}

//手机号隐藏
@BindingAdapter("app:hidePhone")
fun hidePhone(textView: TextView, phone: String?) {
    phone?.let {
        if (phone.length > 7) {
            var stringBuffer = StringBuffer(phone)
            for (i in 3..6) {
                stringBuffer.setCharAt(i, '*')
            }
            textView.text = stringBuffer.toString()
        }
    }
}