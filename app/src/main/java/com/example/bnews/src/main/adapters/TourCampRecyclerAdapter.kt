package com.example.bnews.src.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bnews.src.main.models.tour.camp.Camp
import com.example.bnews.src.main.models.tour.camp.Item
import com.example.bnews.src.main.ui.tour.CampFragment

class TourCampRecyclerAdapter(
    var context: CampFragment,
    var mCamp: Camp,
    private var cellClickListener: CampFragment
) : RecyclerView.Adapter<TourCampRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val itemBinding: com.example.bnews.databinding.ItemRecyclerTourCampBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(mRow: Item) {

            itemBinding.facltNmTv.text =
                mCamp.response.body.items.item[position].facltNm
            itemBinding.indutyTv.text =
                mCamp.response.body.items.item[position].induty
            itemBinding.addr1Tv.text =
                mCamp.response.body.items.item[position].addr1.toString()

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemBinding = com.example.bnews.databinding.ItemRecyclerTourCampBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var mRow = mCamp.response.body.items.item[position]
        holder.bind(mRow)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListenerTourCampEvent(mCamp.response.body.items.item[position])
            //com.example.bnews.src.main.models.tour.travel
        }
    }

    override fun getItemCount(): Int {
        return mCamp.response.body.items.item.size
    }
}


