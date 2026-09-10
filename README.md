# FLIT

<div align="center">
  <img src="docs/newest_app_icon.png" alt="LastChat Icon" width="128" height="128" />
</div>

**FLIT** 是一款功能丰富的 Android LLM 客户端。它是 [RikkaHub](https://github.com/re-ovo/RikkaHub) 的分支 [LastChat](https://github.com/Cocolalilal/LastChat) 的分支版本，在原有的基础上增加了一些特色功能。

本项目旨在为 Android 平台提供一个注重隐私且高度个性化的 AI 聊天体验。

## 图集

<div align="center">
  <img src="docs/chat.jpg" alt="聊天界面" width="200" />
    &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/settings.jpg" alt="设置" width="200" />
</div>

## ✨ 核心特性

### 先进的 AI 能力
*   **多服务商支持**: 原生支持 **OpenAI**、**Google** 和 **OpenRouter** 等，配合**多 Key 轮换**提升可用性。
*   **Codex 订阅支持**: 支持使用 ChatGPT 设备码登录并且使用 Codex 订阅额度。
*   **多档位推理 & 能力同步**: 提供多档推理强度；模型能力数据库可从远端自动同步。
*   **更好的长期记忆**: 基于向量与关键词的**混合检索**系统，查找细节更快更准；助手可**主动检索记忆或历史记录**，并支持记忆置顶固定与暂停整合。支持**记忆摘要**，形成个人画像。

### 工具与沙盒生态
*   **沙盒工作区**: 独立持久化沙盒，支持**挂载手机本地真实文件夹**；聊天发送的文件自动挂载进沙盒供按需读取，内置文档与网页查看器。
*   **移动端 MCP 扩展**: 支持在手机沙盒中运行 **STDIO MCP** 插件，兼容并支持一键粘贴导入主流配置，助手亦可在对话中自主管理扩展。
*   **Agent Skills**: 兼容大部分现有 Skills，支持**手动指定注入**哪些技能，配备脚本执行与目录树预览。
*   **安全可控执行**: 内置 QuickJS 与沙盒脚本执行，文件读写与代码运行统一走**参数审批卡片**确认，安全透明。
*   **本地设备控制**: 发送通知、启动应用、设置闹钟，并能**主动创建、编辑、删除定时任务**与获取当前时间。
*   **网络搜索**: 集成 Exa、Grok、Serper、豆包等多个搜索服务，支持**同时启用多源**、**顺序回退**及子代理模式。
*   **世界书设定**: 支持创建与管理世界观设定并按需注入，助手可使用工具主动修编条目。

### 助手管理
*   **多助手**: 创建、管理并无限制切换自定义助手。
*   **标签系统**: 使用自定义标签组织助手。
*   **导入/导出**: 轻松分享或备份助手配置，导出备份全面兼容 RikkaHub。

### 智能体群聊（多角色协同）
*   **多角色同台讨论**: 将多个不同助手拉进同一个群聊，也支持同一个助手以不同编号多副本入席。
*   **路由模型**: 内置主持人模型结合上下文智能判断发言顺序，亦支持助手间自主轮流头脑风暴。

### 现代且流畅的 UI
*   **Material You**: 全面采用 Material Design 3，支持随壁纸改变的**动态色彩**，配合**顶栏模糊**让界面更有层次。
*   **丰富渲染**: 支持 LaTeX 数学公式、代码高亮、表格的 Markdown 渲染，**Mermaid 图表可导出为图片**。
*   **细节交互**: 支持单消息**追问引用**、会话多分支管理、截断长按续写与阅读进度记忆；提供全屏沉浸与极简输入模式切换。

### 附加模块
*   **图像生成**: 专用于使用支持模型生成图像的独立界面，适配最新比例与画质调节。
*   **翻译器**: 专门的文本翻译模式。
*   **文本转语音 (TTS)**: 支持系统 TTS 及 OpenAI、Gemini、ElevenLabs、MiniMax、MiMo 等多家服务商。
*   **WebUI**: 提供网页端访问，配合系统下拉**快捷磁贴**一键开关，方便在桌面浏览器继续对话。

### 隐私与数据
*   **本地优先**: 聊天记录和向量记忆均本地存储在你的设备上。
*   **多端备份**: 支持 **WebDAV** 与**对象存储**（如 S3/R2 等）同步备份，并可开启**自动备份**。
*   **无缝迁移**: 支持一键导入转换 RikkaHub 备份配置，同时支持导出。

## 技术栈
*   **Kotlin** & **Jetpack Compose**
*   **Koin** 依赖注入
*   **Room** & **DataStore** 持久化
*   **WorkManager** & **AlarmManager** 可靠的后台任务

## 致谢
*   原项目: [RikkaHub](https://github.com/re-ovo/RikkaHub),[LastChat](https://github.com/Cocolalilal/LastChat) 
*   关于页面灵感来自 [PixelPlayer](https://github.com/theovilardo/PixelPlayer)
*   图片裁剪工具修改自 [LavenderPhotos](https://github.com/kaii-lb/LavenderPhotos) 的图像编辑器
*   由 **AI Agent** 驱动开发


## 反馈与交流
欢迎加入反馈交流群:`1084874256`

## Star History

<a href="https://www.star-history.com/?repos=54xzh%2FFLIT&type=date&legend=top-left">
 <picture>
   <source media="(prefers-color-scheme: dark)" srcset="https://api.star-history.com/chart?repos=54xzh/FLIT&type=date&theme=dark&legend=top-left&sealed_token=N6CkRkLiryzntasoEmSDfxysejkr41rOeRsgeLyXAgn5EmI4rYdxis2ry_89ENzOMGP7J0JAXGOj3m_Fq7Vk5a5344zByO7tHro-C5r7bHJpYsy7A7iJIZwVDAuuUKunMcCbkvw-v2fwhyaa2P4VH8xEOe0lvwResgI6T4q4elpPcGYIjVAiEynkrCPW" />
   <source media="(prefers-color-scheme: light)" srcset="https://api.star-history.com/chart?repos=54xzh/FLIT&type=date&legend=top-left&sealed_token=N6CkRkLiryzntasoEmSDfxysejkr41rOeRsgeLyXAgn5EmI4rYdxis2ry_89ENzOMGP7J0JAXGOj3m_Fq7Vk5a5344zByO7tHro-C5r7bHJpYsy7A7iJIZwVDAuuUKunMcCbkvw-v2fwhyaa2P4VH8xEOe0lvwResgI6T4q4elpPcGYIjVAiEynkrCPW" />
   <img alt="Star History Chart" src="https://api.star-history.com/chart?repos=54xzh/FLIT&type=date&legend=top-left&sealed_token=N6CkRkLiryzntasoEmSDfxysejkr41rOeRsgeLyXAgn5EmI4rYdxis2ry_89ENzOMGP7J0JAXGOj3m_Fq7Vk5a5344zByO7tHro-C5r7bHJpYsy7A7iJIZwVDAuuUKunMcCbkvw-v2fwhyaa2P4VH8xEOe0lvwResgI6T4q4elpPcGYIjVAiEynkrCPW" />
 </picture>
</a>
