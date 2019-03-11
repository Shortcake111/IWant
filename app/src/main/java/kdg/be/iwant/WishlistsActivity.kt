package kdg.be.iwant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import kdg.be.iwant.adapters.WishlistAdapter

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
        val wishlistIntent = Intent(this, WishlistActivity::class.java)
        wishlistIntent.putExtra("Index", index)
        startActivity(wishlistIntent)
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
