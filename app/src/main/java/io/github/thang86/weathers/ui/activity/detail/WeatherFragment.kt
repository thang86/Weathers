package io.github.thang86.weathers.ui.activity.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.github.thang86.weathers.R
import io.github.thang86.weathers.domain.model.Address

/**
 * A simple [Fragment] subclass.
 */
class WeatherFragment : Fragment() {
    private lateinit var  mAddress: Address

    companion object {
        fun newInstance(address: Address): WeatherFragment {
            val args = Bundle()
            args.putParcelable("address", address)
            val fragment = WeatherFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if (bundle == null || !bundle.containsKey("address")) {
            return
        } else {
            mAddress = bundle.getParcelable("address")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val view1 = view.findViewById<View>(R.id.header_layout)
        val address = view1.findViewById<TextView>(R.id.location_header_tv)
        val temperatureHeader = view1.findViewById<TextView>(R.id.tv_temperature_header)
        address.text = mAddress.address
        temperatureHeader.text = mAddress.temperature
    }

}
