package com.example.countryapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.example.countryapp.adapters.CountryAdapter
import com.example.countryapp.databinding.FragmentCountryBinding
import com.example.countryapp.datas.Country

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CountryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CountryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCountryBinding.inflate(inflater, container, false)
        var countries = mutableListOf<Country>()
        binding.rv.setHasFixedSize(true)
        var adapter = CountryAdapter(add_country(countries))
        binding.rv.adapter = adapter


        val touch = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP, 0) {
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
                return makeMovementFlags(dragFlags, swipeFlags)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.onItemDismiss(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(touch)
        itemTouchHelper.attachToRecyclerView(binding.rv)

        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.rv)
        return binding.root
    }

    fun add_country(list: MutableList<Country>): MutableList<Country> {
        list.add(
            Country(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Flag_of_Uzbekistan.svg/1000px-Flag_of_Uzbekistan.svg.png",
                "Uzbekistan", false
            )
        )
        list.add(
            Country(
                "https://upload.wikimedia.org/wikipedia/en/thumb/4/41/Flag_of_India.svg/1200px-Flag_of_India.svg.png",
                "India", false
            )
        )
        list.add(
            Country(
                "https://upload.wikimedia.org/wikipedia/en/thumb/0/05/Flag_of_Brazil.svg/640px-Flag_of_Brazil.svg.png",
                "Brazil", false
            )
        )
        list.add(
            Country(
                "https://cdn.britannica.com/18/147118-050-7F820ED5/flag-Argentina-2010.jpg",
                "Argentina", false
            )
        )
        list.add(
            Country(
                "https://upload.wikimedia.org/wikipedia/commons/0/0a/Flag_of_Jamaica.svg",
                "Jamaica", false
            )
        )
        list.add(
            Country(
                "https://img5.goodfon.com/wallpaper/nbig/c/cf/italy-italia-flag-of-italy-italian-flag-flag.jpg",
                "Italy", false
            )
        )
        list.add(
            Country(
                "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/800px-Flag_of_Russia.svg.png",
                "Russia", false
            )
        )
        list.add(
            Country(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Flag_of_Denmark_fixed.svg/1200px-Flag_of_Denmark_fixed.svg.png",
                "Denmark", false
            )
        )
        list.add(
            Country(
                "https://upload.wikimedia.org/wikipedia/commons/2/20/Flag_of_the_Netherlands.svg",
                "Netherlands", false
            )
        )
        list.add(
            Country(
                "https://upload.wikimedia.org/wikipedia/commons/8/89/Bandera_de_Espa%C3%B1a.svg",
                "Spain", false
            )
        )
        return list
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CountryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CountryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}