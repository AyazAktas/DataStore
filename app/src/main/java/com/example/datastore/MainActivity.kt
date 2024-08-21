package com.example.datastore

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val ap =AppPref(this)

        CoroutineScope(Dispatchers.Main).launch {
            //Kayıt
            ap.kayitAl("ayaz")
            ap.kayitBoy(1.81)
            ap.kayitYas(20)
            ap.kayitBekar(true)
            val liste=HashSet<String>()
            liste.add("Kübra")
            liste.add("Poyraz")
            ap.kayitArkadasListe(liste)

            // Okuma
            val gelenAd=ap.okuAd()
            val gelenBoy=ap.okuBoy()
            val gelenYas=ap.okuYas()
            val gelenBekar=ap.okuBekar()
            Log.e("Okunan Isim: ",gelenAd)
            Log.e("Okunan Yas: ",gelenYas.toString())
            Log.e("Okunan Boy: ",gelenBoy.toString())
            Log.e("Okunan Bekar Bilgisi: ",gelenBekar.toString())

            val gelenListe=ap.okuArkadasListe()
            if (gelenListe != null){
                for (a in gelenListe)
                {
                    Log.e("Okunan Arkadaş:",a)
                }
            }


        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}