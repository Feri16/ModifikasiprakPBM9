package com.example.pbm9ferik

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class NextFragment : Fragment() {
    private var communicationViewModel: CommunicationViewModel? = null
    private var txtName: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communicationViewModel = ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_next,
            container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        txtName = view.findViewById(R.id.textViewName)
        communicationViewModel!!.name.observe(requireActivity(),
            Observer { s -> txtName!!.text = s })
    }
    companion object {
        fun newInstance(): NextFragment {
            return NextFragment()
        }
    }
}
