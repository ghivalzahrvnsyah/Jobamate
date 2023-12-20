package com.capstone.jobamate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.jobamate.adapter.JobAdapter
import com.capstone.jobamate.databinding.FragmentJobaseekerBinding
import com.capstone.jobamate.model.Job
import com.capstone.jobamate.model.JobDataDummySource


class JobaseekerFragment : Fragment() {

    private var _binding: FragmentJobaseekerBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentJobaseekerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }
    private fun setupRecyclerView() {
        val adapter = JobAdapter(JobDataDummySource.dummyJob)
        binding.rvJobs.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }

        adapter.setOnItemClickCallback(object : JobAdapter.OnItemClickCallback {
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