package com.swdec.paxan

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

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
                    titles += response.getJSONObject(i).getString("title")
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

    interface SpeakerCallback {
        fun onTitlesLoaded(
            context: Context,
            titles: Array<String>
        )
        fun onEntryLoaded(
            context: Context,
            title: String,
            organisation: String,
            website: String
        )
    }

    fun loadSpeakerTitles(callback: SpeakerCallback) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "speaker", null,
            Response.Listener { response ->
                var titles: Array<String> = arrayOf()
                for (i in 0 until response.length()) {
                    titles += response.getJSONObject(i).getString("name")
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

    fun loadSpeakerEntry(callback: SpeakerCallback, index: Int) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "speaker", null,
            Response.Listener { response ->
                val jsonObject =  response.getJSONObject(index)
                callback.onEntryLoaded(
                    c,
                    jsonObject.getString("name"),
                    jsonObject.getString("connection"),
                    jsonObject.getString("website")
                )
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                callback.onEntryLoaded(c, error, error, error)
            }
        )
        queue.add(jsonObjectRequest)
    }

    interface SeminarCallback {
        fun onTitlesLoaded(
            context: Context,
            titles: Array<String>
        )
        fun onEntryLoaded(
            context: Context,
            title: String,
            speaker: String,
            room: String,
            description: String,
            lat: String,
            long: String
        )
    }

    interface AdvancedSeminarCallback {
        fun onTitlesLoaded(
            context: Context,
            titles1: Array<String>,
            titles2: Array<String>,
            titles3: Array<String>
        )
    }

    fun loadSeminarTitles(callback: SeminarCallback) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "seminar", null,
            Response.Listener { response ->
                var titles: Array<String> = arrayOf()
                for (i in 0 until response.length()) {
                    titles += response.getJSONObject(i).getString("title")
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

    fun loadSeminarTitlesSorted(callback: AdvancedSeminarCallback) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "seminar", null,
            Response.Listener { response ->
                var titles1: Array<String> = arrayOf()
                var titles2: Array<String> = arrayOf()
                var titles3: Array<String> = arrayOf()
                var jsonObject: JSONObject
                for (i in 0 until response.length()) {
                    jsonObject = response.getJSONObject(i)
                    when {
                        jsonObject.getString("time") == "2020-04-10 15:00:00" -> titles1 += jsonObject.getString("title")
                        jsonObject.getString("time") == "2020-04-10 16:30:00" -> titles2 += jsonObject.getString("title")
                        jsonObject.getString("time") == "2020-04-11 16:30:00" -> titles3 += jsonObject.getString("title")
                    }
                }
                callback.onTitlesLoaded(c, titles1, titles2, titles3)
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                callback.onTitlesLoaded(c, arrayOf(error), arrayOf(error), arrayOf(error))
            }
        )
        queue.add(jsonObjectRequest)
    }

    fun loadSeminarEntry(callback: SeminarCallback, index: Int) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "seminar", null,
            Response.Listener { response ->
                val jsonObject =  response.getJSONObject(index)
                callback.onEntryLoaded(
                    c,
                    jsonObject.getString("title"),
                    jsonObject.getString("referentName"),
                    jsonObject.getString("roomname"),
                    jsonObject.getString("description"),
                    jsonObject.getString("lat"),
                    jsonObject.getString("long")
                )
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                callback.onEntryLoaded(c, error, error, error, error, error, error)
            }
        )
        queue.add(jsonObjectRequest)
    }

    fun loadSeminarEntryByTitle(callback: SeminarCallback, title: String) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "seminar", null,
            Response.Listener { response ->
                for (i in 0 until response.length()) {
                    if (response.getJSONObject(i).getString("title") == title) {
                        val jsonObject =  response.getJSONObject(i)
                        callback.onEntryLoaded(
                            c,
                            jsonObject.getString("title"),
                            jsonObject.getString("referentName"),
                            jsonObject.getString("roomname"),
                            jsonObject.getString("description"),
                            jsonObject.getString("lat"),
                            jsonObject.getString("long")
                        )
                    }
                }
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                callback.onEntryLoaded(c, error, error, error, error, error, error)
            }
        )
        queue.add(jsonObjectRequest)
    }

    companion object {
        private const val URL = "http://app.swdec.de/paxan/"
        private const val LOG_TAG = "Volley"
    }
}