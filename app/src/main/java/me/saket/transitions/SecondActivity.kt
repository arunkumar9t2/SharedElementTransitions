package me.saket.transitions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class SecondActivity : AppCompatActivity() {

  companion object {
    fun intent(context: Context): Intent {
      return Intent(context, SecondActivity::class.java)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_second)

    val image = findViewById<View>(R.id.image)
    image.setOnClickListener {
      image.rotation = 20f
    }
  }
}
