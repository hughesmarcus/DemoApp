package com.example.mailchimpapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.mailchimpapplication.R
import com.example.mailchimpapplication.data.models.Member
import com.example.mailchimpapplication.ui.vm.SubListViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SubListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModel: SubListViewModel
    @BindView(R.id.list)
    lateinit var sublistRecyclerView: RecyclerView
    var subAdapter: SubAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sublist, container, false)
        ButterKnife.bind(this, view)
        setupSubsList()
        viewModel.subsLiveData.observe(viewLifecycleOwner, Observer { displayList(it) })
        return view
    }

    private fun displayList(list: List<SubListAdapterType>) {
        subAdapter?.update(list)
        subAdapter?.notifyDataSetChanged()
    }

    interface NavigationHandler {
        fun onMemberClick(member: Member)
    }
    private fun setupSubsList() {
        subAdapter = activity?.let { SubAdapter(listOf()) }
        subAdapter?.let { adapter ->
            adapter.subListClickhandler = object : SubAdapter.SubListClickHandler {
                override fun onClickMember(member: Member) {
                    (activity as NavigationHandler).onMemberClick(
                        member
                    )
                }
            }
            sublistRecyclerView.adapter = subAdapter
            sublistRecyclerView.layoutManager = LinearLayoutManager(context)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): SubListFragment {
            return SubListFragment()
        }
    }
}
