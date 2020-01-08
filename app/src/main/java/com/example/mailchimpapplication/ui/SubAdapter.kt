package com.example.mailchimpapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mailchimpapplication.R
import com.example.mailchimpapplication.data.models.Member

class SubAdapter(private var subList: List<SubListAdapterType> = listOf()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var subListClickhandler: SubListClickHandler? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return when (SubType.values()[viewType]) {
            SubType.TITLE -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_subitem, parent, false)
                TitleItemViewHolder(view)
            }
            SubType.MEMBER -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_subitem_member, parent, false)
                val viewHolder = MemberItemViewHolder(view)
                subListClickhandler?.let { viewHolder.setSubListClickHandler(it) }
                viewHolder
            }
        }
    }

    override fun getItemViewType(position: Int) = subList[position].subType.ordinal

    override fun getItemCount(): Int = subList.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (SubType.values()[viewHolder.itemViewType]) {
            SubType.TITLE -> {
                (subList[position] as? SubListItemUIModel.SubListTitleUiModel)?.let {
                    (viewHolder as TitleItemViewHolder).bind(it)
                }
            }
            SubType.MEMBER -> {
                (subList[position] as? SubListItemUIModel.SubMemberItemUiModel)?.let {
                    (viewHolder as MemberItemViewHolder).bind(it)
                }
            }
        }
    }

    fun update(newList: List<SubListAdapterType>) {
        subList = newList
        notifyDataSetChanged()
    }

    interface SubListClickHandler {
        fun onClickMember(member: Member)
    }
}