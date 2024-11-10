package ru.magic.ui.components.dialogs.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Stable
import ru.magic.ui.contracts.IDialog
import ru.magic.ui.utils.UITitle


// todo::ui(добавить ресурсы в местах использования todoString)
// todo::delete(Удалить после исправления)
val todoString = "TODO: Добавить строковые ресурсы, указать положительный и отрицательные значения по уполчанию"


@Stable
class ApplicationDialog(
    override val title: UITitle,
    override val neutralTitle: UITitle?,
    override val positiveTitle: UITitle,
    override val negativeTitle: UITitle?,
    override val onNegative: (() -> Unit)?,
    override val onPositive: (() -> Unit),
    override val onNeutral: (() -> Unit)?,
    override val onEdited: ((String) -> Unit)?,
    override val type: DialogData,
) : IDialog {

    private constructor(builder: Builder) : this(
        title = builder.title,
        neutralTitle = builder.neutralTitle,
        positiveTitle = builder.positiveTitle,
        negativeTitle = builder.negativeTitle,
        onNegative = builder.onNegative,
        onPositive = builder.onPositive,
        onNeutral = builder.onNeutral,
        onEdited = builder.onEdited,
        type = builder.type
    )

    class Builder {
        var title: UITitle = UITitle.UIString("")
            private set
        var positiveTitle: UITitle = UITitle.UIString("")
            private set
        var negativeTitle: UITitle? = null
            private set
        var neutralTitle: UITitle? = null
            private set
        var onPositive: () -> Unit = {}
            private set
        var onNegative: (() -> Unit)? = null
            private set
        var onNeutral: (() -> Unit)? = null
            private set

        var onEdited: ((String) -> Unit)? = null
            private set
        var onEditedWithTwoFields: ((String, String) -> Unit)? = null
            private set

        var type : DialogData = DialogData.Default
            private set

        fun setTitle(title: String) = apply { this.title = UITitle.UIString(title) }
        fun setTitle(title: UITitle) = apply { this.title = title }
        fun setTitle(@StringRes id: Int) = apply { this.title = UITitle.UIRes(id) }

        fun setPositiveButton(title: UITitle, action: () -> Unit) = apply {
            this.onPositive = action
            this.positiveTitle = title
        }

        fun setPositiveButton(title: String, action: () -> Unit) = apply {
            this.onPositive = action
            this.positiveTitle = UITitle.UIString(title)
        }

        fun setPositiveButton(@StringRes title: Int, action: () -> Unit) = apply {
            this.onPositive = action
            this.positiveTitle = UITitle.UIRes(title)
        }

        fun setEditPositiveButton(@StringRes title: Int, action: ((String) -> Unit)) = apply {
            this.onEdited = action
            this.positiveTitle = UITitle.UIRes(title)
        }

        fun setEditWithTwoFieldsPositiveButton(@StringRes title: Int, action: ((String, String) -> Unit)) = apply {
            this.onEditedWithTwoFields = action
            this.positiveTitle = UITitle.UIRes(title)
        }

        fun setNegativeButton(
            title: UITitle = UITitle.UIString(todoString), action: (() -> Unit)? = null
        ) = apply {
            this.onNegative = action
            this.negativeTitle = title
        }

        fun setNegativeButton(
            title: String,
            action: (() -> Unit)? = null
        ) = apply {
            this.onNegative = action
            this.negativeTitle = UITitle.UIString(title)
        }

        fun setNegativeButton(
            @StringRes title: Int,
            action: (() -> Unit)? = null
        ) = apply {
            this.onNegative = action
            this.negativeTitle = UITitle.UIRes(title)
        }

        fun setNeutralButton(title: UITitle, action: () -> Unit) = apply {
            this.onNeutral = action
            this.neutralTitle = title
        }

        fun setNeutralButton(
            title: String,
            action: (() -> Unit)
        ) = apply {
            this.onNeutral = action
            this.negativeTitle = UITitle.UIString(title)
        }

        fun setNeutralButton(
            @StringRes title: Int,
            action: (() -> Unit)
        ) = apply {
            this.onNeutral = action
            this.neutralTitle = UITitle.UIRes(title)
        }

        fun setType(type: DialogData) = apply { this.type = type }
    }
}