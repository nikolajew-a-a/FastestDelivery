package ru.app.fastestdelivery.presentation.main.bag.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.app.fastestdelivery.domain.models.Product

class BagProductsAdapter(private val onProductClick: (Product) -> Unit) : RecyclerView.Adapter<BagProductViewHolder>() {
    private var items: List<Product> = emptyList()

    fun setItems(newItems: List<Product>) {
        val diffCallback = BagProductDiffUtilCallback(this.items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.items = newItems

        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BagProductViewHolder.from(parent)

    override fun onBindViewHolder(holder: BagProductViewHolder, position: Int) {
        holder.bind(items[position], onProductClick)
    }

    override fun getItemCount() = items.size

}