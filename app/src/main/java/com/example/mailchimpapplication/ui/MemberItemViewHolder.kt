package com.example.mailchimpapplication.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.mailchimpapplication.R
import com.example.mailchimpapplication.data.models.Member
import com.example.mailchimpapplication.ui.sublist.SubAdapter
import com.squareup.picasso.Picasso

class MemberItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    @BindView(R.id.sublist_member_email)
    lateinit var emailText: TextView
    @BindView(R.id.sublist_member_name)
    lateinit var nameText: TextView
    @BindView(R.id.sublist_member_photo)
    lateinit var subListMemberPhoto: ImageView

    var member: Member? = null
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

    fun bind(member: SubListItemUIModel.SubMemberItemUiModel) {
        this.member = member.member
        emailText.text = member.email
        nameText.text = member.firstName + " " + member.lastName
        val path = member.imageUrl
        if (!path.isNullOrEmpty()) {
            Picasso.get().load(path).fit().placeholder(R.mipmap.ic_launcher)
                .into(subListMemberPhoto)
        } else {
            subListMemberPhoto.setImageResource(R.mipmap.ic_launcher)
        }
    }
}