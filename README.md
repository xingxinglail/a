```
docker run --name=mysql -it -p 3306:3306 -v `pwd`/mysql/data:/var/lib/mysql -e TZ=Asia/Shanghai -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7
```