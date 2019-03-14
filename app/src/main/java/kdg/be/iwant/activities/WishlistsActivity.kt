package kdg.be.iwant.activities

import android.app.FragmentTransaction
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.View
import kdg.be.iwant.R
import kdg.be.iwant.adapters.WishlistAdapter
import kdg.be.iwant.fragments.WishlistDetailsFragment
import kdg.be.iwant.getWishlists

class WishlistsActivity : AppCompatActivity(), WishlistAdapter.OnWishlistSelectedListener  {
    private lateinit var rvWishlists: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_default, menu)
        return true
    }

    override fun onWishlistSelected(index: Int) {
        val wishlistIntent = Intent(this, WishlistDetailsActivity::class.java)
        wishlistIntent.putExtra("Index", index)
        startActivity(wishlistIntent)
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
        setContentView(R.layout.activity_wishlists)

        initialiseViews()

        linearLayoutManager = LinearLayoutManager(this)
        rvWishlists.layoutManager = linearLayoutManager
    }

    private fun initialiseViews(){
        viewManager = LinearLayoutManager(this)
        viewAdapter = WishlistAdapter(getWishlists(), this, this)

        rvWishlists = findViewById<RecyclerView>(R.id.rvWishlists).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
