package ca.burchill.cointracker.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface CoinDao {
    @Query("select * from databasecoin")
    fun getCoins(): LiveData<List<DatabaseCoin>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(coins: List<DatabaseCoin>)
}

@Database(entities = [DatabaseCoin::class], version = 1, exportSchema = false)
abstract class CoinsDatabase : RoomDatabase() {
    abstract val coinDao: CoinDao
}

private lateinit var INSTANCE: CoinsDatabase

fun getDatabase(context: Context): CoinsDatabase {
    synchronized(CoinsDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                CoinsDatabase::class.java,
                "coins"
            ).build()
        }
    }
    return INSTANCE
}