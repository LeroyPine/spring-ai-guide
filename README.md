# Spring AI Guide - AI 编程指南

[![Java Version](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.5-green.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

## 项目简介

Spring AI Guide 是一个专注于 AI 编程实践的教学项目，旨在帮助开发者掌握如何在实际项目中有效利用 AI 技术提升开发效率。本项目将陆续引入各种 AI 相关的 demo 示例，涵盖从基础到高级的多种应用场景。

## 核心特性

### 🎯 RAG 智能问答系统 (当前实现)
基于检索增强生成（RAG）技术构建的智能问答系统，能够理解并回答关于 AI 编程效率的问题。

**主要功能：**
- 文档加载：自动加载《AI 编程效率指南》知识库
- 知识索引：将文档内容转换为向量存储，支持语义检索
- 智能问答：提供流式和同步两种响应方式的问答接口
- 安全配置：支持通过环境变量注入 API 密钥，避免敏感信息泄露

### 🔮 未来规划
项目将持续扩展，计划引入以下 AI 功能模块：
- AI Agent 实现
- 更多 AI 应用场景的 demo 示例
- 高级提示词工程实践
- 多模态 AI 应用示例

## 技术栈

- **开发语言**: Java 17
- **核心框架**: Spring Boot 3.3.5
- **AI 框架**: Spring AI 1.1.2
- **云服务**: 阿里云通义千问 (DashScope)
- **向量存储**: SimpleVectorStore
- **文档解析**: Apache Tika
- **构建工具**: Maven 多模块项目

## 快速开始

### 环境准备
1. JDK 17+
2. Maven 3.6+
3. 阿里云 DashScope API Key

### 运行项目
```bash
# 克隆项目
git clone <repository-url>

# 进入项目目录
cd spring-ai-guide

# 设置 API 密钥（推荐使用环境变量）
export ali_api_key=your_dashscope_api_key

# 构建项目
mvn clean install

# 运行 rag-demo 模块
cd rag-demo
mvn spring-boot:run
```

### API 接口

#### 流式问答接口
```
GET /ask?q={问题}
Content-Type: text/event-stream

# 示例
curl http://localhost:8080/ask?q=如何优化AI提示词
```

#### 同步问答接口
```
GET /askSync?q={问题}
Content-Type: application/json

# 示例
curl http://localhost:8080/askSync?q=AI编程有哪些最佳实践
```

## 安全配置

为保护 API 密钥安全，项目支持通过环境变量注入密钥：

```bash
# 方式1：环境变量
export ali_api_key=your_dashscope_api_key

# 方式2：JVM 参数
java -Dali.api.key=your_dashscope_api_key -jar app.jar
```

## 项目结构

```
spring-ai-guide/
├── rag-demo/              # RAG 演示模块
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/guide/
│   │   │   │       ├── config/     # 配置类
│   │   │   │       ├── controller/ # 控制器
│   │   │   │       ├── loader/     # 文档加载器
│   │   │   │       └── service/    # 业务服务
│   │   │   └── resources/
│   │   │       ├── docs/           # 知识库文档
│   │   │       └── application.yml # 配置文件
│   └── pom.xml
└── pom.xml               # 父项目配置
```

## 学习资源

项目内置《AI 编程效率指南》作为知识库，内容涵盖：
- 提示词优化策略
- 高质量提示词构建原则
- 实用的提示词模板
- AI 编程最佳实践

## 贡献指南

欢迎提交 Issue 和 Pull Request 来帮助改进这个项目。如果您有任何想法或建议，请随时联系我们。

## 许可证

本项目采用 MIT 许可证，详情请见 [LICENSE](LICENSE) 文件。

## 联系方式

如有任何问题，请通过以下方式联系：
- 提交 GitHub Issue
- 发送邮件至项目维护者