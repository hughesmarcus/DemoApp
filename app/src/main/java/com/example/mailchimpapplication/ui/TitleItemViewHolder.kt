package com.example.mailchimpapplication.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.mailchimpapplication.R
import com.example.mailchimpapplication.ui.sublist.SubAdapter

class TitleItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    @BindView(R.id.subList_title)
    lateinit var titleText:TextView

    @JvmField
    protected var clickHandler: SubAdapter.SubListClickHandler? = null

    init {
        ButterKnife.bind(this, view)
    }

    fun bind(it: SubListItemUIModel.SubListTitleUiModel) {
        titleText.text = it.title
    }
}