package com.example.mailchimpapplication.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.mailchimpapplication.R
import com.example.mailchimpapplication.data.models.Member
import com.example.mailchimpapplication.ui.sublist.SubAdapter

class MemberItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    @BindView(R.id.sublist_member_email)
    lateinit var emailText: TextView
    @BindView(R.id.sublist_member_name)
    lateinit var nameText: TextView
    var member:Member? = null
    @JvmField
    protected var clickHandler: SubAdapter.SubListClickHandler? = null

    init {
        ButterKnife.bind(this, view)
        val subListClickListener = View.OnClickListener {
            member?.let {
                clickHandler?.onClickMember(it)
            }
        }
        itemView.setOnClickListener(subListClickListener)
    }

    fun setSubListClickHandler(handler: SubAdapter.SubListClickHandler) {
        clickHandler = handler
    }

    fun bind(it: SubListItemUIModel.SubMemberItemUiModel) {
        member = it.member
        emailText.text = it.email
        nameText.text = it.firstName + " " + it.lastName
    }
}