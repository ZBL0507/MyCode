# docker 容器的导入导出

<br>

## 容器导出
export 导出容器的内容留作为一个 tar 归档文件 [对应 import 命令]
```text
docker export 容器id > 文件名.tar
```

<br>

## 容器导入
import 从 tar 包中的内容创建一个新的文件系统再导入为镜像 [对应 export]
```text
cat 文件名.tar | docker import - 镜像用户/镜像名:镜像版本号
```