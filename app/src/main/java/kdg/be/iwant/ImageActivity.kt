package kdg.be.iwant

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.widget.ImageView

class ImageActivity : AppCompatActivity() {
    private lateinit var iconIv:ImageView
    private lateinit var imageLayout:ConstraintLayout
    private lateinit var icon: Drawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)


        icon = resources.getDrawable(intent.getIntExtra("icon", R.drawable.controller))
        initialiseViews()
        addEventHandlers()
    }

    private fun initialiseViews(){
        iconIv = findViewById(R.id.iconImageView)
        imageLayout = findViewById(R.id.imageConstraintLayout)

        iconIv.setImageDrawable(icon)
    }

    private fun addEventHandlers(){
        imageLayout.setOnClickListener {
            finish()
        }
    }
}
