package com.materialuiux.navigation_components_example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.materialuiux.navigation_components_example.R
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment() {

    lateinit var navController: NavController

    // Safe Args
    val args: SecondFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val tv: TextView = view.findViewById(R.id.textView)
        // show the passed text throw Safe Args
        tv.text = args.text

        view.findViewById<ImageButton>(R.id.btn_retry).setOnClickListener {
            // another way to handle back pressed
            navController.popBackStack()
        }
    }


}