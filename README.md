#“黑大圈圈”微信小程序——后台接口

## 域名

  **https://www.liuxuan.shop**


## 对象结构

 ####- User(用户)
 - private String userid;//openid
 - private String headimg;//头像链接
 - private String nickname;//昵称
 - private long articlesnum;//发表文章数量
 - private long likednum;//点赞量
 - private long commnum;//评论数量
 - private String sessionkey;//sessionkey
 
 ####- Article（文章）
  - private String userid;//sessionID
  - private long articleid;//文章ID
  - private String nickname;//昵称
  - private String headimg;//头像
  - private String contents;//文章内容
  - private long likednum;//点赞量
  - private long commnum;//评论量
  - private java.sql.Timestamp times;//文章时间
  - private long anonymous;//是否匿名(0匿名1不匿名)

 ####- Comments（评论）
 - private int commentsid;//评论ID（自增ID）
 - private String userid;//sessionID
 - private long articleid;//文章ID
 - private String nickname;//昵称
 - private String contents;//评论内容
 - private java.sql.Timestamp times;//时间
 
 ####- Likeuser（点赞）
  - private int likeid;//点赞id（默认自增，前端无需考虑）
  - private String userid;//sessionID
  - private long articleid;//文章ID


## 接口 Url

 - 'GET /heida/signin.do',       登录
```
访问接口时需要提供数据：
        code=  &  nickname=  &  headimg=
结构返回数据：
        user对象
```
 - 'POST /heida/Info.do',        获取用户个人信息（内容详见对象结构）
 ```
 访问接口时需要提供数据：
         userid=
 结构返回数据：
         user对象
 ```
 - 'POST /heida/inserta.do',     发表文章
  ```
  访问接口时需要提供数据：
        article对象（userid,nickname,headimg,contents,anonymous）  
  结构返回数据：
        article对象（除contents外所有内容，前端需记录下articleid和times）
  ```
 - 'GET /heida/getpa.do',        用户下拉时获取文章
  ```
  访问接口时需要提供数据：
        无
  结构返回数据：
        完整article对象List(已排序，前端需按照顺序输出)
  分页：10条
  ```
 - 'GET /heida/getinita.do',     用户初次进入论坛界面时获取文章
 ```
  访问接口时需要提供数据：
         无
  结构返回数据：
        完整article对象List(已排序，前端需按照顺序输出)
  分页：10条
  ```
 - 'GET /heida/getra.do',        用户下拉触底时获取文章
  ```
   访问接口时需要提供数据：
        articleid=   (最后一个文章的)
   结构返回数据：
        完整article对象List(已排序，前端需按照顺序输出)
   分页：10条
   ```
 - 'GET /heida/like.do'          文章点赞
  ```
  访问接口时需要提供数据：
        Likeuser对象（除likeid外）
  结构返回数据：
        无
   ```
 - 'GET /heida/unlike.do'        取消点赞
  ```
  访问接口时需要提供数据：
        Likeuser对象（除likeid外）
  结构返回数据：
        无
   ``` 
 - 'GET /heida/deletearticle.do' 删除文章
  ```
  访问接口时需要提供数据：
         Article对象（articleid）
  结构返回数据：
        无
   ```
 - 'GET /heida/savecomments.do'  存储评论
  ```
  访问接口时需要提供数据：
        Comments对象
  结构返回数据：
       完整Comments对象（除contents外,前端需记录commmentsid,times） 
   ```
 - 'GET /heida/delcomments.do'   删除评论
  ```
  访问接口时需要提供数据：
     Comments对象（commentsid）
  结构返回数据：
        无
   ```
 ## mysql数据库建表
 
 ```
 /*
  Navicat Premium Data Transfer
 
  Source Server         : root
  Source Server Type    : MySQL
  Source Server Version : 50719
  Source Host           : localhost:3306
  Source Schema         : heida
 
  Target Server Type    : MySQL
  Target Server Version : 50719
  File Encoding         : 65001
 
  Date: 26/03/2018 18:53:05
 */
 
 SET NAMES utf8mb4;
 SET FOREIGN_KEY_CHECKS = 0;
 
 -- ----------------------------
 -- Table structure for article
 -- ----------------------------
 DROP TABLE IF EXISTS `article`;
 CREATE TABLE `article`  (
   `userid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
   `articleid` int(11) NOT NULL AUTO_INCREMENT,
   `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
   `headimg` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
   `contents` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
   `likednum` int(11) NULL DEFAULT NULL,
   `commnum` int(11) NULL DEFAULT NULL,
   `times` datetime(0) NULL DEFAULT NULL,
   `anonymous` int(11) NULL DEFAULT NULL,
   PRIMARY KEY (`articleid`) USING BTREE
 ) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 
 -- ----------------------------
 -- Table structure for comments
 -- ----------------------------
 DROP TABLE IF EXISTS `comments`;
 CREATE TABLE `comments`  (
   `commentsid` int(10) NOT NULL AUTO_INCREMENT,
   `articleid` int(11) NOT NULL,
   `userid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
   `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
   `contents` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
   `times` datetime(0) NOT NULL,
   PRIMARY KEY (`commentsid`) USING BTREE
 ) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 
 -- ----------------------------
 -- Table structure for likeuser
 -- ----------------------------
 DROP TABLE IF EXISTS `likeuser`;
 CREATE TABLE `likeuser`  (
   `likeid` int(11) NOT NULL AUTO_INCREMENT,
   `articleid` int(11) NOT NULL DEFAULT 0,
   `userid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
   PRIMARY KEY (`likeid`) USING BTREE
 ) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 
 -- ----------------------------
 -- Table structure for user
 -- ----------------------------
 DROP TABLE IF EXISTS `user`;
 CREATE TABLE `user`  (
   `userid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
   `headimg` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
   `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
   `articlesnum` int(11) NULL DEFAULT NULL,
   `likednum` int(11) NULL DEFAULT NULL,
   `commnum` int(11) NULL DEFAULT NULL,
   `sessionkey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
   PRIMARY KEY (`userid`) USING BTREE
 ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 
 SET FOREIGN_KEY_CHECKS = 1;
 ```