package com.example.desafiomuxi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import okio.IOException
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.indeterminateProgressDialog
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dialog = indeterminateProgressDialog("Aguarde", "")

        dialog.show()

        val mRecyclerView: RecyclerView = this.findViewById<RecyclerView>(R.id.recycler)
        var mAdapter: LineAdapter
        val arrayList_details: ArrayList<Fruits> = ArrayList()
        val client = OkHttpClient()

        val layoutManager = GridLayoutManager(applicationContext, 2)
        (mRecyclerView as RecyclerView).layoutManager = layoutManager

        val request = Request.Builder()
            .url("https://raw.githubusercontent.com/muxidev/desafio-android/master/fruits.json").build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                }

                override fun onResponse(call: Call, response: Response) {
                    val str_response = response.body!!.string()

                    val json_contact: JSONObject = JSONObject(str_response)

                    val jsonarray_info: JSONArray = json_contact.getJSONArray("fruits")
                    var urlcerto: String
                    val size: Int = jsonarray_info.length()
                    for (i in 0..size - 1) {
                        val json_objectdetail: JSONObject = jsonarray_info.getJSONObject(i)
                        urlcerto = json_objectdetail.getString("image").replace("http", "https")
                        urlcerto = urlcerto.replace("httpss", "https")
                        val fruits = Fruits(
                                json_objectdetail.getString("name"),
                                urlcerto,
                                json_objectdetail.getDouble("price")
                        )
                        arrayList_details.add(fruits)
                    }

                    runOnUiThread {
                        mAdapter = LineAdapter(arrayList_details)
                        mRecyclerView.adapter = mAdapter
                    }
                    dialog.dismiss()
                }
            })

            mRecyclerView.addItemDecoration(
                    DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))

            mRecyclerView.addItemDecoration(
                    DividerItemDecoration(this@MainActivity, DividerItemDecoration.HORIZONTAL))

        doAsync {

            mRecyclerView.onItemClick { recyclerView, position, v ->

                val intent = Intent(this@MainActivity, TelaFruta::class.java)

                val b = precoJNI(arrayList_details.get(position).price)

                var nome = "${arrayList_details.get(position).name}"


                val text = """Valor (dollar): ${arrayList_details.get(position).price}
                                                       
Valor (reais): $b
                        """.trimIndent()

                val imag = arrayList_details.get(position).image

                intent.putExtra("nome", nome)

                intent.putExtra("text", text)

                intent.putExtra("imag", imag)

                startActivity(intent)

            }

        }

    }



    external fun precoJNI(a: Double): Double

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}


