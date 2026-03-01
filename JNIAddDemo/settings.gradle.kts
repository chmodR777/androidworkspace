pluginManagement {
    repositories {
        // 1. 优先添加阿里云Gradle插件镜像源（适配kotlin脚本）
        maven("https://maven.aliyun.com/repository/gradle-plugin/") {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }

        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        // 阿里云公共镜像（替代mavenCentral）
        maven("https://maven.aliyun.com/repository/public/")
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // 2. 依赖下载优先用阿里云镜像
        maven("https://maven.aliyun.com/repository/google/") // 谷歌库镜像
        maven("https://maven.aliyun.com/repository/public/") // 公共库镜像

        google()
        mavenCentral()
    }
}

rootProject.name = "JNIAddDemo"
include(":app")
