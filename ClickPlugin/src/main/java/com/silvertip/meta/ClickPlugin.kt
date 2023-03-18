package com.silvertip.meta

import com.android.build.api.instrumentation.FramesComputationMode
import com.android.build.api.instrumentation.InstrumentationScope
import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Author: Sakura

 * Date: 2023/3/14

 * Description: 点击劫持插件入口
 */
class ClickPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        println("点击插件开始插入")
        val androidComponents = project.extensions.getByType(AndroidComponentsExtension::class.java)
        androidComponents.onVariants { variant ->
            variant.instrumentation.transformClassesWith(
                ClickClassVisitor::class.java,
                InstrumentationScope.PROJECT
            ) { params ->
                params.config.set(ViewClickConfig())
            }
            variant.instrumentation.setAsmFramesComputationMode(
                FramesComputationMode.COMPUTE_FRAMES_FOR_INSTRUMENTED_METHODS
            )
        }
        println("点击插件插入完成")
    }
}