package com.yourminifriend.appli

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SwipeRight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_right)

        val moods = arrayOf<Button>(
            findViewById(R.id.lonely_mood),
            findViewById(R.id.tired_mood),
            findViewById(R.id.angry_mood),
            findViewById(R.id.sad_mood),
            findViewById(R.id.numb_mood),
            findViewById(R.id.stressed_mood),
            findViewById(R.id.okay_mood),
            findViewById(R.id.relaxed_mood),
            findViewById(R.id.excited_mood),
            findViewById(R.id.hopeful_mood),
            findViewById(R.id.happy_mood),
            findViewById(R.id.joyful_mood)
        )

        var moodForToday: MoodEntity? = null

        val db = MoodApp.db
        db?.let {
            GlobalScope.launch {
                val moodsForToday = db.moodDao().byDate(today())
                moodForToday = when (moodsForToday.count()) {
                    0 -> null
                    1 -> moodsForToday.first()
                    else -> moodsForToday.last()
                }

                launch(Main) {
                    val currentMood = moodForToday
                    currentMood?.let {
                        val moodIndex = currentMood.mood
                        moods.forEachIndexed { index, Button ->
                            Button.isSelected = index == moodIndex
                        }
                    }
                }
            }
        }

        val onClickListener = View.OnClickListener { view ->
            db?.let {
                GlobalScope.launch {
                    if (moodForToday != null) {
                        moodForToday!!.mood = moodForView(view.id).ordinal
                        db.moodDao().update(moodForToday!!)

                        launch(Main) {
                            Toast.makeText(applicationContext, R.string.updated, Toast.LENGTH_SHORT)
                                .show()
                        }
                    } else {
                        val newMood = MoodEntity(mood = moodForView(view.id).ordinal)
                        db.moodDao().insert(newMood)
                        moodForToday = newMood

                        launch(Main) {
                            Toast.makeText(applicationContext, R.string.saved, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                    launch(Main) {
                        val selectedMood = moods.indexOf(view)
                        moods.forEachIndexed { index, Button ->
                            Button.isSelected = index == selectedMood
                        }
                    }
                }
            }
        }

        moods.forEach { button ->
            button.isSelected = false
            button.setOnClickListener(onClickListener)
        }
    }

    private fun moodForView(id: Int): Mood {
        return when (id) {
            R.id.lonely_mood -> Mood.LONELY
            R.id.tired_mood -> Mood.TIRED
            R.id.angry_mood -> Mood.ANGRY
            R.id.sad_mood -> Mood.SAD
            R.id.numb_mood -> Mood.NUMB
            R.id.stressed_mood -> Mood.STRESSED
            R.id.okay_mood -> Mood.OKAY
            R.id.relaxed_mood -> Mood.RELAXED
            R.id.excited_mood -> Mood.EXCITED
            R.id.hopeful_mood -> Mood.HOPEFUL
            R.id.happy_mood -> Mood.HAPPY
            R.id.joyful_mood -> Mood.JOYFUL
            else -> Mood.OKAY
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.mood_list -> {
                startActivity(Intent(this, MoodListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
