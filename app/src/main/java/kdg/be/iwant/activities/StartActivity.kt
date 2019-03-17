package kdg.be.iwant.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.Group
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kdg.be.iwant.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        initialiseViews()
        addEventHandlers()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initialiseViews(){
        drawerLayout = findViewById(R.id.drawer)



        val navigationView: NavigationView = findViewById(R.id.navView)
        navigationView.menu.add(R.id.groupMenuItems, R.string.wishlists, 0, R.string.wishlists)
        navigationView.menu.add(R.id.groupMenuItems, R.string.images, 1, R.string.images)
        navigationView.menu.add(R.id.groupMenuItems, R.string.random, 2, R.string.random)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true

            val navViewMenu: Menu = navigationView.menu
            for (index in 0 until navViewMenu.size()){
                if (navViewMenu.getItem(index).itemId != menuItem.itemId){
                    navViewMenu.getItem(index).isChecked = false
                }
            }

            when(menuItem.itemId){
                R.string.wishlists -> {
                    //TODO: add code for switching content based on item pressed
                }
                R.string.images -> {
                    //TODO: add code for switching content based on item pressed
                }
                R.string.random -> {
                    //TODO: add code for switching content based on item pressed
                }
            }

            drawerLayout.closeDrawers()
            true
        }
    }

    private fun addEventHandlers(){
        drawerLayout.addDrawerListener(
            object : DrawerLayout.DrawerListener {
                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    // Respond when the drawer's position changes
                }

                override fun onDrawerOpened(drawerView: View) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    // Respond when the drawer is opened
                }

                override fun onDrawerClosed(drawerView: View) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    // Respond when the drawer is closed
                }

                override fun onDrawerStateChanged(newState: Int) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    // Respond when the drawer motion state changes
                }
            }
        )
    }
}
