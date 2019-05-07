DROP TABLE IF EXISTS `resume`;
DROP TABLE  IF EXISTS `member`;
DROP TABLE  IF EXISTS `inform`;
DROP TABLE  IF EXISTS `project`;
DROP TABLE  IF EXISTS `history`;
DROP TABLE  IF EXISTS `award`;
DROP TABLE  IF EXISTS `live`;
DROP TABLE  IF EXISTS `photo`;
DROP TABLE IF EXISTS `collect_resume`;
/**
	简历表
*/
CREATE TABLE `resume`(
	resu_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	resu_name VARCHAR(20) NOT NULL COMMENT '简历人名字',
	resu_number CHAR(11) NOT NULL COMMENT '联系方式',
	resu_major VARCHAR(40) NOT NULL COMMENT '所在专业和班级',
	resu_wechat VARCHAR(30) NOT NULL COMMENT '微信号',
	resu_direct VARCHAR(20) NOT NULL COMMENT '面试方向',
	resu_evaluation VARCHAR(200) NOT NULL COMMENT '自我评价(100字以内)',
	resu_skills VARCHAR(255) NOT NULL COMMENT '目前掌握的技能',
	resu_exp VARCHAR(255) NOT NULL COMMENT '项目经历',
	resu_expect VARCHAR(255) NOT NULL COMMENT '期望',
	resu_other VARCHAR(255) NOT NULL COMMENT '其它优势'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/**
	团队成员表
*/
CREATE TABLE `member`(
	member_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	member_name VARCHAR(10) NOT NULL COMMENT '成员姓名', 
	phone_number CHAR(11) NOT NULL COMMENT '手机号码',
	birthday DATE NOT NULL COMMENT '生日,格式为yyyy-MM-dd',
	after_graduated VARCHAR(100) NOT NULL COMMENT '毕业去向',
	major VARCHAR(30) NOT NULL COMMENT '专业班级',
	member_direct VARCHAR(10) NOT NULL COMMENT '成员学习方向',
	member_password VARCHAR(100) NOT NULL COMMENT '成员登陆密码'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/**
	团队历史表
*/
CREATE TABLE `history`(
	his_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT, 
	his_info VARCHAR(255) NOT NULL COMMENT '团队历史的简介内容',
	edit_time datetime NOT NULL COMMENT '最后一次的修改时间'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/**
	最新通告表
*/
CREATE TABLE `inform`(
	inform_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT, 
	create_time datetime NOT NULL COMMENT '创建时间 yyyy-MM-dd HH:mm:ss',
	inform_info VARCHAR(200) NOT NULL COMMENT '通告内容',
	username VARCHAR(30) NOT NULL COMMENT '发出通告人'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/**
	项目展示表
*/
CREATE TABLE `project`(
	pro_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	pro_name VARCHAR(50) NOT NULL COMMENT '项目名称'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/**
	照片表
*/
CREATE TABLE `photo`(
	photo_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT, 
	photo_loc VARCHAR(100) NOT NULL COMMENT '照片的路径名',
	photo_type VARCHAR(20) NOT NULL COMMENT '照片种类(一次活动可能有多张照片)'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/**
	团队生活表
*/
CREATE TABLE `live`(
	live_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	live_name VARCHAR(100) NOT NULL COMMENT '生活内容'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/**
	获奖情况表
*/
CREATE TABLE `award`(
	award_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	award_name VARCHAR(50) NOT NULL COMMENT '获奖名称',
	award_time date NOT NULL COMMENT '获奖时间'
)ENGINE=INNODB DEFAULT CHARSET=utf8;
/**
	收藏简历
*/
CREATE TABLE `collect_resume`(
	col_resu_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT, 
	col_resu_name VARCHAR(20) NOT NULL COMMENT '简历人名字',
	col_resu_number CHAR(11) NOT NULL COMMENT '联系方式',
	col_resu_major VARCHAR(40) NOT NULL COMMENT '所在专业和班级',
	col_resu_wechat VARCHAR(30) NOT NULL COMMENT '微信号',
	col_resu_direct VARCHAR(20) NOT NULL COMMENT '面试方向',
	col_resu_evaluation VARCHAR(200) NOT NULL COMMENT '自我评价(100字以内)',
	col_resu_skills VARCHAR(255) NOT NULL COMMENT '目前掌握的技能',
	col_resu_exp VARCHAR(255) NOT NULL COMMENT '项目经历',
	col_resu_expect VARCHAR(255) NOT NULL COMMENT '期望',
	col_resu_other VARCHAR(255) NOT NULL COMMENT '其它优势'
)ENGINE=INNODB DEFAULT CHARSET=utf8;