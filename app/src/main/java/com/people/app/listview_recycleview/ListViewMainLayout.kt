package com.people.app.listview_recycleview

import android.os.Bundle
import android.util.Log
import android.widget.ListAdapter
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import com.people.app.R
import com.people.app.databinding.ListViewMainLayoutBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class ListViewMainLayout : AppCompatActivity() {
    lateinit var binding: ListViewMainLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListViewMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jsonStr = listData
        try {
            val userList = ArrayList<HashMap<String, String?>>()
            val jsonObject = JSONObject(loadJSONFromAsset())
            val jsonArray = jsonObject.getJSONArray("users")

            for (i in 0 until jsonArray.length()) {
                val user = HashMap<String, String?>()
                val obj = jsonArray.getJSONObject(i)

                user["name"] = obj.getString("name")
                user["designation"] = obj.getString("designation")
                user["location"] = obj.getString("location")
                userList.add(user)
            }

            val adapter: ListAdapter = SimpleAdapter(
                this, userList, R.layout.list_description_activity,
                arrayOf("name", "designation", "location"), intArrayOf(
                    R.id.name,
                    R.id.designation,
                    R.id.location
                )
            )
            binding.listView.adapter = adapter
        } catch (ex: JSONException) {
            Log.e("JsonParser Example", "unexpected JSON exception", ex)
        }
    }

    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("users_list.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }

    private val listData: String
        get() = (
                "{ \"users\" :[" +
                "{\"name\":\"Ace\",\"designation\":\"Engineer\",\"location\":\"New York\"}" +
                ",{\"name\":\"Tom\",\"designation\":\"Director\",\"location\":\"Chicago\"}" +
                ",{\"name\":\"Tim\",\"designation\":\"Charted Accountant\",\"location\":\"Sunnyvale\"}] }")
}


//        val arrayAdapter: ArrayAdapter<*>
//        val users = arrayOf(
//            "Virat Kohli", "Rohit Sharma", "Steve Smith",
//            "Kane Williamson", "Ross Taylor"
//        )
//
//        arrayAdapter = ArrayAdapter(
//            this,
//            R.layout.list_description_activity, users
//        )
//        binding.listView.adapter = arrayAdapter
//
//        binding.listView.onItemClickListener =
//            AdapterView.OnItemClickListener { parent, view, position, id ->
//                val intent = Intent(this, ListDescription::class.java)
//                startActivity(intent)
//            }
//    }
//}