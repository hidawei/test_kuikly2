# KuiklyCore

## 项目介绍

 `Kuikly`是一个基于 Kotlin 的纯原生跨端 UI 框架。该框架使用 Kotlin Multiplatform 技术自研 DSL 语言，使得开发者可以以一种简单、声明式的方式构建 UI 界面，同时运行在多个平台。目前已支持平台：
- [X] Android
- [X] iOS
- [X] 鸿蒙
- [ ] Web
- [ ] 小程序
- [ ] Desktop
  Kuikly作为KMM技术应用于跨端场景的先行探索者，早期由QQ团队孵化，并经腾讯多团队共建推出的，客户端开发友好的全新跨端解决方案。已广泛应用于QQ、QQ音乐、QQ浏览器、腾讯新闻等产品。
## 特点

- 跨平台：基于 kotlin 跨平台实现多平台一致运行，一码六端。
- 原生性能：运行平台原生编译产物(.aar/.framework)
- 原生体验 & 生态：原生 UI 渲染和 kotlin 原生开发生态
- 轻量：SDK 增量小（AOT模式下，Android：约 300 KB，iOS：约 1.2 MB）
- 动态化：支持编译成动态化产物（.so/.js）
- 多开发范式：类Compose声明式&传统命令式开发范式

## 项目结构

```shell
.
├── core                    # 跨平台模块，实现各个平台响应式 UI、布局算法、Bridge 通信等核心能力
  ├── src
    ├──	commanMain            #	跨平台共享代码、定义跨平台接口 
    ├── androidMain           # Android 平台实现代码 （aar）
    ├── androidNativeMain     # Android Native 平台实现代码（so）
    ├── jvmMain               # 泛 JVM 平台代码（不涉及 Android API）（jar）
    ├── iosMain               # iOS 平台实现代码（framework）
    └── jsMain                # js 平台实现代码（js bundle）
├── core-render-android    # android 平台的渲染器模块
├── core-render-ios        # iOS 平台的渲染器模块
├── core-annotations       # 注解模块，定义业务注解 @Page
├── core-ksp               # 注解处理模块，生成 Core 入口文件 
├── buildSrc               # 编译脚本，用于编译、打包、分包产物相关脚本
├── demo                   # DSL 示例代码 
├── androidApp             # Android 宿主壳工程
└── iosApp                 # iOS 宿主壳工程
```
## 系统要求
- iOS:
- 安卓：
- 鸿蒙：
- Kotlin版本
- 
## 快速上手 

- [快速开发](https://kuikly.woa.com/%E5%BC%80%E5%8F%91%E6%96%87%E6%A1%A3/hello-world.html)
- [接入指引](https://kuikly.woa.com/%E6%8E%A5%E5%85%A5/common.html)
- [组件特性](https://kuikly.woa.com/%E7%BB%84%E4%BB%B6/override.html)
- [Example 工程](https://git.woa.com/Kuikly/KuiklyDemo)

## 常见问题
[Kuikly QA汇总](https://kuikly.woa.com/QA/kuikly-qa.html)

## 开发指南
clone
配置产品依赖版本
Core构建
Render构建
Demo构建

## 行为准则
本README遵循开源治理指标体系介绍-文档质量要求。

## 如何加入
[TDF端框架](https://techmap.woa.com/oteam/8592/talk)

## 团队介绍

## 变更日志

每个发布版本的详细更改记录可在 [CHANGELOG.md](CHANGELOG.md) 进行查看

## 代码贡献

欢迎各位开发者为 `Kuikly` 提出问题或发起 MR，建议你在为 `Kuikly` 贡献代码先阅读 [贡献指引](CONTRIBUTING.md)