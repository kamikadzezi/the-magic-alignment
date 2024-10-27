package ru.magic.ui.components.dialogs.model

import androidx.compose.runtime.Stable

@Stable
sealed class DialogData {
    object Default : DialogData()
}