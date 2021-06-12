package com.example.bnews.src.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bnews.databinding.ItemRecyclerWalkLiveBinding
import com.example.bnews.src.main.models.walk.Live.Live
import com.example.bnews.src.main.models.walk.Live.Row
import com.example.bnews.src.main.ui.walk.LiveFragment

class WalkLiveRecyclerAdapter(
    var context: LiveFragment,
    var mLive: Live,
    private var cellClickListener: LiveFragment
) : RecyclerView.Adapter<WalkLiveRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val itemBinding: com.example.bnews.databinding.ItemRecyclerWalkLiveBinding) :
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
                mLive.walkSaengtaeInfo.row[position].COURSE_NAME
            itemBinding.AreaGuTv.text =
                mLive.walkSaengtaeInfo.row[position].AREA_GU
            itemBinding.DistanceTv.text =
                mLive.walkSaengtaeInfo.row[position].DISTANCE
            itemBinding.LeadTimeTv.text =
                mLive.walkSaengtaeInfo.row[position].LEAD_TIME
            itemBinding.SubwayTv.text =
                mLive.walkSaengtaeInfo.row[position].RELATE_SUBWAY
            itemBinding.LevelTv.text =
                mLive.walkSaengtaeInfo.row[position].COURSE_LEVEL
            itemBinding.DetailCourseTv.text =
                mLive.walkSaengtaeInfo.row[position].DETAIL_COURSE
            itemBinding.ContentTv.text =
                mLive.walkSaengtaeInfo.row[position].CONTENT
            // itemBinding.urlTv.text = mEducation.ListPublicReservationEducation.row[position].SVCURL
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemBinding = com.example.bnews.databinding.ItemRecyclerWalkLiveBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var mRow = mLive.walkSaengtaeInfo.row[position]
        holder.bind(mRow)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListenerWalkLiveEvent(mRow)
        }
    }

    override fun getItemCount(): Int {
        return mLive.walkSaengtaeInfo.row.size
    }
}
