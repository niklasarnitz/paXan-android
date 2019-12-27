package com.swdec.paxan

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class Data(context: Context) {

    private val c = context
    private val queue = Volley.newRequestQueue(c)
    private val error = c.resources.getString(R.string.error)

    interface DictionaryCallback {
        fun onTitlesLoaded(
            context: Context,
            titles: Array<String>
        )
        fun onEntryLoaded(
            context: Context,
            title: String,
            description: String
        )
    }

    fun loadDictionaryTitles(callback: DictionaryCallback) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "lexikon", null,
            Response.Listener { response ->
                var titles: Array<String> = arrayOf()
                for (i in 0 until response.length()) {
                    try {
                        titles += response.getJSONObject(i).getString("title")
                    } catch (e: JSONException) {
                        Log.e(LOG_TAG, e.toString())
                    }
                }
                callback.onTitlesLoaded(c, titles)
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                callback.onTitlesLoaded(c, arrayOf(error))
            }
        )
        queue.add(jsonObjectRequest)
    }

    fun loadDictionaryEntry(callback: DictionaryCallback, index: Int) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "lexikon", null,
            Response.Listener { response ->
                val jsonObject =  response.getJSONObject(index)
                callback.onEntryLoaded(c, jsonObject.getString("title"), jsonObject.getString("description"))
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                callback.onEntryLoaded(c, error, error)
            }
        )
        queue.add(jsonObjectRequest)
    }

    companion object {
        private const val URL = "http://app.swdec.de/paxan/"
        private const val LOG_TAG = "Volley"
    }
}