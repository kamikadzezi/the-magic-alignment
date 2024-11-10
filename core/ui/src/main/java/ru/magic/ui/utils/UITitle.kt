package ru.magic.ui.utils

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.res.stringResource
import kotlinx.collections.immutable.ImmutableList

/**         todo:ui:education#1
 *  * п.1 Ответить на вопрос: Зачем нужен класс UITitle? (Подсказка, может быть связано с дженериками)
 * */

@Stable
interface UIElementWithTitle {
    val title: UITitle
}

@Stable
sealed class UITitle {

    abstract val suffix: String
    abstract val prefix: String

    class UIString(
        val titleString: String, override val suffix: String = "", override val prefix: String = ""
    ) : UITitle()

    class UIRes(
        @StringRes val titleRes: Int, override val suffix: String = "", override val prefix: String = ""
    ) : UITitle()

    class UIList(
        val list: ImmutableList<Int>, override val suffix: String = "", override val prefix: String = ""
    ) : UITitle()

    @Composable
    fun value() = when (this) {
        is UIRes    -> {
            val fromRes = stringResource(id = titleRes)
            "$prefix$fromRes$suffix"
        }

        is UIString -> "$prefix$titleString$suffix"
        is UIList   -> {
            val titleString = StringBuilder()
            list.forEach {
                titleString.append(stringResource(id = it))
                titleString.append(" ")
            }
            "$prefix$titleString$suffix"
        }
    }
}