# 初始密码 admin@123
insert into sys_user
(id,user_name,nick_name,password,mobile,is_administrator,create_user,create_date,update_user,update_date,remark)
value
(1,'admin','超级管理员','$2a$10$E6LSZ.VuGdwaqucHfUupX.9pBnYpz4e7i0ER6TS3eqeWCtjTNAyeW','15555555555',1,'admin',"2019-01-24 13:03:34",NULL,NULL,'默认超级管理员账号');
