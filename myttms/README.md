影院管理平台
============
简介
--------
这个管理平台实现了影院管理所需的功能，有人员管理、影厅管理、座位管理、影片管理、演出计划管理等模块。当该平台管理人员登录网站成功后，会自动跳转影院
管理平台。而普通用户登录成功后，只能进行修改密码和上传头像等操作。

整体设计
----------
前端部分:
--------
前端使用了BootStrap,Js等技术。

后台部分:
--------
项目使用了SSM框架进行业务逻辑处理和数据持久化等操作，并使用了c3p0连接池减少了连接的创建和销毁。在项目中还应用了过滤器根据用户身份对目录访问权限进行
了限制。

数据库设计：
---------
整个平台使用MySQL数据库对数据进行存储，共设计了6张表，分别为：<br>
*employee表(员工信息表) --- 对使用该影院的人员信息进行存储。<br>
*play表(影片信息表) --- 对影院的影片信息进行存储。<br>
*schedule表(演出计划表) --- 对所安排的演出计划进行存储。<br>
*seat(座位表）--- 对每个影厅的座位及其状态进行存储。<br>
*studio(影厅表) --- 对影院内的所有影厅信息进行存储。<br>
*notice(公告表) --- 影院内的公告信息进行存储。<br>


[项目展示](http://123.207.140.133/)
