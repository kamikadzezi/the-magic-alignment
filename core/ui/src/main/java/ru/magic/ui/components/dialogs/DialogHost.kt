package ru.magic.ui.components.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import ru.magic.ui.components.dialogs.model.ApplicationDialogHolder
import ru.magic.ui.components.dialogs.model.DialogData

/**         todo:ui:dialogs#3
 *  * п.1 Добавить новый тип Attention
 *  * п.2 Добавить @Preview
 *   @see ru.magic.ui.components.dialogs.model.DialogData.kt
 * */

@Composable
fun DialogHost(
    dialog : ApplicationDialogHolder
) {
    dialog.currentDialog?.let { current ->
        when(current.type) {
            DialogData.Default -> ApplicationDialog(
                onDismiss = {},
                properties = DialogProperties()
            )
        }
    }
}