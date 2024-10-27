package ru.magic.ui.components.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

/**         todo:ui:dialogs#1
*  * п.1 Составить базовое представление диалога (общее представление для диалогов, которые будут добовляться в будущем)
* можно использовать как просто белую подложку определенного размера (на твой выбор), так и что-то более замудренное
 *  *п.2 Добавить @Preview
 *  * Примечание: полей должно стать больше (клилк на ок, клик на отмену, клик на кнопку по середине и тд)
 *   * Пример:
 *  * title = dialog.title.value(),
 *  onConfirmClick = holder::onConfirm,
 *          confirmTitle = dialog.positiveTitle.value(),
 *          onCancelClick = holder::onCancel,
 *          cancelTitle = dialog.negativeTitle?.value(),
 *          neutralTitle = dialog.neutralTitle?.value(),
 *          onNeutralClick = holder::onNeutral,
 *          onDismissRequest = holder::onDismiss,
 *          type = dialog.mode,
* */
@Composable
internal fun BaseDialog(
    onDismiss : () -> Unit,
    properties: DialogProperties,
    content: @Composable (() -> Unit)? = null
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = properties,
    ) {
        content?.invoke()
    }
}