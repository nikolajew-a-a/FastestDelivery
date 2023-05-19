package ru.app.fastestdelivery.data.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.app.fastestdelivery.data.models.database.PRODUCT_TABLE
import ru.app.fastestdelivery.data.models.database.ProductEntity

interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(products: List<ProductEntity>)

    @Query("SELECT * FROM $PRODUCT_TABLE WHERE id=:id")
    fun getProduct(id: String): ProductEntity

}