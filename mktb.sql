                CREATE TABLE mktb_roles ( roleId bigint NOT NULL AUTO_INCREMENT,roleName varchar(100) NOT NULL, PRIMARY KEY (roleId) ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
		CREATE TABLE mktb_users ( userId bigint NOT NULL,type varchar(100), userName varchar(100) NOT NULL, password varchar(100) NOT NULL,isActive tinyint DEFAULT 1) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
		CREATE TABLE mktb_teachers( userId bigint NOT NULL,teacherId bigint NOT NULL AUTO_INCREMENT,teacherName varchar(100),DOB TIMESTAMP DEFAULT CURRENT_TIMESTAMP,idProof varchar(100),registrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, isActive tinyint DEFAULT 1,language varchar(100), PRIMARY KEY (teacherId) ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
		CREATE TABLE mktb_teacher_details( teacherId bigint,pinCode varchar(100),address varchar(500), city varchar(100), state varchar(200),country varchar(200),  phNumber varchar(20)) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
		CREATE TABLE mktb_teacher_salary( teacherId bigint,compensation varchar(100),date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,increment varchar(100)) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
		CREATE TABLE mktb_teacher_transactions( transactionId bigint NOT NULL AUTO_INCREMENT,teacherId bigint,salary varchar(100),transactionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (transactionId)) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
		CREATE TABLE mktb_parents( userId bigint NOT NULL,parentId bigint NOT NULL AUTO_INCREMENT,parentName varchar(100),DOB TIMESTAMP DEFAULT CURRENT_TIMESTAMP,idProof varchar(100),registrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, isActive tinyint DEFAULT 1,PRIMARY KEY (parentId)) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
		CREATE TABLE mktb_parent_details( parentId bigint,parentName varchar(100),pinCode varchar(100),address varchar(500), city varchar(100), state varchar(200),country varchar(200),  phNumber varchar(20)) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
		CREATE TABLE mktb_student_details (studentId bigint NOT NULL AUTO_INCREMENT, parentId bigint,studentName varchar(200),age varchar(5),DOB TIMESTAMP DEFAULT CURRENT_TIMESTAMP,maktabBatch varchar(100), isActive tinyint DEFAULT 1,language varchar(100), PRIMARY KEY (studentId)) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
		CREATE TABLE mktb_student_fee (studentId bigint,fee varchar(5), status varchar(20),alert varchar(5),date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,received varchar(50)) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
		CREATE TABLE mktb_user_roles ( Id bigint NOT NULL AUTO_INCREMENT,type varchar(100),roleId bigint NOT NULL,userId bigint NOT NULL,PRIMARY KEY (Id)) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
