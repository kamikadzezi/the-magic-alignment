package ru.magic.ui.contracts

import ru.magic.ui.components.dialogs.model.DialogData
import ru.magic.ui.utils.UITitle

interface IDialog {
    val title: UITitle
    val positiveTitle: UITitle
    val neutralTitle: UITitle?
    val negativeTitle: UITitle?
    val onNegative: (() -> Unit)?
    val onPositive: (() -> Unit)
    val onNeutral: (() -> Unit)?
    val onEdited: ((String) -> Unit)?
    val type : DialogData
}