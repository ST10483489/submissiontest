package ac.za.iie.mypizzahouse

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val rSmall = findViewById<RadioButton>(R.id.rSmall)
        val rMeduim = findViewById<RadioButton>(R.id.rMeduim)
        val rLarge = findViewById<RadioButton>(R.id.rLarge)
        val chkCheese = findViewById<CheckBox>(R.id.chkCheese)
        val chkOilve = findViewById<CheckBox>(R.id.chkOilve)
        val txtResults = findViewById<TextView>(R.id.txtResults)

        btnCalculate.setOnClickListener {
            var total = 0.0

            if (rSmall.isChecked)
            {
                total += 55.99
            }
           else if(rMeduim.isChecked)
            {
               total +=89.99
            }
            else if (rLarge.isChecked)
            {
                total +=119.99
            }

            if (chkCheese.isChecked)
            {
                total +=5.50
            }


            if (chkOilve.isChecked) {
                total += 3.50

            }
            txtResults.text =String.format("Total Amount Due : R%.2f",total)
        }
        btnClear.setOnClickListener {
            txtResults.text = ""

            
        }









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}