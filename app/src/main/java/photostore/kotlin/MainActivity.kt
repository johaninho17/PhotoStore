package photostore.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var image: ImageView? = null
    private var text: TextView? = null
    private var imageArray = mutableListOf<Int>()
    private var textArray = mutableListOf<String>()
    private var currentIndex: Int = 0
    private var startIndex: Int = 0
    private var endIndex: Int = 9

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating car classes
        var AstonMartin = Car("Aston Martin Victor Static",3000000.00f, R.drawable.aston_martin_victor_static)
        var BugattiChrion = Car("Bugatti Chiron Pur Sport",3600000.00f, R.drawable.bugatti_chiron_pur_sport)
        var MercedesAmg = Car("Mercedes AMG Project One",2700000.00f, R.drawable.mercedes_amg_project_one)
        var CyberTruck = Car("Tesla CyberTruck",39000.00f, R.drawable.cybertruck)
        var MaseratiQuat = Car("Maserati Quattroporte",143259.00f, R.drawable.maserati_quattroporte)
        var LamboUrus = Car("Lamborghini Urus SUV",207326.00f, R.drawable.lambo_suv)
        var Maybach = Car("Mercedes Maybach Class S",1730000.00f, R.drawable.mercedesmaybach)
        var RollsR = Car("Rolls Royce Boat Tail",28000000.00f, R.drawable.rolls_royce_boat_tail)
        var Mclaren = Car("McLaren Elva",1700000.00f, R.drawable.mclaren_elva)
        var Gwagon = Car("Mercedes-Maybach G650 Landaulet",1800000.00f, R.drawable.gwagon)

        //inserting car drawable images into image array
        image = findViewById(R.id.image)
        imageArray.add(AstonMartin.carSrc)
        imageArray.add(BugattiChrion.carSrc)
        imageArray.add(MercedesAmg.carSrc)
        imageArray.add(CyberTruck.carSrc)
        imageArray.add(MaseratiQuat.carSrc)
        imageArray.add(LamboUrus.carSrc)
        imageArray.add(Maybach.carSrc)
        imageArray.add(RollsR.carSrc)
        imageArray.add(Mclaren.carSrc)
        imageArray.add(Gwagon.carSrc)

        //inserting car listing information into text array
        text = findViewById(R.id.imagetext)
        textArray.add("The ${AstonMartin.carName}\n priced at $${AstonMartin.carPrice}")
        textArray.add("The ${BugattiChrion.carName}\n priced at $${BugattiChrion.carPrice}")
        textArray.add("The ${MercedesAmg.carName}\n priced at $${MercedesAmg.carPrice}")
        textArray.add("The ${CyberTruck.carName}\n priced at $${CyberTruck.carPrice}")
        textArray.add("The ${MaseratiQuat.carName}\n priced at $${MaseratiQuat.carPrice}")
        textArray.add("The ${LamboUrus.carName}\n priced at $${LamboUrus.carPrice}")
        textArray.add("The ${Maybach.carName}\n priced at $${Maybach.carPrice}")
        textArray.add("The ${RollsR.carName}\n priced at $${RollsR.carPrice}")
        textArray.add("The ${Mclaren.carName}\n priced at $${Mclaren.carPrice}")
        textArray.add("The ${Gwagon.carName}\n priced at $${Gwagon.carPrice}")

        //base start image and text
        image!!.setImageResource(imageArray[currentIndex])
        text!!.setText(textArray[currentIndex])

        //buttons to manipulate page
        var buy: Button = findViewById(R.id.buy) //takes you to next page
        var next: Button = findViewById(R.id.next) //to next car
        var previous: Button = findViewById(R.id.previous) //to previous car

        next.setOnClickListener(){
            nextImage()
        }

        previous.setOnClickListener(){
            previousImage()
        }

        //initiating of the next page to show the car that was bought
        val buypage = Intent(this, PhotoActivity::class.java)
        buy.setOnClickListener() {
            //intent.putIntegerArrayListExtra("key", value)
            buypage.putExtra("carSrc", imageArray[currentIndex] )
            println(imageArray[currentIndex])
            buypage.putExtra("carInfo", "${textArray[currentIndex]}" )

            startActivity(buypage)
        }
    }

    //gets next image from image to text array
    private fun nextImage() {
        currentIndex++

        if (currentIndex >= endIndex) {
            currentIndex = startIndex
            image!!.setImageResource(imageArray[currentIndex])
            text!!.setText(textArray[currentIndex])
        }
        else{
            image!!.setImageResource(imageArray[currentIndex])
            text!!.setText(textArray[currentIndex])
        }
    }

    //gets previous image and text from image array
    private fun previousImage() {
        currentIndex--

        if (currentIndex < startIndex) {
            currentIndex = endIndex
            image!!.setImageResource(imageArray[currentIndex])
            text!!.setText(textArray[currentIndex])
        }
        else{
            image!!.setImageResource(imageArray[currentIndex])
            text!!.setText(textArray[currentIndex])
        }
    }
}

//car class (Photo Product)
class Car{
    var carName: String
    var carPrice: Float
    var carSrc: Int //drawable


    constructor(Name: String, Price: Float, Src: Int){
        this.carName = Name
        this.carPrice = Price
        this.carSrc = Src
    }
}

