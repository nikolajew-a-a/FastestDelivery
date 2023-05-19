package ru.app.fastestdelivery.presentation.main.bag.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.app.fastestdelivery.databinding.ItemBagProductBinding
import ru.app.fastestdelivery.domain.models.Product

class BagProductViewHolder(private val binding: ItemBagProductBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Product, onProductClick: (Product) -> Unit) = with(binding) {
        this.itemBagProductQuantity.text = item.quantity.toString()
    }

    companion object {
        fun from(parent: ViewGroup) = BagProductViewHolder(
            ItemBagProductBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

}