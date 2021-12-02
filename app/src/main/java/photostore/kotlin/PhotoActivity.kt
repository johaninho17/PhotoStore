package photostore.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        //buttton and text which show up on xml
        var image: ImageView = findViewById(R.id.image)
        var text: TextView = findViewById(R.id.imagetext)
        var close: Button = findViewById(R.id.close)

        //gets car image src/drawable
        var carSrc: Int = getIntent().getExtras()!!.getInt("carSrc")

        //sets image and text from previous page with intent
        image!!.setImageResource(carSrc)
        text!!.setText("Congragulations for the purchasing \n ${intent.getStringExtra("carInfo")}")

        //closes the second page(buy page) to show original page
        close.setOnClickListener(){
            finish()
        }
    }
}