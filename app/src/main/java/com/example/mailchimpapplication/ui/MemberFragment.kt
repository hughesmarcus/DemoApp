package com.example.mailchimpapplication.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.mailchimpapplication.R
import com.example.mailchimpapplication.data.models.Member
import com.example.mailchimpapplication.ui.vm.MemberViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MemberFragment : DaggerFragment() {

    @BindView(R.id.member_fragment_email)
    lateinit var emailText: EditText

    @BindView(R.id.member_fragment_name)
    lateinit var nameText: TextView

    @Inject
    lateinit var memberViewModel: MemberViewModel

    var member: Member? = null
    var memberId: String = ""
    var memberListId: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_member, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    @OnClick(R.id.button)
    fun saveMember() {
        memberViewModel.updateMember(memberId, memberListId, emailText.text.toString())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val email = arguments?.getString(EXTRA_MEMBER_EMAIL)
        val name = arguments?.getString(EXTRA_MEMBER_NAME)
        emailText.setText(email)
        nameText.text = name
    }

    companion object {

        const val EXTRA_MEMBER_ID = "member_id"
        const val EXTRA_MEMBER_LIST_ID = "member_list_id"
        const val EXTRA_MEMBER_EMAIL = "member_email"
        const val EXTRA_MEMBER_NAME = "member_name"
        @JvmStatic
        fun newInstance(member: Member): MemberFragment {
            return MemberFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(EXTRA_MEMBER_ID, member.id)
                    putSerializable(EXTRA_MEMBER_LIST_ID, member.list_id)
                    putSerializable(EXTRA_MEMBER_EMAIL, member.email_address)
                    putSerializable(
                        EXTRA_MEMBER_NAME,
                        member.merge_fields.FNAME + " " + member.merge_fields.LNAME
                    )
                }
            }
        }
    }
}
