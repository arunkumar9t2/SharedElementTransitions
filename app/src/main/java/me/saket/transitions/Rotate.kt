package me.saket.transitions

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.transition.Transition
import android.transition.TransitionValues
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

/**
 * This transition captures the rotation property of targets before and after
 * the scene change and animates any changes.
 *
 * Copied from AOSP because it's private there for some reason
 */
class Rotate(context: Context, attrs: AttributeSet) : Transition(context, attrs) {

  override fun captureStartValues(transitionValues: TransitionValues) {
    val view = transitionValues.view
    transitionValues.values[PROPNAME_ROTATION] = view.rotation
  }

  override fun captureEndValues(transitionValues: TransitionValues) {
    // I don't understand how this works, but captureStartValues()
    // and captureEndValues() get called at the same time, resulting
    // in capturing 0 delta and skipping animation. Overriding this
    // with 0 until I figure out what's happening.
    transitionValues.values[PROPNAME_ROTATION] = 0F
  }

  override fun createAnimator(
      sceneRoot: ViewGroup,
      startValues: TransitionValues?,
      endValues: TransitionValues?
  ): Animator? {
    if (startValues == null || endValues == null) {
      return null
    }

    val view = endValues.view
    val startRotation = startValues.values[PROPNAME_ROTATION] as Float
    val endRotation = endValues.values[PROPNAME_ROTATION] as Float
    if (startRotation != endRotation) {
      view.rotation = startRotation
      return ObjectAnimator.ofFloat(view, View.ROTATION, startRotation, endRotation)
    }
    return null
  }

  companion object {
    private const val PROPNAME_ROTATION = "android:rotate:rotation"
  }
}
