package im.tox.toktok.app.simple_dialogs

import android.app.{ Activity, Dialog }
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.{ Editable, TextWatcher }
import android.view.View.OnClickListener
import android.view.Window
import im.tox.toktok.TypedResource._
import im.tox.toktok.{ R, TR }
import org.scaloid.common._

final class SimpleAddFriendDialogDesign(
    activity: Activity,
    clickAction: OnClickListener
) extends Dialog(activity, R.style.DialogSlideAnimation) {

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    requestWindowFeature(Window.FEATURE_NO_TITLE)

    setContentView(R.layout.simple_addfriend_dialog_design)
    getWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT))

    val input = this.findView(TR.simple_dialog_input)
    val confirmButton = this.findView(TR.simple_dialog_confirm)

    val cancelButton = this.findView(TR.simple_dialog_cancel)
    cancelButton.onClick {
      dismiss()
    }

    input.addTextChangedListener(new TextWatcher {

      override def beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int): Unit = {}
      override def onTextChanged(s: CharSequence, start: Int, before: Int, count: Int): Unit = {}

      override def afterTextChanged(s: Editable): Unit = {
        confirmButton.setEnabled(true)
        confirmButton.setTextColor(activity.getResources.getColor(R.color.simpleDialogTextButton, null))
        confirmButton.setBackgroundTintList(ColorStateList.valueOf(activity.getResources.getColor(R.color.simpleDialogIconButton, null)))
        confirmButton.setOnClickListener(clickAction)
      }
    })
  }

}
