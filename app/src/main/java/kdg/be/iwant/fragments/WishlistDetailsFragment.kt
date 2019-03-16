package kdg.be.iwant.fragments

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kdg.be.iwant.R
import kdg.be.iwant.adapters.ProductAdapter
import kdg.be.iwant.adapters.WishlistAdapter
import kdg.be.iwant.getProducts
import kdg.be.iwant.getWishlists

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val KEY_INDEX = "index"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [WishlistDetailsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [WishlistDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class WishlistDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var index: Int = 0
    private lateinit var listener: ProductAdapter.OnProductSelectedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            index = it.getInt("index")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_wishlist_details, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvProducts)
        val layoutManager = LinearLayoutManager(this.activity)
        recyclerView.setLayoutManager(layoutManager)

        val adapter = ProductAdapter(getProducts())
        recyclerView.setAdapter(adapter)
        return view
        //return inflater.inflate(R.layout.fragment_wishlist_details, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onWishlistSelected(wishlistDetail: Int) {
        listener.onFragmentInteraction(wishlistDetail)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(wishlistIndex: Int)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment WishlistDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(index: Int):WishlistDetailsFragment {
            val fragment = WishlistDetailsFragment()
            val args = Bundle()
            args.putInt(KEY_INDEX, index)
            fragment.arguments = args

            return fragment

            /*WishlistDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_INDEX, index)
                }
            }*/
        }
    }
}
