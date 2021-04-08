package ca.burchill.cointracker.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import ca.burchill.cointracker.domain.Coin


/**
 * Database entities go in this file. These are responsible for reading and writing from the
 * database.
 */


/**
 * DatabaseVideo represents a video entity in the database.
 */
@Entity
data class DatabaseCoin constructor(
    @PrimaryKey val id: Int,
    val circulating_supply: Double,
    val cmcRank: Int,
    val date_added: String,
    val max_supply: Double?,
    val name: String,
    val num_market_pairs: Int,
    val slug: String,
    val symbol: String,
    val total_supply: Double,
    val market_cap: Double,
    val percent_change_1h: Double,
    val percent_change_24h: Double,
    val percent_change_30d: Double,
    val percent_change_60d: Double,
    val percent_change_7d: Double,
    val percent_change_90d: Double,
    val price: Double,
    val volume_24h: Double
)


/**
 * Map DatabaseVideos to domain entities
 */
fun List<DatabaseCoin>.asDomainModel(): List<Coin> {
    return map {
        Coin(
            circulating_supply = it.circulating_supply,
            cmcRank = it.cmcRank,
            date_added = it.date_added,
            id = it.id,
            max_supply = it.max_supply,
            name = it.name,
            num_market_pairs = it.num_market_pairs,
            slug = it.slug,
            symbol = it.symbol,
            total_supply = it.total_supply,

            market_cap = it.market_cap,
            percent_change_1h = it.percent_change_1h,
            percent_change_24h = it.percent_change_24h,
            percent_change_30d = it.percent_change_30d,
            percent_change_60d = it.percent_change_60d,
            percent_change_7d = it.percent_change_7d,
            percent_change_90d = it.percent_change_90d,
            price = it.price,
            volume_24h = it.volume_24h
        )
    }
}
