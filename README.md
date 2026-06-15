# CMS Project

内容管理系统（Content Management System）。

## 快速开始

1. 克隆仓库：

```bash
git clone https://github.com/Fliks213/cms-project.git
cd cms-project
```

2. 编辑配置：

在 `src/main/resources/application.yml` 中配置你的数据库信息（MySQL）。

3. 构建并运行：

```bash
mvn clean package
java -jar target/cms-project-1.0.0.jar
```

默认启动端口：8080

4. 推荐的开发流程

- 使用 IntelliJ IDEA 打开项目
- 在运行配置中选择 `CmsProjectApplication` 的主类，启动项目
- 使用 Postman 或浏览器访问 `http://localhost:8080`

## 项目结构

- src/main/java/com/cms: 主代码
- src/main/resources: 配置
- pom.xml: Maven 构建文件

## 说明

这是一个示例项目骨架，包含基本依赖和初始配置。我会逐步向你添加实体、Repository、Service、Controller、Security 等模块。

如果你希望我把示例代码（实体、Repository 等）全量写入仓库，请回复「写入代码」。
