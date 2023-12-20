package com.capstone.jobamate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.jobamate.adapter.HomeJobAdapter
import com.capstone.jobamate.databinding.FragmentHomeBinding
import com.capstone.jobamate.model.Job
import com.capstone.jobamate.model.JobDataDummySource

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val adapter = HomeJobAdapter(JobDataDummySource.dummyJob)
        binding.rvHorizontal.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            this.adapter = adapter
        }

        adapter.setOnItemClickCallback(object : HomeJobAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Job) {
                val intent = Intent(context, DetailJobActivity::class.java)
                intent.putExtra("key_job", data)
                startActivity(intent)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
