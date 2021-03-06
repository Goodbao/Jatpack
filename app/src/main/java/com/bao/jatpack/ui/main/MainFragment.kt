package com.bao.jatpack.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bao.jatpack.BindingActivity
import com.bao.jatpack.R
import com.bao.jatpack.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var dataBinding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        dataBinding.setLifecycleOwner(viewLifecycleOwner)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        //绑定
        dataBinding.viewModel = viewModel

        //通过观察者模式，ViewModel参数变化，在此做跳转操作
        viewModel.start.observe(viewLifecycleOwner, Observer {
            if (it!!) {
                activity?.let { activity ->
                    startActivity(Intent(activity, BindingActivity::class.java))
                }
            }
        })

        //通过dataBinding找到控件，
        dataBinding.btn2.setOnClickListener {
            activity?.let { activity ->
                startActivity(Intent(activity, BindingActivity::class.java))
            }
        }
    }
}