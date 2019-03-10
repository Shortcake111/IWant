package kdg.be.iwant.adapters

import android.content.Context
import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kdg.be.iwant.R
import kdg.be.iwant.model.Wishlist
import kotlinx.android.synthetic.main.activity_list_item.view.*
import java.util.*


class WishlistAdapter(
    private val wishlistsArray:ArrayList<Wishlist>,
    private val context: Context?,
    private val listener: OnWishlistSelectedListener)
    :RecyclerView.Adapter<WishlistHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): WishlistHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_list_item, parent, false)
        return WishlistHolder(view)
    }

    override fun onBindViewHolder(holder: WishlistHolder, index: Int) {
        val wishlist = wishlistsArray[index]
        val imageid = context?.resources?.getIdentifier(wishlist.icon, "drawable", context.packageName)

        holder.clItem.setBackgroundColor(wishlist.color)
        holder.icon.setImageDrawable(imageid?.let { context?.getDrawable(it) })
        holder.name.text = wishlist.name
        holder.name.setTextColor(Color.BLACK)
        holder.name.textSize = 25F
        val cal:Calendar = GregorianCalendar()
        cal.timeInMillis = wishlist.last_edited.time
        //cal.set(wishlist.last_edited.year, wishlist.last_edited.month, wishlist.last_edited.day)
        holder.edited.text = "Last edited: " + cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DAY_OF_MONTH)/*+ dateToString(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))*/
        holder.edited.setTextColor(Color.BLACK)
        holder.itemView.setOnClickListener {
            listener.onWishlistSelected(index)
        }
    }

    interface OnWishlistSelectedListener {
        fun onWishlistSelected(index: Int)
    }

    override fun getItemCount() = wishlistsArray.size

    private fun dateToString(year:Int, month:Int, day:Int):String{
        var maand = (month+1).toString()

        if (maand.length < 2){
            maand = "0" + maand
        }
        return year.toString().substring(1) + "-" + maand + "-" + day
    }
}

class WishlistHolder(view: View) : RecyclerView.ViewHolder(view) {
    val icon: ImageView = view.ivIcon
    val name: TextView = view.tvTitle
    val edited: TextView = view.tvLastEdited
    val clItem: ConstraintLayout = view.clItem
}