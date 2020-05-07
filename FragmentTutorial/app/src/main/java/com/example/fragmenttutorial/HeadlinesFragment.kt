package com.example.fragmenttutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import org.jetbrains.anko.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HeadlinesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HeadlinesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

//        view
//        buttonNext.setOnClickListener() {
//            toast("Next Button Clicked")
//            val newFragment = ArticleFragment()
//            val transaction = supportFragmentManager.beginTransaction().apply {
//                replace(R.id.fragment_container, newFragment)
//            }
//
//            transaction.commit()
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val root = inflater.inflate(R.layout.fragment_headlines, container, false)

        val buttonNext = root.findViewById<Button>(R.id.buttonNext)


        buttonNext.setOnClickListener(View.OnClickListener { (activity as MainActivity).test("from Headline fragment") })

        return root
//        val transaction = supportFragment
    }

    private fun replaceFragmentNext() {
        requireContext().toast("Hi")
        val nextFragment = ArticleFragment()
        val transaction = requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, nextFragment)

        }
        transaction.commit()

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HeadlinesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HeadlinesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
