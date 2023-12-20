package com.capstone.jobamate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.capstone.jobamate.databinding.ItemJobseekerBinding
import com.capstone.jobamate.model.Job

class JobAdapter(private val listJob: List<Job>): RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    private lateinit var binding: ItemJobseekerBinding
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobAdapter.JobViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemJobseekerBinding.inflate(inflater, parent, false)
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobAdapter.JobViewHolder, position: Int) {
        holder.bind(listJob[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(listJob[holder.adapterPosition])
            Toast.makeText(holder.itemView.context, "You clicked on ${listJob[holder.adapterPosition].title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listJob.size

    class JobViewHolder(private val binding: ItemJobseekerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(job: Job) {
            with(binding) {
                tvJobTitle.text = job.title
                tvCompanyName.text = job.companyName
                tvJobLocation.text = job.location
                tvSalary.text = job.salary
                ivCompanyLogo.setImageResource(job.image)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Job)
    }
}
