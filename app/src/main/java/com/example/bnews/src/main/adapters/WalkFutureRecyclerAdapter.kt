package com.example.bnews.src.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bnews.src.main.models.walk.future.Row
import com.example.bnews.src.main.models.walk.future.Future
import com.example.bnews.src.main.ui.walk.FutureFragment

class WalkFutureRecyclerAdapter(
    var context: FutureFragment,
    var mFuture: Future,
    private var cellClickListener: FutureFragment
) : RecyclerView.Adapter<WalkFutureRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val itemBinding: com.example.bnews.databinding.ItemRecyclerWalkFutureBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(mRow: Row) {


            //Glide.with(itemBinding.HtNameIv.context)
            //    .load(mFuture.futureCourseInfo.row[position].HT_THUMB_NAM)
            //    .into(itemBinding.HtNameIv)

            Glide.with(itemBinding.AcpNameIv.context)
                .load(mFuture.futureCourseInfo.row[position].ACP_THUMB_NAME)
                .into(itemBinding.AcpNameIv)

            //val match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]".toRegex()
            //var str: String =
             //   mEducation.ListPublicReservationEducation.row[position].SVCNM
            //str = str.replace(match, "")

            itemBinding.NameTv.text =
                mFuture.futureCourseInfo.row[position].HT_NM
            itemBinding.TitleTv.text =
                mFuture.futureCourseInfo.row[position].AC_TITLE
            itemBinding.AddressTv.text =
                mFuture.futureCourseInfo.row[position].HT_NEW_ADDR
            itemBinding.TakeTimeTv.text =
                mFuture.futureCourseInfo.row[position].AC_TAKE_TIME
         }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemBinding = com.example.bnews.databinding.ItemRecyclerWalkFutureBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var mRow = mFuture.futureCourseInfo.row[position]
        holder.bind(mRow)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListenerWalkFutureEvent(mRow)
        }
    }

    override fun getItemCount(): Int {
        return mFuture.futureCourseInfo.row.size
    }
}
