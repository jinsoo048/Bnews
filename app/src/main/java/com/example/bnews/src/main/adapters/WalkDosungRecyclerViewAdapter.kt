package com.example.bnews.src.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bnews.databinding.ItemRecyclerWalkDosungBinding
import com.example.bnews.src.main.models.walk.dosung.Dosung
import com.example.bnews.src.main.models.walk.dosung.Row
import com.example.bnews.src.main.ui.walk.DosungFragment

class WalkDosungRecyclerViewAdapter(
    var context: DosungFragment,
    var mDosung: Dosung,
    private var cellClickListener: DosungFragment
) : RecyclerView.Adapter<WalkDosungRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val itemBinding: ItemRecyclerWalkDosungBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(mRow: Row) {

            /*
            Glide.with(itemBinding.imageIv.context)
                .load(mEducation.ListPublicReservationEducation.row[position].IMGURL)
                .into(itemBinding.imageIv)

            val match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]".toRegex()
            var str: String =
                mEducation.ListPublicReservationEducation.row[position].SVCNM
            str = str.replace(match, "")

             */

            //itemBinding.eventNameTv.text = mEducation.ListPublicReservationEducation.row[position].SVCNM
            //itemBinding.eventNameTv.text = str
            itemBinding.CourseNameTv.text =
                mDosung.walkDoseongInfo.row[position].COURSE_NAME
            itemBinding.AreaGuTv.text =
                mDosung.walkDoseongInfo.row[position].AREA_GU
            itemBinding.DistanceTv.text =
                mDosung.walkDoseongInfo.row[position].DISTANCE
            itemBinding.LeadTimeTv.text =
                mDosung.walkDoseongInfo.row[position].LEAD_TIME
            itemBinding.SubwayTv.text =
                mDosung.walkDoseongInfo.row[position].RELATE_SUBWAY
            itemBinding.LevelTv.text =
                mDosung.walkDoseongInfo.row[position].COURSE_LEVEL
            itemBinding.DetailCourseTv.text =
                mDosung.walkDoseongInfo.row[position].DETAIL_COURSE
            // itemBinding.urlTv.text = mEducation.ListPublicReservationEducation.row[position].SVCURL
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemBinding = ItemRecyclerWalkDosungBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var mRow = mDosung.walkDoseongInfo.row[position]
        holder.bind(mRow)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListenerWalkDosungEvent(mDosung.walkDoseongInfo.row[position])
        }
    }

    override fun getItemCount(): Int {
        return mDosung.walkDoseongInfo.row.size
    }
}