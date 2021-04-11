package com.yourminifriend.appli

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MoodAdapter(private val list: List<MoodEntity>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var cv = convertView
        if (cv == null) {
            cv = LayoutInflater.from(parent?.context).inflate(R.layout.row_mood, parent, false)
        }

        val mood = list[position]
        val textView = cv?.findViewById<TextView>(R.id.text1View)
        textView?.setText(
            when (mood.mood) {
                Mood.LONELY.ordinal -> R.string.lonely_mood_update
                Mood.TIRED.ordinal -> R.string.tired_mood_update
                Mood.ANGRY.ordinal -> R.string.angry_mood_update
                Mood.SAD.ordinal -> R.string.sad_mood_update
                Mood.NUMB.ordinal -> R.string.numb_mood_update
                Mood.STRESSED.ordinal -> R.string.stressed_mood_update
                Mood.OKAY.ordinal -> R.string.okay_mood_update
                Mood.RELAXED.ordinal -> R.string.relaxed_mood_update
                Mood.EXCITED.ordinal -> R.string.excited_mood_update
                Mood.HOPEFUL.ordinal -> R.string.hopeful_mood_update
                Mood.HAPPY.ordinal -> R.string.happy_mood_update
                Mood.JOYFUL.ordinal -> R.string.joyful_mood_update
                else -> R.string.okay_mood_update
            })

        val text = cv?.findViewById<TextView>(R.id.textView)
        text?.text = mood.date

        return cv
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list.size
    }
}