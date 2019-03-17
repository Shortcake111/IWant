package kdg.be.iwant.fragments

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.support.v4.app.ListFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import kdg.be.iwant.R
import kdg.be.iwant.activities.WishlistsActivity

import kdg.be.iwant.adapters.WishlistAdapter
import kdg.be.iwant.getWishlists

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val KEY_INDEX = "index"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [WishlistsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [WishlistsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class WishlistsFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var index = 0
    private lateinit var listener: WishlistAdapter.OnWishlistSelectedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            index = it.getInt(KEY_INDEX)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_wishlists, container, false)
        //get recyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvWishlists)
        //set layoutManager
        recyclerView.layoutManager = LinearLayoutManager(activity)
        //create adapter
        //FIXME check
        val adapter = WishlistAdapter(getWishlists(), activity, listener)
        //set adapter
        recyclerView.adapter = adapter
        return view
    }

    /*FIXME check
    fun onWishlistSelected(l: ListView?, v: View?, position: Int, id: Long) {
        super.onWishlistSelected(l, v, position, id)
        val activity: WishlistsFragment? = activity
        activity.onWishlistSelected(position)
    }
         */

    //FIXME check
    // TODO: Rename method, update argument and hook method into UI event
    fun onWishlistSelected(index: Int) {
        listener.onWishlistSelected(index)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context as WishlistsActivity
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
        fun onFragmentInteraction(wishlistId: Int)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment WishlistsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(index: Int) =
            WishlistsFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_INDEX, index)
                }
            }
    }
}
