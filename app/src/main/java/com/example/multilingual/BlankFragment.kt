package com.example.multilingual

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.util.Locale


class BlankFragment : Fragment() {
    var hindi :Button? = null
    var eng :Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hindi = view.findViewById(R.id.hindi)
        eng = view.findViewById(R.id.english)


        hindi?.setOnClickListener {
            Log.d("TAG", "onViewCreated: buttonClicked hindi")
            setLocale("hi")
        }

        eng?.setOnClickListener {
            Log.d("TAG", "onViewCreated: buttonClicked eng")
            setLocale("en")
        }
    }

    private fun setLocale(lang: String?) {
        val myLocale = Locale(lang)
        val res = resources
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, res.displayMetrics)

        // Using the Fragment's context to start the activity
        val intent = Intent(requireActivity(), MainActivity::class.java)
        startActivity(intent)

        // Finishing the parent activity
        requireActivity().finish()
    }

}