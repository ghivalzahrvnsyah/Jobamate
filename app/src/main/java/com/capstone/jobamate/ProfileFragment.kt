package com.capstone.jobamate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.capstone.jobamate.databinding.FragmentHomeBinding
import com.capstone.jobamate.databinding.FragmentJobaseekerBinding
import com.capstone.jobamate.databinding.FragmentProfileBinding
import com.capstone.jobamate.model.UserDataDummy


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvName.text = UserDataDummy.user[0].name
        binding.ivProfileImage.setImageResource(UserDataDummy.user[0].image)

        binding.btnEditProfile.setOnClickListener {
            val intent = Intent(requireContext(), EditProfileActivity::class.java)
            startActivity(intent)
        }
        binding.btnResume.setOnClickListener {
            val intent = Intent(requireContext(), ResumeUploadActivity::class.java)
            startActivity(intent)
        }
    }

}