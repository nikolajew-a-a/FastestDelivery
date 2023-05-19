package ru.app.fastestdelivery.presentation.main.bag.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.app.fastestdelivery.databinding.ItemBagProductBinding
import ru.app.fastestdelivery.domain.models.Product

class BagProductViewHolder(private val binding: ItemBagProductBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Product,
        onProductPlusClick: (Product) -> Unit,
        onProductMinusClick: (Product) -> Unit,
        onProductDeleteClick: (Product) -> Unit,
    ) = with(binding) {
        itemBagProductQuantity.text = item.quantity.toString()
        itemBagProductPlus.setOnClickListener { onProductPlusClick.invoke(item) }
        itemBagProductMinus.setOnClickListener { onProductMinusClick.invoke(item) }
        itemBagProductDelete.setOnClickListener { onProductDeleteClick.invoke(item) }
    }

    companion object {
        fun from(parent: ViewGroup) = BagProductViewHolder(
            ItemBagProductBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

}