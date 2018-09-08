-- 用户表
CREATE TABLE smbms_user
(
    id INT AUTO_INCREMENT PRIMARY KEY,	-- id
    smb_id INT,				-- 
    usercode VARCHAR(20),
    username VARCHAR(20),
    userpassword VARCHAR(20),
    gender INT,
    birthday DATETIME,
    phone VARCHAR(20),
    address VARCHAR(32),
    userroleid INT,
    createby INT,
    creationdate DATETIME,
    modifyby INT,
    modifydate DATETIME
);

ALTER TABLE smbms_user ADD
(
    cardphoto VARCHAR(100),
    workphoto VARCHAR(100)
)


SELECT * FROM smbms_user;

INSERT INTO smbms_user(smb_id,usercode,username,userpassword,gender,birthday,phone,address,userroleid,
createby,creationdate,modifyby,modifydate) VALUES(1,'001','张三','123456',1,'2016-1-1','13355566666','南京北大青鸟',1,1,SYSDATE(),2,SYSDATE());

INSERT INTO smbms_user(smb_id,usercode,username,userpassword,gender,birthday,phone,address,userroleid,
createby,creationdate,modifyby,modifydate) VALUES(2,'002','韩信','123456',1,'2016-1-2','13355566667','南京北大青鸟',1,1,SYSDATE(),2,SYSDATE());

INSERT INTO smbms_user(smb_id,usercode,username,userpassword,gender,birthday,phone,address,userroleid,
createby,creationdate,modifyby,modifydate) VALUES(3,'003','花木兰','123456',1,'2016-1-3','13355566668','南京北大青鸟',1,1,SYSDATE(),2,SYSDATE());

INSERT INTO smbms_user(smb_id,usercode,username,userpassword,gender,birthday,phone,address,userroleid,
createby,creationdate,modifyby,modifydate) VALUES(4,'004','亚瑟','123456',1,'2016-1-4','13355566669','南京北大青鸟',1,1,SYSDATE(),2,SYSDATE());

INSERT INTO smbms_user(smb_id,usercode,username,userpassword,gender,birthday,phone,address,userroleid,
createby,creationdate,modifyby,modifydate) VALUES(5,'005','孙悟空','123456',1,'2016-1-5','13355566660','南京北大青鸟',1,1,SYSDATE(),2,SYSDATE());

INSERT INTO smbms_user(smb_id,usercode,username,userpassword,gender,birthday,phone,address,userroleid,
createby,creationdate,modifyby,modifydate) VALUES(6,'006','李白','123456',1,'2016-1-6','13355566661','南京北大青鸟',1,1,SYSDATE(),2,SYSDATE());


INSERT INTO smbms_user(smb_id,usercode,username,userpassword,gender,birthday,phone,address,userroleid,
createby,creationdate,modifyby,modifydate) VALUES(7,'007','老司机','123456',1,'2016-1-12','13355566677','南京北大青鸟',2,1,SYSDATE(),2,SYSDATE());

INSERT INTO smbms_user(smb_id,usercode,username,userpassword,gender,birthday,phone,address,userroleid,
createby,creationdate,modifyby,modifydate) VALUES(8,'008','螳螂','123456',1,'2016-1-13','13355566678','南京北大青鸟',2,1,SYSDATE(),2,SYSDATE());

INSERT INTO smbms_user(smb_id,usercode,username,userpassword,gender,birthday,phone,address,userroleid,
createby,creationdate,modifyby,modifydate) VALUES(9,'009','提款姬','123456',1,'2016-1-14','13355566679','南京北大青鸟',2,1,SYSDATE(),2,SYSDATE());

INSERT INTO smbms_user(smb_id,usercode,username,userpassword,gender,birthday,phone,address,userroleid,
createby,creationdate,modifyby,modifydate) VALUES(10,'010','女警','123456',1,'2016-1-15','13355566670','南京北大青鸟',2,1,SYSDATE(),2,SYSDATE());

INSERT INTO smbms_user(smb_id,usercode,username,userpassword,gender,birthday,phone,address,userroleid,
createby,creationdate,modifyby,modifydate) VALUES(11,'011','塔姆','123456',1,'2016-1-16','13355566671','南京北大青鸟',2,1,SYSDATE(),2,SYSDATE());
INSERT INTO smbms_user(smb_id,usercode,username,userpassword,gender,birthday,phone,address,userroleid,
createby,creationdate,modifyby,modifydate) VALUES(12,'012','女枪','123456',1,'2016-1-15','13355566670','南京北大青鸟',2,1,SYSDATE(),2,SYSDATE());


-- 权限表
CREATE TABLE smbms_role
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    rolecode VARCHAR(20),	-- 权限码
    rolename VARCHAR(20),	-- 权限名
    createby INT,
    creationdate DATETIME,
    modifyby INT,
    modifydate DATETIME	 
)

SELECT u.*,r.id rid,r.rolename FROM smbms_user u INNER JOIN smbms_role r ON u.userroleid=r.id

INSERT INTO smbms_role(rolecode,rolename) VALUES('1','管理员'),('2','普通用户')

SELECT u.*,r.id rid,r.rolename FROM smbms_user u INNER JOIN smbms_role r ON u.userroleid=r.id

-- 地址表
CREATE TABLE smbms_address
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    contact VARCHAR(32),
    addressdesc VARCHAR(50),
    postcode VARCHAR(32),
    tel VARCHAR(32),
    createby INT,
    creationdate DATETIME,
    modifyby INT,
    modifydate DATETIME,
    userid INT	 
);


-- 供应商表
CREATE TABLE smbms_provider
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    procode VARCHAR(32),
    proname VARCHAR(32),
    prodesc VARCHAR(50),
    procontact VARCHAR(32),
    prophone VARCHAR(32),
    proaddress VARCHAR(50),
    profax VARCHAR(32),
    createby INT,
    creationdate DATETIME,
    modifyby INT,
    modifydate DATETIME
);


-- 订单表
CREATE TABLE smbms_bill
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    billcode VARCHAR(32),
    productname VARCHAR(32),
    productdesc VARCHAR(32),
    productunit DECIMAL(10,2),
    productcount DECIMAL(10,2),
    totalprice DECIMAL(10,2),
    ispayment INT,
    createby INT,
    creationdate DATETIME,
    modifyby INT,
    modifydate DATETIME,
    providerid INT
);


