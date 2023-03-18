package com.silvertip.meta

import java.io.Serializable

/**
 * Author: Sakura

 * Date: 2023/3/15

 * Description:
 */
class ViewClickConfig : Serializable {
    /**
     * 要劫持接口列表，若需要新增，则往这里添加即可
     *
     * @return
     */
    fun getHookPointList(): List<ViewClickHookPoint> = listOf(
        ViewClickHookPoint(
            interfaceName = "android/view/View\$OnClickListener",
            methodName = "onClick",
            nameWithDesc = "onClick(Landroid/view/View;)V"
        ),
        ViewClickHookPoint(
            interfaceName = "com/chad/library/adapter/base/listener/OnItemClickListener",
            methodName = "onItemClick",
            nameWithDesc = "onItemClick(Lcom/chad/library/adapter/base/BaseQuickAdapter;Landroid/view/View;I)V"
        ),
        ViewClickHookPoint(
            interfaceName = "com/chad/library/adapter/base/listener/OnItemChildClickListener",
            methodName = "onItemChildClick",
            nameWithDesc = "onItemChildClick(Lcom/chad/library/adapter/base/BaseQuickAdapter;Landroid/view/View;I)V",
        )
    )
}