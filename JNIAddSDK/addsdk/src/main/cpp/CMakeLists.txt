cmake_minimum_required(VERSION 3.22.1)

# 定义项目名称（自定义，如addsdk）
project("addsdk")

# 1. 创建共享库（最终生成的so库，名称为addnative，对应Java中System.loadLibrary("addnative")）
add_library(
        # 库名称（关键：后续Java加载时要和这个名称一致）
        addnative

        # 库类型：SHARED（动态库，生成.so文件）
        SHARED

        # 要编译的C++文件路径
        native-lib.cpp)

# 2. 链接Android的log库（可选，用于C++中打印日志，方便调试）
find_library(
        # 日志库的别名
        log-lib

        # 日志库的名称
        log)

# 3. 将log库链接到我们的共享库
target_link_libraries(
        # 要链接的库名称（和上面add_library的名称一致）
        addnative

        # 日志库
        ${log-lib})