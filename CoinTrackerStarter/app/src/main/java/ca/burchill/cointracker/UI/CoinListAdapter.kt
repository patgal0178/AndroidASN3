package ca.burchill.cointracker.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ca.burchill.cointracker.R
import ca.burchill.cointracker.databinding.CoinItemBinding
import ca.burchill.cointracker.network.NetworkCoin

class CoinListAdapter : ListAdapter<NetworkCoin, CoinListAdapter.ViewHolder>(CoinDiffCallback()) {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinListAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: CoinItemBinding) : RecyclerView.ViewHolder( binding.root) {

        fun bind(item: NetworkCoin) {
            binding.coin  = item
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CoinItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class CoinDiffCallback : DiffUtil.ItemCallback<NetworkCoin>() {
    override fun areItemsTheSame(oldItem: NetworkCoin, newItem: NetworkCoin) =
        newItem.id == oldItem.id

    override fun areContentsTheSame(oldItem: NetworkCoin, newItem: NetworkCoin) =
        newItem == oldItem
}