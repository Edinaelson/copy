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
import com.example.copy.adapters.AlphaAdapters
import com.example.copy.databinding.ActivityMainBinding
import com.example.copy.model.AlphaChar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //variaveis do gridLayout
    private var recyclerView: RecyclerView ? = null
    private var gridLayoutManager: GridLayoutManager ? = null
    private var arrayList: ArrayList<AlphaChar> ? = null
    private var alphaAdapters: AlphaAdapters ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //logica para povoar cards
        recyclerView = findViewById(R.id.my_recycler_view)
        gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        alphaAdapters = AlphaAdapters(applicationContext, arrayList!!)
        recyclerView?.adapter = alphaAdapters

        //Toolbar
        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)

    }

    private fun setDataInList() : ArrayList<AlphaChar>{
        var items:ArrayList<AlphaChar> = ArrayList()

        items.add(AlphaChar(R.drawable.note, "A fazer")) // 00
        items.add(AlphaChar(R.drawable.pix, "Chave pix")) // 01
        items.add(AlphaChar(R.drawable.documents, "Documentos")) // 02
        items.add(AlphaChar(R.drawable.password, "Password")) // 03
        items.add(AlphaChar(R.drawable.card, "password cartão")) // 04
        items.add(AlphaChar(R.drawable.links, "Links")) // 05

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