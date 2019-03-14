package kdg.be.iwant.activities
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.widget.TextView
import kdg.be.iwant.R
import kdg.be.iwant.adapters.ProductAdapter
import kdg.be.iwant.fragments.WishlistDetailsFragment
import kdg.be.iwant.getProducts
import kdg.be.iwant.getWishlists
import kdg.be.iwant.model.Product
import java.util.*

class WishlistDetailsActivity : AppCompatActivity() {
    private lateinit var rvProducts: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var linearLayoutManager: LinearLayoutManager

    private val selectedProducts = ArrayList<Product>()
    private lateinit var tvName:TextView
    private lateinit var tvTotalPrice:TextView

    private var index:Int = 0

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(kdg.be.iwant.R.menu.menu_default, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist_details)

        val intent: Intent = intent
        val index:Int = intent.getIntExtra("index", 0)
        val fragment:WishlistDetailsFragment = fragmentManager.findFragmentById(R.id.fWishlistDetails)
        fragment.index = index

        if (savedInstanceState == null) {
            this.index = intent.extras!!.getInt("Index")
        }

        initialiseViews()

        linearLayoutManager = LinearLayoutManager(this)
        rvProducts.layoutManager = linearLayoutManager
    }

    private fun initialiseViews(){
        viewManager = LinearLayoutManager(this)


        for (product: Product in getProducts()){
            if (product.wishlistId == getWishlists()[index].id) {
                selectedProducts.add(product)
            }
        }
        viewAdapter = ProductAdapter(selectedProducts)

        rvProducts = findViewById<RecyclerView>(R.id.rvProducts).apply{
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        tvName = findViewById(R.id.tvName)
        tvName.text = getWishlists()[index].name
        tvName.textSize = 20F
        tvName.setTextColor(Color.BLACK)
        tvName.setBackgroundColor(getWishlists()[index].color)

        tvTotalPrice = findViewById(R.id.tvTotalPrice)
        tvTotalPrice.text = String.format("%.2f", calcTotalPrice())

    }

    private fun calcTotalPrice():Double{
        var sum = 0.0

        for(product:Product in selectedProducts) sum += product.quantity * product.pricePerPiece
        return sum
    }
}
