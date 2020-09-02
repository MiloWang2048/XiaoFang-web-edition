# 小芳便利店web版

## 预编译安装

### 数据库配置

在本机数据库上创建数据库xiaofang，设置字符集和排序规则：

![](https://raw.githubusercontent.com/MiloWang2048/pic-lib/master/20200902205323.png)

执行数据库文件`xiaofang.sql`：

![image-20200902205640911](https://raw.githubusercontent.com/MiloWang2048/pic-lib/master/20200902210409.png)

创建用户并授权：

![image-20200902205820580](https://raw.githubusercontent.com/MiloWang2048/pic-lib/master/image-20200902205820580.png)

![image-20200902210003234](https://raw.githubusercontent.com/MiloWang2048/pic-lib/master/image-20200902210003234.png)

然后运行启动命令：

```sh
java -jar xiaofang-1.0.0-SNAPSHOT.jar
```

![image-20200902210236568](https://raw.githubusercontent.com/MiloWang2048/pic-lib/master/image-20200902210236568.png)

访问浏览器`localhost:8080`，就可以看到主界面。