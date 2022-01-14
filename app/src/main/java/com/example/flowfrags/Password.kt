package com.example.flowfrags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.flowfrags.databinding.PasswordBinding

class Password :Fragment() {

    private  var _binding: PasswordBinding? = null
    private  val binding: PasswordBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            passwordEt.editText?.addTextChangedListener { text ->
                nextBtnPassword.isEnabled = text.toString().length > 1
            }

            nextBtnPassword.setOnClickListener{
                val bundle = Bundle()
                bundle.putString("Password", passwordEt.editText?.text.toString())


                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, InfoFragment::class.java, bundle)
                    .addToBackStack(null)
                    .commit()

            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}