package me.saket.transitions

import android.app.ActivityOptions
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    image.setOnClickListener {
      val options = ActivityOptions.makeSceneTransitionAnimation(this, image, "image")
      startActivity(SecondActivity.intent(this), options.toBundle())
    }
  }
}
