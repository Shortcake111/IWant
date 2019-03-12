package kdg.be.iwant.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import kdg.be.iwant.R
import kdg.be.iwant.model.Product
import kotlinx.android.synthetic.main.activity_product_item.view.*
import java.util.ArrayList




class ProductAdapter(
    private val productsArray: ArrayList<Product>)
    : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, index: Int): ProductHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_product_item, parent, false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return productsArray.size
    }

    override fun onBindViewHolder(holder: ProductHolder, index: Int) {
        val product = productsArray[index]

        holder.name.text = product.name
        holder.aantal.setText(product.quantity.toString())
        holder.prijs.setText(String.format("%.2f", product.pricePerPiece))
    }

    class ProductHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name:TextView = view.cbName
        val aantal:EditText = view.etAantal
        val prijs:EditText = view.etPrijs
    }
}