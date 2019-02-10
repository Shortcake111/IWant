package kdg.be.iwant

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SettingsActivity : AppCompatActivity() {
    private lateinit var profile:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        initialiseViews()
        addEventHandlers()
    }

    private fun initialiseViews(){
        profile = findViewById(R.id.profileImageView)
        profile.setImageDrawable(resources.getDrawable(R.drawable.profilepic))
    }

    private fun addEventHandlers(){

    }
}
