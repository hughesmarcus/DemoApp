package com.example.mailchimpapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.mailchimpapplication.R
import com.example.mailchimpapplication.data.models.Member
import com.example.mailchimpapplication.ui.sublist.SubListFragment
import dagger.android.support.DaggerAppCompatActivity


class MainActivity: DaggerAppCompatActivity(), SubListFragment.NavigationHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pushFragment(SubListFragment.newInstance())
    }

    private fun pushFragment(fragment: Fragment) {
        if (fragment.isAdded) {
            return
        }
        supportFragmentManager.popBackStackImmediate(
            null,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_main_container, fragment)
            .commit()
    }

    fun pushFragmentOnBackStack(fragment: Fragment) {
        if (fragment.isAdded) {
            return
        }
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            .replace(R.id.activity_main_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onMemberClick(member: Member) {
        pushFragmentOnBackStack(MemberFragment.newInstance(member))
    }
}
