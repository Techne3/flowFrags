package com.example.flowfrags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flowfrags.databinding.EmailBinding
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider

class Email : Fragment() {



    private  var _binding: EmailBinding? = null
    private  val binding: EmailBinding get() = _binding!!

    private var first = ""
    private var last = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = EmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            emailEt.editText?.addTextChangedListener { text ->
                nextBtnEmail.isEnabled = text.toString().length > 1

                first  = arguments?.getString("First") ?: "First"
                last = arguments?.getString("Last" ) ?: "Last"
            }

            nextBtnEmail.setOnClickListener{
                val bundle =  Bundle()
                bundle.putString("Email", emailEt.editText?.text.toString())
                bundle.putString("First",first)
                bundle.putString("Last",last)


                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, Password::class.java, bundle)
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