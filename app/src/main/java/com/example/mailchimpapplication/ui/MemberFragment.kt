package com.example.mailchimpapplication.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.mailchimpapplication.R
import com.example.mailchimpapplication.data.models.Member
import com.example.mailchimpapplication.ui.vm.MemberViewModel
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MemberFragment : DaggerFragment() {

    @BindView(R.id.member_fragment_email)
    lateinit var emailText: EditText

    @BindView(R.id.member_fragment_name)
    lateinit var nameText: TextView

    @BindView(R.id.imageView)
    lateinit var memberPhoto: ImageView

    @Inject
    lateinit var memberViewModel: MemberViewModel

    var member: Member? = null

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
        member?.let {
            it.email_address = emailText.text.toString()
            memberViewModel.updateMember(it.id, it.list_id, it)
        }
        //Will do for noq need handle errors later
        Toast.makeText(activity, "Email has been saved", Toast.LENGTH_LONG).show()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val memberID = arguments?.getString(EXTRA_MEMBER_ID)
        val listID = arguments?.getString(EXTRA_MEMBER_LIST_ID)
        if (memberID != null && listID != null) {
            memberViewModel.getMember(memberID, listID)
        }
    }

    override fun onResume() {
        super.onResume()
        memberViewModel.member.observe(viewLifecycleOwner, Observer { setupView(it) })
    }

    override fun onPause() {
        super.onPause()
        memberViewModel.member.removeObservers(viewLifecycleOwner)
    }

    private fun setupView(member: Member?) {
        this.member = member
        member?.let {
            emailText.setText(member.email_address)
            nameText.text = member.merge_fields.FNAME + " " + member.merge_fields.LNAME
            val path = member.merge_fields.PHOTO
            if (!path.isNullOrEmpty()) {
                Picasso.get().load(path).fit().placeholder(R.mipmap.ic_launcher)
                    .into(memberPhoto, object : Callback {
                        override fun onSuccess() {
                            memberPhoto.contentDescription = member.id
                        }

                        override fun onError(exception: Exception) {
                        }

                    })
            }
        }
    }

    companion object {

        const val EXTRA_MEMBER_ID = "member_id"
        const val EXTRA_MEMBER_LIST_ID = "member_list_id"
        @JvmStatic
        fun newInstance(member: Member): MemberFragment {
            return MemberFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(EXTRA_MEMBER_ID, member.id)
                    putSerializable(EXTRA_MEMBER_LIST_ID, member.list_id)

                }
            }
        }
    }
}
