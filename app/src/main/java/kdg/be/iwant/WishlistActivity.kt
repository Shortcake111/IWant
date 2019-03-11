package kdg.be.iwant

import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import kdg.be.iwant.adapters.ProductAdapter
import kdg.be.iwant.adapters.WishlistAdapter
import kdg.be.iwant.model.Product

class WishlistActivity : AppCompatActivity() {
    private lateinit var rvProducts: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var ivIcon:ImageView
    private lateinit var clImageLayout:ConstraintLayout
    private lateinit var icon: Drawable
    private lateinit var tvName:TextView

    private var wishlistIndex:Int = 0

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_default, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)

        /*if (savedInstanceState == null) {
            wishlistIndex = intent.extras.getInt("Index")
        }*/

        //icon = resources.getDrawable(intent.getIntExtra("icon", R.drawable.controller))
        initialiseViews()

        linearLayoutManager = LinearLayoutManager(this)
        rvProducts.layoutManager = linearLayoutManager
    }

    private fun initialiseViews(){
        viewManager = LinearLayoutManager(this)
        viewAdapter = ProductAdapter(getProducts(), this)

        rvProducts = findViewById<RecyclerView>(R.id.rvProducts).apply{
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        tvName = findViewById(R.id.tvName)
        tvName.text = getWishlists()[wishlistIndex].name
        tvName.textSize = 20F
        /*ivIcon = findViewById(R.id.iconImageView)
        ivIcon.setImageDrawable(icon)

        clImageLayout = findViewById(R.id.imageConstraintLayout)*/
    }

    private fun addEventHandlers(){
        /*clImageLayout.setOnClickListener {
            finish()
        }*/
    }
}
