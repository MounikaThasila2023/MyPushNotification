package com.people.app.listview_recycleview

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.people.app.databinding.ActivityRecyclerViewDescriptionBinding

class RecyclerViewDescription : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerViewDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myText =
            "Some Android developers wonder why Google created a view like Recyclerview without a click listener(given the fact that the deprecated ListView has an item click listener).\n" +
                    "\n" +
                    "Because there is no standard way of setting a click listener, new developers tend to confuse on the right way of doing it. In this article, I will show you how to do it in a proper way using an example scenario.\n" +
                    "\n" +
                    "Example Scenario\n" +
                    "There is a Recyclerview adapter with a Recyclerview with a list of items(Users in this case).\n" +
                    "What we want is that when an item is clicked, we get the item’s model(User) information and may be pass it to a second activity.\n" +
                    "Project Creation\n" +
                    "From Android Studio, create an empty android project(Select the Kotlin support option) and name your activity, MainActivity.\n" +
                    "\n" +
                    "Do not bother much if you do not know Kotlin. It is just like Java(somehow).\n" +
                    "Delete the default ‘Hello World’ TextView in activity_main.xml .\n" +
                    "Add recyclerview and cardview dependencies in app level build.gradle file as shown below.\n" +
                    "\n" +
                    "Recyclerview and cardview dependency\n" +
                    "Add recyclerview in activity_main.xml where you removed the textview as shown below.\n" +
                    "\n" +
                    "<android.support.v7.widget.RecyclerView\n" +
                    "    android:layout_width=\"match_parent\"\n" +
                    "    android:id=\"@+id/usersList\"\n" +
                    "    android:layout_height=\"match_parent\"/>\n" +
                    "Ok we are good to go. The assumption is that you have worked with the recyclerview(in Java) before and know how to create a recyclerview adapter.. Next, we create the model class containing username and phone.\n" +
                    "\n" +
                    "Data model\n" +
                    "data class User(var username:String,var phone:String)\n" +
                    "Sweet Kotlin. Just the above line of code gives us access to a setter and getter under the hood and other methods like toString. Check more at https://kotlinlang.org/docs/reference/data-classes.html .\n" +
                    "\n" +
                    "Next, we create our view holder and adapter. Pay attention here because it is the most important part of what this article addresses.\n" +
                    "\n" +
                    "Recyclerview Adapter and view holder\n" +
                    "Create a new Kotlin file called RecyclerAdapter.kt\n" +
                    "Next we create our item_user.xml layout as follows\n" +
                    "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<android.support.v7.widget.CardView app:contentPaddingTop=\"5dp\"\n" +
                    "    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                    "    android:layout_width=\"match_parent\"\n" +
                    "    app:contentPaddingBottom=\"5dp\"\n" +
                    "    app:cardCornerRadius=\"4dp\"\n" +
                    "    android:layout_height=\"match_parent\"\n" +
                    "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                    "    xmlns:tools=\"http://schemas.android.com/tools\">\n" +
                    "    <LinearLayout\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:gravity=\"center\"\n" +
                    "        android:orientation=\"vertical\"\n" +
                    "        android:layout_height=\"wrap_content\">\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:textColor=\"#000\"\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            tools:text=\"Ngenge Senior\"\n" +
                    "            android:id=\"@+id/username\"\n" +
                    "            android:layout_height=\"wrap_content\" />\n" +
                    "        <TextView\n" +
                    "            android:textColor=\"#fff\"\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            tools:text=\"12345678\"\n" +
                    "            android:id=\"@+id/phone\"\n" +
                    "            android:layout_height=\"wrap_content\" />\n" +
                    "    </LinearLayout>\n" +
                    "\n" +
                    "</android.support.v7.widget.CardView>\n" +
                    "The item_user has two textviews which holds the name and phone.\n" +
                    "\n" +
                    "Next we create our view holder. As usual, our view holder has a constructor with an itemView as parameter and we get a reference to our views from item_user layout .\n" +
                    "\n" +
                    "class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)\n" +
                    "{\n" +
                    "    val name = itemView.username\n" +
                    "    val phone = itemView.phone\n" +
                    "\n" +
                    "}\n" +
                    "Then we create our adapter with the list of users as a parameter. An adapter contains the list of users\n" +
                    "\n" +
                    "class RecyclerAdapter(var users:MutableList<User>):RecyclerView.Adapter<MyHolder>() {\n" +
                    "    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyHolder {\n" +
                    "        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)\n" +
                    "        return MyHolder(view)\n" +
                    "    }\n" +
                    "\n" +
                    "    override fun getItemCount(): Int {\n" +
                    "        return users.size\n" +
                    "    }\n" +
                    "\n" +
                    "    override fun onBindViewHolder(myHolder: MyHolder, position: Int) {\n" +
                    "        val user = users.get(position)\n" +
                    "        myHolder.name.text = user.username\n" +
                    "        myHolder.phone.text = user.phone\n" +
                    "        \n" +
                    "    }\n" +
                    "}\n" +
                    "Item Click the bad way\n" +
                    "Note that in onBindView, we can have access to the the current clicked item and thus open a new activity from here and pass our data..\n" +
                    "\n" +
                    "myHolder.itemView.setOnClickListener { \n" +
                    "    //we can then create an intent here and start a new activity\n" +
                    "    //with our data\n" +
                    "}\n" +
                    "This will work perfectly but it is a bad practice because\n" +
                    "\n" +
                    "It is not a good practice opening an Activity from a viewholder context\n" +
                    "Note that onBindViewHolder is called as your views are populated during scrolling. Thus you will have numerous calls to setOnClickListener.\n" +
                    "Let us fix it\n" +
                    "The way that you should do is that you create an ItemClickListener interface with one method ontemClicked with parameter User.\n" +
                    "\n" +
                    "We then pass modify the Adapter’s constructor to take the users list and an OnItemClickListener interface\n" +
                    "class RecyclerAdapter(var users:MutableList<User>, val itemClickListener: OnItemClickListener):RecyclerView.Adapter<MyHolder>() {\n" +
                    "    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyHolder {\n" +
                    "        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)\n" +
                    "        return MyHolder(view)\n" +
                    "\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "    override fun getItemCount(): Int {\n" +
                    "        return users.size\n" +
                    "    }\n" +
                    "\n" +
                    "    override fun onBindViewHolder(myHolder: MyHolder, position: Int) {\n" +
                    "        val user = users.get(position)\n" +
                    "        myHolder.bind(users.get(position),itemClickListener)\n" +
                    "\n" +
                    "\n" +
                    "    }\n" +
                    "}\n" +
                    "We also modify the the ViewHolder to have a bind function which takes a user and itemClick interface as follows."

        binding.myTextView.text = myText
        binding.myTextView.movementMethod = ScrollingMovementMethod()
    }
}