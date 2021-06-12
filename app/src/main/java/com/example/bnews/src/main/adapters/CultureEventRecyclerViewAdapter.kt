package com.example.bnews.src.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bnews.databinding.ItemRecyclerEventBinding
import com.example.bnews.src.main.models.culture.PublicReservationCulture
import com.example.bnews.src.main.models.culture.Row
import com.example.bnews.src.main.ui.culture.CultureFragment

class CultureEventRecyclerViewAdapter(
    var context: CultureFragment,
    var mPublicReservationCulture: PublicReservationCulture,
    private var cellClickListener: CultureFragment
) : RecyclerView.Adapter<CultureEventRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val itemBinding: ItemRecyclerEventBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(mRow: Row){

            Glide.with(itemBinding.imageIv.context)
                .load(mPublicReservationCulture.ListPublicReservationCulture.row[position].IMGURL)
                .into(itemBinding.imageIv)

            val match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]".toRegex()
            var str: String = mPublicReservationCulture.ListPublicReservationCulture.row[position].SVCNM
            str = str.replace(match, "")


            //itemBinding.eventNameTv.text = mPublicReservationCulture.ListPublicReservationCulture.row[position].SVCNM
            itemBinding.eventNameTv.text = str

            itemBinding.classNameTv.text = mPublicReservationCulture.ListPublicReservationCulture.row[position].MINCLASSNM
            itemBinding.classKindTv.text = mPublicReservationCulture.ListPublicReservationCulture.row[position].MAXCLASSNM
            itemBinding.beginTv.text = mPublicReservationCulture.ListPublicReservationCulture.row[position].SVCOPNBGNDT
            itemBinding.endTv.text = mPublicReservationCulture.ListPublicReservationCulture.row[position].SVCOPNENDDT
            itemBinding.regionTv.text = mPublicReservationCulture.ListPublicReservationCulture.row[position].AREANM
            itemBinding.whereTv.text = mPublicReservationCulture.ListPublicReservationCulture.row[position].PLACENM
            itemBinding.paymentTv.text = mPublicReservationCulture.ListPublicReservationCulture.row[position].PAYATNM
           // itemBinding.urlTv.text = mPublicReservationCulture.ListPublicReservationCulture.row[position].SVCURL
        }
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        var mRow = mPublicReservationCulture.ListPublicReservationCulture.row[position]
        holder.bind(mRow)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListenerCultureEvent(mRow)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemBinding = ItemRecyclerEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }
    override fun getItemCount(): Int {
        return mPublicReservationCulture.ListPublicReservationCulture.row.size
    }

}
