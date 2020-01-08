package com.example.mailchimpapplication.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mailchimpapplication.R
import com.example.mailchimpapplication.data.models.Member

/**
 * A simple [Fragment] subclass.
 */
class MemberFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_member, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(member: Member): MemberFragment {
            return MemberFragment()
        }
    }
}
