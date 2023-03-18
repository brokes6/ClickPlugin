package com.silvertip.meta

import java.io.Serializable

/**
 * Author: Sakura

 * Date: 2023/3/15

 * Description:
 */

data class ViewClickHookPoint(
    /**
     * 接口名称
     */
    val interfaceName: String,
    /**
     * 方法名称
     */
    val methodName: String,
    /**
     * 方法内容
     */
    val nameWithDesc: String,
) : Serializable {
    val interfaceSignSuffix = "L$interfaceName;"
}