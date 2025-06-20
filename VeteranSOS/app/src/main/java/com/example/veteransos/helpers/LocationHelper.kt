package com.example.veteransos.helpers

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class LocationHelper(private val context: Context) {
    private val fusedClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    fun getLastKnownLocation(): Location? {
        var result: Location? = null
        try {
            fusedClient.lastLocation.addOnSuccessListener {
                result = it
            }
        } catch (e: Exception) {
            Log.e("LocationHelper", "Location fetch failed: ${e.localizedMessage}")
        }
        return result
    }
}