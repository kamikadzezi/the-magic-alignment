package ru.magic.ui.components.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties

/**            todo:ui:dialogs#2
 *  * п.1  ApplicationDialog будет хранить в себе все параметры по умолчанию для диалога, является просто оберткой
 *  * п.2 Добавить @Preview
 **/
@Composable
fun ApplicationDialog(
    onDismiss : () -> Unit,
    properties: DialogProperties,
) {
    BaseDialog(
        onDismiss = onDismiss,
        properties = properties
    )
}