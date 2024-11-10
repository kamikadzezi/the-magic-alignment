package ru.magic.ui.contracts

import org.orbitmvi.orbit.ContainerHost

/**         todo:ui:education#2
 *  * п.1 Разобраться в логике работы классов абстракции
 * */

interface ScreenContract<
        STATE : ContainerContract.StateContract,
        EFFECT : ContainerContract.EffectContract,
        ACTION : ContainerContract.ActionContract
        > : ContainerHost<STATE,EFFECT> {

    fun action(action: ACTION)
}