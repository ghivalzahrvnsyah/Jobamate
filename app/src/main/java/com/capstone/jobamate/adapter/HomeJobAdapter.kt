package com.capstone.jobamate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.capstone.jobamate.databinding.ItemJobHomepageBinding
import com.capstone.jobamate.model.Job

class HomeJobAdapter(private val listJob: List<Job>): RecyclerView.Adapter<HomeJobAdapter.JobViewHolder>() {

    private lateinit var binding: ItemJobHomepageBinding
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeJobAdapter.JobViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemJobHomepageBinding.inflate(inflater, parent, false)
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeJobAdapter.JobViewHolder, position: Int) {
        holder.bind(listJob[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(listJob[holder.adapterPosition])
            Toast.makeText(holder.itemView.context, "You clicked on ${listJob[holder.adapterPosition].title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listJob.size

    class JobViewHolder(private val binding: ItemJobHomepageBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(job: Job) {
            with(binding) {
                tvJobTitle.text = job.title
                tvCompanyName.text = job.companyName
                tvJobLocation.text = job.location
                tvSalary.text = job.salary
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Job)
    }
}
