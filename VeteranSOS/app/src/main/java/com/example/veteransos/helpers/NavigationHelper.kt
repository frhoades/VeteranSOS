package com.example.veteransos.helpers

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.location.Location
import android.widget.Toast

object NavigationHelper {
    fun goHome(context: Context, location: Location?) {
        val prefs = context.getSharedPreferences("veteran_sos", Context.MODE_PRIVATE)
        val homeLat = prefs.getString("home_lat", null)
        val homeLng = prefs.getString("home_lng", null)

        if (homeLat != null && homeLng != null) {
            val uri = Uri.parse("google.navigation:q=$homeLat,$homeLng")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")
            context.startActivity(intent)
        } else {
            Toast.makeText(context, "Home location not set.", Toast.LENGTH_LONG).show()
        }
    }
}