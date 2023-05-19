package ru.app.fastestdelivery.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.app.fastestdelivery.data.models.database.BAG_PRODUCT_TABLE
import ru.app.fastestdelivery.data.models.database.BagProductEntity
import ru.app.fastestdelivery.data.models.database.ProductEntity
import ru.app.fastestdelivery.data.models.database.UserEntity

@Dao
interface BagProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBagProduct(product: BagProductEntity)

    @Query("SELECT * FROM $BAG_PRODUCT_TABLE")
    fun observeBagProducts(): Flow<List<BagProductEntity>>

    @Query("DELETE FROM $BAG_PRODUCT_TABLE WHERE quantity=0")
    fun deleteEmptyBagProducts()

    @Query("SELECT * FROM $BAG_PRODUCT_TABLE WHERE quantity=:id")
    fun deleteBagProduct(id: String): BagProductEntity

}