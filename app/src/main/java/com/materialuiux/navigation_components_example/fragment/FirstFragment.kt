package com.materialuiux.navigation_components_example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.materialuiux.navigation_components_example.R
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation


class FirstFragment : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<AppCompatButton>(R.id.btn_next).setOnClickListener {
            // start navigation to the second fragment and pass the text that was typed by Safe Args
            val action: NavDirections = FirstFragmentDirections.actionFirstFragmentToSecondFragment2(view.findViewById<EditText>(R.id.edit_text).text.toString())
            navController.navigate(action)
        }
    }

}