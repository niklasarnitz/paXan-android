package com.swdec.paxan

import android.content.Context
import android.util.Log
import androidx.preference.PreferenceManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class Data(context: Context) {

    private val c = context
    private val queue = Volley.newRequestQueue(c)
    private val prefs = PreferenceManager.getDefaultSharedPreferences(c)
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

    private fun processToDictionaryTitles(callback: DictionaryCallback, response: JSONArray) {
        var titles: Array<String> = arrayOf()
        for (i in 0 until response.length()) {
            titles += response.getJSONObject(i).getString("title")
        }
        callback.onTitlesLoaded(c, titles)
    }

    fun loadDictionaryTitles(callback: DictionaryCallback) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "lexikon", null,
            Response.Listener { response ->
                prefs.edit().putString("cache_lexikon", response.toString()).apply()
                processToDictionaryTitles(callback, response)
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                val cache = prefs.getString("cache_lexikon", DataFallback.lexikon)
                if (cache == "") callback.onTitlesLoaded(c, arrayOf(error))
                else processToDictionaryTitles(callback, JSONArray(cache))
            }
        )
        queue.add(jsonObjectRequest)
    }

    private fun processToDictionaryEntry(callback: DictionaryCallback, response: JSONArray, index: Int) {
        val jsonObject =  response.getJSONObject(index)
        callback.onEntryLoaded(c, jsonObject.getString("title"), jsonObject.getString("description"))
    }

    fun loadDictionaryEntry(callback: DictionaryCallback, index: Int) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "lexikon", null,
            Response.Listener { response ->
                prefs.edit().putString("cache_lexikon", response.toString()).apply()
                processToDictionaryEntry(callback, response, index)
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                val cache = prefs.getString("cache_lexikon", DataFallback.lexikon)
                if (cache == "") callback.onEntryLoaded(c, error, error)
                else processToDictionaryEntry(callback, JSONArray(cache), index)
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
            website: String,
            description: String
        )
    }

    private fun processToSpeakerTitles(callback: SpeakerCallback, response: JSONArray) {
        var titles: Array<String> = arrayOf()
        for (i in 0 until response.length()) {
            titles += response.getJSONObject(i).getString("name")
        }
        callback.onTitlesLoaded(c, titles)
    }

    fun loadSpeakerTitles(callback: SpeakerCallback) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "speaker", null,
            Response.Listener { response ->
                prefs.edit().putString("cache_speaker", response.toString()).apply()
                processToSpeakerTitles(callback, response)
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                val cache = prefs.getString("cache_speaker", DataFallback.speaker)
                if (cache == "") callback.onTitlesLoaded(c, arrayOf(error))
                else processToSpeakerTitles(callback, JSONArray(cache))
            }
        )
        queue.add(jsonObjectRequest)
    }

    private fun processToSpeakerEntry(callback: SpeakerCallback, response: JSONArray, index: Int) {
        val jsonObject =  response.getJSONObject(index)
        callback.onEntryLoaded(
            c,
            jsonObject.getString("name"),
            jsonObject.getString("connection"),
            jsonObject.getString("website"),
            jsonObject.getString("description")
        )
    }

    fun loadSpeakerEntry(callback: SpeakerCallback, index: Int) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "speaker", null,
            Response.Listener { response ->
                prefs.edit().putString("cache_speaker", response.toString()).apply()
                processToSpeakerEntry(callback, response, index)
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                val cache = prefs.getString("cache_speaker", DataFallback.speaker)
                if (cache == "") callback.onEntryLoaded(c, error, error, error, error)
                else processToSpeakerEntry(callback, JSONArray(cache), index)
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
            subtitle: String,
            speaker: String,
            room: String,
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

    private fun processToSeminarTitles(callback: SeminarCallback, response: JSONArray) {
        var titles: Array<String> = arrayOf()
        for (i in 0 until response.length()) {
            titles += response.getJSONObject(i).getString("title")
        }
        callback.onTitlesLoaded(c, titles)
    }

    fun loadSeminarTitles(callback: SeminarCallback) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "seminar", null,
            Response.Listener { response ->
                prefs.edit().putString("cache_seminar", response.toString()).apply()
                processToSeminarTitles(callback, response)
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                val cache = prefs.getString("cache_seminar", DataFallback.seminar)
                if (cache == "") callback.onTitlesLoaded(c, arrayOf(error))
                else processToSeminarTitles(callback, JSONArray(cache))
            }
        )
        queue.add(jsonObjectRequest)
    }

    private fun processToSortedSeminarTitles(callback: AdvancedSeminarCallback, response: JSONArray) {
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
    }

    fun loadSeminarTitlesSorted(callback: AdvancedSeminarCallback) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "seminar", null,
            Response.Listener { response ->
                prefs.edit().putString("cache_seminar", response.toString()).apply()
                processToSortedSeminarTitles(callback, response)
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                val cache = prefs.getString("cache_seminar", DataFallback.seminar)
                if (cache == "") callback.onTitlesLoaded(c, arrayOf(error), arrayOf(error), arrayOf(error))
                else processToSortedSeminarTitles(callback, JSONArray(cache))
            }
        )
        queue.add(jsonObjectRequest)
    }

    private fun processToSeminarEntry(callback: SeminarCallback, response: JSONArray, index: Int) {
        val jsonObject =  response.getJSONObject(index)
        callback.onEntryLoaded(
            c,
            jsonObject.getString("title"),
            jsonObject.getString("subtitle"),
            jsonObject.getString("referentName"),
            jsonObject.getString("roomname"),
            jsonObject.getString("lat"),
            jsonObject.getString("long")
        )
    }

    fun loadSeminarEntry(callback: SeminarCallback, index: Int) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "seminar", null,
            Response.Listener { response ->
                prefs.edit().putString("cache_seminar", response.toString()).apply()
                processToSeminarEntry(callback, response, index)
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                val cache = prefs.getString("cache_seminar", DataFallback.seminar)
                if (cache == "") callback.onEntryLoaded(c, error, error, error, error, error, error)
                else processToSeminarEntry(callback, JSONArray(cache), index)
            }
        )
        queue.add(jsonObjectRequest)
    }

    private fun processToSeminarEntryByTitle(callback: SeminarCallback, response: JSONArray, title: String) {
        for (i in 0 until response.length()) {
            if (response.getJSONObject(i).getString("title") == title) {
                val jsonObject =  response.getJSONObject(i)
                callback.onEntryLoaded(
                    c,
                    jsonObject.getString("title"),
                    jsonObject.getString("subtitle"),
                    jsonObject.getString("referentName"),
                    jsonObject.getString("roomname"),
                    jsonObject.getString("lat"),
                    jsonObject.getString("long")
                )
            }
        }
    }

    fun loadSeminarEntryByTitle(callback: SeminarCallback, title: String) {
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, URL + "seminar", null,
            Response.Listener { response ->
                prefs.edit().putString("cache_seminar", response.toString()).apply()
                processToSeminarEntryByTitle(callback, response, title)
            },
            Response.ErrorListener { e ->
                Log.e(LOG_TAG, e.toString())
                val cache = prefs.getString("cache_seminar", DataFallback.seminar)
                if (cache == "") callback.onEntryLoaded(c, error, error, error, error, error, error)
                else processToSeminarEntryByTitle(callback, JSONArray(cache), title)
            }
        )
        queue.add(jsonObjectRequest)
    }

    companion object {
        private const val URL = "http://app.swdec.de/paxan/"
        private const val LOG_TAG = "Volley"
    }
}