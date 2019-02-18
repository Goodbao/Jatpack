package com.bao.jatpack.ui.binding

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bao.jatpack.R
import com.bao.jatpack.base.BaseFragment
import com.bao.jatpack.databinding.BindingFragmentBinding

class BindingFragment : Fragment() {
    companion object {
        fun newInstance() = BindingFragment()
    }

    private lateinit var dataBinding: BindingFragmentBinding
    private lateinit var viewModel: BindingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.binding_fragment, container, false)
        dataBinding.setLifecycleOwner(viewLifecycleOwner)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BindingViewModel::class.java)
        //绑定
        dataBinding.viewModel = viewModel

        dataBinding.view1.imgClose.setOnClickListener {
            activity?.let {
                it.finish()
            }
        }

        dataBinding.view2.imgClose.setOnClickListener {
            activity?.let {
                it.finish()
            }
        }
    }
}
