package com.example.bnews.src.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bnews.src.main.models.tour.travel.Item
import com.example.bnews.src.main.models.tour.travel.Travel
import com.example.bnews.src.ui.walk.TravelFragment

class TourTravelRecyclerAdapter(
    var context: TravelFragment,
    var mTravel: Travel,
    private var cellClickListener: TravelFragment
) : RecyclerView.Adapter<TourTravelRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val itemBinding: com.example.bnews.databinding.ItemRecyclerTourTravelBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(mRow: Item) {


            //Glide.with(itemBinding.HtNameIv.context)
            //    .load(mTravel.futureCourseInfo.row[position].HT_THUMB_NAM)
            //    .into(itemBinding.HtNameIv)

            Glide.with(itemBinding.imageIv.context)
                .load(mTravel.response.body.items.item[position].galWebImageUrl)
                .into(itemBinding.imageIv)

            //val match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]".toRegex()
            //var str: String =
            //   mEducation.ListPublicReservationEducation.row[position].SVCNM
            //str = str.replace(match, "")

            itemBinding.galTitleTv.text =
                mTravel.response.body.items.item[position].galTitle
            itemBinding.galPhotographyLocationTv.text =
                mTravel.response.body.items.item[position].galPhotographyLocation
            itemBinding.galViewCountTv.text =
                mTravel.response.body.items.item[position].galViewCount.toString()
            itemBinding.galSearchKeywordTv.text =
                mTravel.response.body.items.item[position].galSearchKeyword
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemBinding = com.example.bnews.databinding.ItemRecyclerTourTravelBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var mRow = mTravel.response.body.items.item[position]
        holder.bind(mRow)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListenerTourTravelEvent(mRow)
        }
    }

    override fun getItemCount(): Int {
        return mTravel.response.body.items.item.size
    }
}
