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
import kdg.be.iwant.model.Wishlist
import kotlinx.android.synthetic.main.activity_wishlist_item.view.*
import java.util.*

class WishlistAdapter(
    private val wishlistsArray:ArrayList<Wishlist>,
    private val context: Context?,
    private val listener: OnWishlistSelectedListener)
    :RecyclerView.Adapter<WishlistAdapter.WishlistHolder>() {
    private val pdt:SimpleTimeZone = SimpleTimeZone(-8 * 60 * 60 * 1000, TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000)[0])

    override fun onCreateViewHolder(parent: ViewGroup, index: Int): WishlistHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(kdg.be.iwant.R.layout.activity_wishlist_item, parent, false)
        return WishlistHolder(view)
    }

    override fun getItemCount() = wishlistsArray.size

    override fun onBindViewHolder(holder: WishlistHolder, index: Int) {
        val wishlist = wishlistsArray[index]
        val imageid = context?.resources?.getIdentifier(wishlist.icon, "drawable", context.packageName)

        holder.clItem.setBackgroundColor(wishlist.color)
        holder.icon.setImageDrawable(imageid?.let { context?.getDrawable(it) })
        holder.name.text = wishlist.name
        holder.name.setTextColor(Color.BLACK)
        holder.name.textSize = 25F

        pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000)
        pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000)

        val cal:Calendar = GregorianCalendar(pdt)
        cal.timeInMillis = wishlist.last_edited.time
        //cal.set(wishlist.last_edited.year, wishlist.last_edited.month, wishlist.last_edited.day)

        holder.created.text = dateToString("Created", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
        holder.created.setTextColor(Color.BLACK)
        cal.timeInMillis = wishlist.created.time
        holder.edited.text = dateToString("Edited", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
        holder.edited.setTextColor(Color.BLACK)
        holder.itemView.setOnClickListener {
            listener.onWishlistSelected(index)
        }
    }

    interface OnWishlistSelectedListener {
        fun onWishlistSelected(index: Int)
    }

    class WishlistHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon:ImageView = view.ivIcon
        val name:TextView = view.tvTitle
        val created:TextView = view.tvCreated
        val edited:TextView = view.tvEdited
        val clItem:ConstraintLayout = view.clItem
    }

    private fun dateToString(text:String, year:Int, month:Int, day:Int):String{
        var monthString = ""
        if ((month+1).toString().length < 2){
            monthString = "0"
        }
        monthString += (month+1)

        var dayString = ""
        if(day.toString().length < 2){
            dayString = "0"
        }
        dayString += day

        val today = GregorianCalendar(pdt)
        return if (year.equals(today.get(Calendar.YEAR).toString())) {
            String.format("%s: %2s-%2s", text, monthString, dayString)
        } else{
            val yearString:String = year.toString()
            String.format("%s: %2s-%2s-%2s", text, yearString.substring(yearString.length-2, yearString.length), monthString, dayString)
        }
    }
}

