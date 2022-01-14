package com.example.flowfrags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flowfrags.databinding.FragmentFormBinding
import com.example.flowfrags.databinding.DisplayBinding

class InfoFragment : Fragment() {

    private var _binding: DisplayBinding? = null
    private val binding: DisplayBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  DisplayBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

            firstNameTv.text = arguments?.getString("First")?:"First"
            lastNameTv.text = arguments?.getString("Last")?:"Last"
            emailTv.text = arguments?.getString("Email")?:"Email"
            passwordTv.text = arguments?.getString("Password")?:"Password"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

