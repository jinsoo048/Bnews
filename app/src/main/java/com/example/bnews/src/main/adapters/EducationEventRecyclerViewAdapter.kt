package com.example.bnews.src.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bnews.databinding.ItemRecyclerEventBinding
import com.example.bnews.src.main.models.education.Row
import com.example.bnews.src.main.models.education.Education
import com.example.bnews.src.main.ui.culture.EducationFragment

class EducationEventRecyclerViewAdapter(

    var context: EducationFragment,
    var mEducation: Education,
    private var cellClickListener: EducationFragment
) : RecyclerView.Adapter<EducationEventRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val itemBinding: ItemRecyclerEventBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(mRow: Row) {

            Glide.with(itemBinding.imageIv.context)
                .load(mEducation.ListPublicReservationEducation.row[position].IMGURL)
                .into(itemBinding.imageIv)

            val match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]".toRegex()
            var str: String =
                mEducation.ListPublicReservationEducation.row[position].SVCNM
            str = str.replace(match, "")


            //itemBinding.eventNameTv.text = mEducation.ListPublicReservationEducation.row[position].SVCNM
            itemBinding.eventNameTv.text = str

            itemBinding.classNameTv.text =
                mEducation.ListPublicReservationEducation.row[position].MINCLASSNM
            itemBinding.classKindTv.text =
                mEducation.ListPublicReservationEducation.row[position].MAXCLASSNM
            itemBinding.beginTv.text =
                mEducation.ListPublicReservationEducation.row[position].SVCOPNBGNDT
            itemBinding.endTv.text =
                mEducation.ListPublicReservationEducation.row[position].SVCOPNENDDT
            itemBinding.regionTv.text =
                mEducation.ListPublicReservationEducation.row[position].AREANM
            itemBinding.whereTv.text =
                mEducation.ListPublicReservationEducation.row[position].PLACENM
            itemBinding.paymentTv.text =
                mEducation.ListPublicReservationEducation.row[position].PAYATNM
            // itemBinding.urlTv.text = mEducation.ListPublicReservationEducation.row[position].SVCURL
        }
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        var mRow = mEducation.ListPublicReservationEducation.row[position]
        holder.bind(mRow)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListenerEducationEvent(mRow)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemBinding =
            ItemRecyclerEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return mEducation.ListPublicReservationEducation.row.size
    }

}

