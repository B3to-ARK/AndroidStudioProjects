package com.example.teste2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import com.squareup.picasso.Picasso
import okhttp3.*
import okio.IOException
import org.jetbrains.anko.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var listView_details: ListView
    var arrayList_details: ArrayList<Fruits> = ArrayList()
    lateinit var obj_adapter: CustomAdapter
    var vetorpreco : ArrayList<Double> = ArrayList()
    var vetorimage : ArrayList<Double> = ArrayList()

    //CIRA A CONEXAO COM O SERVIDOR
    val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView_details = findViewById<ListView>(R.id.listView) as ListView
        run("https://raw.githubusercontent.com/muxidev/desafio-android/master/fruits.json")
    }

    fun run(url: String) {
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                var str_response = response.body!!.string()

                //CRIA O OBJETO JSON
                val json_contact: JSONObject = JSONObject(str_response)

                //CRIA O ARRAY JSON
                var jsonarray_info: JSONArray = json_contact.getJSONArray("fruits")
                var i: Int = 0
                var size: Int = jsonarray_info.length()
                arrayList_details = ArrayList()
                vetorpreco = ArrayList()
                for (i in 0..size - 1) {
                    var json_objectdetail: JSONObject = jsonarray_info.getJSONObject(i)
                    var fruits: Fruits = Fruits();
                    fruits.name = json_objectdetail.getString("name")
                    fruits.image = json_objectdetail.getString("image")
                    fruits.price = json_objectdetail.getDouble("price")
                    arrayList_details.add(fruits)
                    vetorpreco.add(fruits.price)
                }

                runOnUiThread {
                    //FAZ UPDATE NA UI
                    obj_adapter = CustomAdapter(applicationContext, arrayList_details)
                    listView_details.adapter = obj_adapter
                }
                doAsync {
                    listView_details.setOnItemClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->

                        var b = precoJNI(arrayList_details.get(position).price)

                        var text = """Valor (dollar): ${arrayList_details.get(position).price} 
                                                       
Valor (reais): $b
                        """.trimIndent()

                        alert {
                            title = "${arrayList_details.get(position).name}"
                            customView {
                                 linearLayout{
                                    val iv = imageView()
                                    Picasso.get().load(arrayList_details.get(position).image).into(iv as ImageView)
                                    textView(text)
                                    padding = dip(20)
                                }
                            }
                        }.show()
                        //retorno indicando que o click foi realizado com sucesso
                        true
                    }
                }

            }
        })
    }



    external fun precoJNI(a:Double): Double

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }

    }

}


