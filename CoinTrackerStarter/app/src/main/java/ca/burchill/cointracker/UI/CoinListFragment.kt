package ca.burchill.cointracker.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ca.burchill.cointracker.R
import ca.burchill.cointracker.databinding.FragmentCoinListBinding
import ca.burchill.cointracker.viewModels.CoinListViewModel


class CoinListFragment : Fragment() {

    private val viewModel: CoinListViewModel by lazy {
        ViewModelProvider(this).get(CoinListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentCoinListBinding.inflate(inflater)
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        val adapter = CoinListAdapter()
        binding.coinList.adapter = adapter

        viewModel.coins.observe(viewLifecycleOwner, Observer {
            it?.let{
                adapter.submitList(it)
            }
        })
        return  binding.root
    }


}