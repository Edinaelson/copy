package com.example.copy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.copy.adapters.AlphaAdaptersCopy
import com.example.copy.databinding.ActivityMainBinding
import com.example.copy.model.Copy

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var recyclerView : RecyclerView ? = null
//    private var gridLayoutManager: GridLayoutManager ? = null
    private var arrayList: ArrayList<Copy> ? = null
    val linearLayoutManager = LinearLayoutManager(applicationContext)
    private var alphaAdaptersCopy: AlphaAdaptersCopy ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.my_recycler_view_copy)
        recyclerView?.layoutManager = linearLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        alphaAdaptersCopy = AlphaAdaptersCopy(applicationContext, arrayList!!)
        recyclerView?.adapter = alphaAdaptersCopy


        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
    }

    private fun setDataInList(): ArrayList<Copy>{
        var items:ArrayList<Copy> = ArrayList()

        items.add(Copy(R.drawable.delete,R.drawable.edit,R.drawable.copy,"PagSeguro","07403743385"))
        items.add(Copy(R.drawable.delete,R.drawable.edit,R.drawable.copy,"PagSeguro","07403743385"))
        items.add(Copy(R.drawable.delete,R.drawable.edit,R.drawable.copy,"PagSeguro","07403743385"))
        items.add(Copy(R.drawable.delete,R.drawable.edit,R.drawable.copy,"PagSeguro","07403743385"))
        return items
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.conf -> {
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
                // Lógica adicional para o item "conf" aqui, se necessário
            }
            // Lógica para outros itens de menu aqui, se necessário
        }
        return super.onOptionsItemSelected(item)
    }

}