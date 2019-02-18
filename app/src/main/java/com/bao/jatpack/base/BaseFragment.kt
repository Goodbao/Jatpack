package com.bao.jatpack.base

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment<ViewModelT : BaseViewModel, DataBindingT : ViewDataBinding> : Fragment() {
    val VIEWMODEL = 1

    @LayoutRes
    protected abstract fun layoutResource(): Int
    protected abstract fun viewModelClass(): Class<out BaseViewModel>

    lateinit var viewModel: ViewModelT
    lateinit var dataBinding: DataBindingT

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutResource(),container,false)
        dataBinding.setLifecycleOwner(viewLifecycleOwner)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(viewModelClass()) as ViewModelT
        dataBinding.setVariable(VIEWMODEL,viewModel)
    }
}