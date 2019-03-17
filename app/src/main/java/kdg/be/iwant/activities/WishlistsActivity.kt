package kdg.be.iwant.activities

import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.View
import kdg.be.iwant.R
import kdg.be.iwant.adapters.WishlistAdapter
import kdg.be.iwant.fragments.WishlistDetailsFragment
import kdg.be.iwant.fragments.WishlistsFragment
import kdg.be.iwant.getWishlists

class WishlistsActivity : AppCompatActivity(),WishlistAdapter.OnWishlistSelectedListener , WishlistsFragment.OnFragmentInteractionListener  {
    override fun onFragmentInteraction(wishlistId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var rvWishlists: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var linearLayoutManager: LinearLayoutManager

    var index:Int = 0

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_settings, menu)
        return true
    }

    //FIXME check
    override fun onWishlistSelected(index: Int) {
        /*val wishlist:Intent = Intent(this, WishlistDetailsActivity::class.java)
        wishlistIntent.putExtra("Index", index)
        startActivity(wishlistIntent)*/

        var wishlistDetailsFragment = WishlistDetailsFragment.newInstance(index)
    }

    fun onClickWishlist(wishlistId:Int){
        var fragmentContainer: View = findViewById(R.id.flWishlistDetails)
        val fragment = WishlistDetailsFragment()
        fragment.index = wishlistId
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.flWishlistDetails,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 0){
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_wishlists)

        initialiseViews()

        linearLayoutManager = LinearLayoutManager(this)
        rvWishlists.layoutManager = linearLayoutManager
    }

    private fun initialiseViews(){
        val fragment = WishlistsFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fWishlists, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

        viewManager = LinearLayoutManager(this)
        viewAdapter = WishlistAdapter(getWishlists(), this, listener)

        rvWishlists = findViewById<RecyclerView>(R.id.rvWishlists).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}