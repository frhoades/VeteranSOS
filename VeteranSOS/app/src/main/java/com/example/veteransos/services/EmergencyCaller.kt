package com.example.veteransos.services

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract
import android.telephony.TelephonyManager
import android.widget.Toast

object EmergencyCaller {
    fun startCalling(context: Context) {
        val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val cursor = context.contentResolver.query(uri, null, null, null, null)
        if (cursor != null && cursor.moveToFirst()) {
            val numberIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            val number = cursor.getString(numberIdx)
            val callIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$number"))
            context.startActivity(callIntent)
        } else {
            Toast.makeText(context, "No emergency contact found.", Toast.LENGTH_LONG).show()
        }
        cursor?.close()
    }
}