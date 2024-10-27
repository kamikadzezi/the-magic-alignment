package ru.magic.ui.components.dialogs.model

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@Stable
class ApplicationDialogHolder {
    var currentDialog by mutableStateOf<ApplicationDialog?>(null)
        private set

    private var onCancel: (() -> Unit)? = null
    private var onDismiss: (() -> Unit)? = null
    private var onNeutral: (() -> Unit)? = null
    private var onConfirm: (() -> Unit) = {}

    private var onEdited: ((String) -> Unit)? = null

    internal fun onDismiss() {
        currentDialog = null
        onCancel = null
        onNeutral = null
        onConfirm = {}
        onDismiss?.invoke()
    }

    internal fun onCancel() {
        currentDialog = null
        onCancel?.invoke()
    }

    internal fun onConfirm() {
        currentDialog = null
        onConfirm.invoke()
    }

    internal fun onEdited(value: String) {
        currentDialog = null
        onEdited?.invoke(value)
    }

    internal fun onNeutral() {
        currentDialog = null
        onNeutral?.invoke()
    }

    fun showDialog(dialog: ApplicationDialog) {
        currentDialog = dialog
        this.onConfirm = dialog.onPositive
        this.onCancel = dialog.onNegative
        this.onDismiss = dialog.onNegative
        this.onNeutral = dialog.onNeutral
        this.onEdited = dialog.onEdited
    }

}