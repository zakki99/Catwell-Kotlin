package com.collaboracrew.catwell.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.collaboracrew.catwell.R
import com.collaboracrew.catwell.model.DoctorRecommendationModel
import com.collaboracrew.catwell.model.ProductRecommendationModel

class ListProductRecomAdapter(private val data: List<ProductRecommendationModel>) : RecyclerView.Adapter<ListProductRecomAdapter.ViewHolder>() {

    private var onItemClickListener: ((ProductRecommendationModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (ProductRecommendationModel) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImage: ImageView = itemView.findViewById(R.id.ivProduct)
        private val productName: TextView = itemView.findViewById(R.id.tvProductName)
        private val shopButton: ImageButton = itemView.findViewById(R.id.btShop)

        fun bind(item: ProductRecommendationModel) {
            productImage.setImageResource(item.ProductImage)
            productName.text = item.ProductName
            shopButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener?.invoke(data[position])
                }
            }
        }
    }
}
