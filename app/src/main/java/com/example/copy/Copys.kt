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
import com.example.copy.model.Copy

class Copys : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var arrayList: ArrayList<Copy> ? = null
    private var alphaAdaptersCopy: AlphaAdaptersCopy? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_copys)

        recyclerView = findViewById(R.id.my_recycler_copy)
        gridLayoutManager = GridLayoutManager(applicationContext, 1, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        alphaAdaptersCopy = AlphaAdaptersCopy(applicationContext, arrayList!!)
        recyclerView?.adapter = alphaAdaptersCopy

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    private fun setDataInList(): ArrayList<Copy>{
        var items:ArrayList<Copy> = ArrayList()

        items.add(Copy(R.drawable.delete,R.drawable.edit,R.drawable.copy,"PagSeguro CPF","07403743385"))
        items.add(Copy(R.drawable.delete,R.drawable.edit,R.drawable.copy,"PagSeguro CELULAR","86995731474"))
        items.add(Copy(R.drawable.delete,R.drawable.edit,R.drawable.copy,"PagSeguro E-MAIL","sedinaelson@gmail.com"))
        items.add(Copy(R.drawable.delete,R.drawable.edit,R.drawable.copy,"PagSeguro ALEATORIO","db2e2992-689b-476d-9713-b91c67d5613e"))

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