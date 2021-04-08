package ca.burchill.cointracker.UI

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import ca.burchill.cointracker.network.NetworkCoin
import com.bumptech.glide.Glide


@BindingAdapter("coinIcon")
fun bindImage(imgView: ImageView, coinId: Int?) {
    coinId?.let{
        val iconUrl = "https://s2.coinmarketcap.com/static/img/coins/64x64/${it}.png"
        val iconUri = iconUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(iconUri)
            .into(imgView)
    }
}

@BindingAdapter ("coinName")
fun TextView.setName(coin: NetworkCoin?) {
    coin?.let {
        text = "${coin.name} (${coin.symbol})"
    }
}

@BindingAdapter ("coinSummary")
fun TextView.setSummary(coin: NetworkCoin?) {
    coin?.let {
        var tmp = "Price: $%f \n".format(coin.quote.USD.price)
        tmp += "Market Cap: $%f\n".format(coin.quote.USD.market_cap)
        tmp += "Volume/24h: $%f\n".format(coin.quote.USD.volume_24h)
        text = tmp
    }
}

@BindingAdapter ("priceChanges")
fun TextView.setChange(coin: NetworkCoin?) {
    coin?.let {
        var tmp  = "1h:%.2f".format(coin.quote.USD.percent_change_1h)    + "%"
        tmp += "    24h:%.2f".format(coin.quote.USD.percent_change_24h)  + "%"
        tmp += "    7d:%.2f".format(coin.quote.USD.percent_change_7d)    + "%"
        text = tmp
    }
}