package ca.burchill.cointracker.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Coin(
    val circulating_supply: Double,
    val cmcRank: Int,
    val date_added: String,
    val id: Int,
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

