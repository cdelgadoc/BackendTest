DROP TABLE IF EXISTS users;

CREATE TABLE users ( 
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(100) NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	password VARCHAR(200) NOT NULL,
	token VARCHAR(200)
);

INSERT INTO users (name, email, password, token) 
VALUES (
'John Doe', 
'john.doe@gmail.com', 
'$2a$10$Bxy/lBv9s7avnF1/sbrH5OujFyEl4/5vCc/irASy79T9423yjqvhi',
'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBnbWFpbC5jb20iLCJleHAiOjE5NjAzMDk3NzgyNzI1MjIsIm5hbWUiOiJKb2huIERvZSJ9.ALX-E6tdxo_SNNR4FtrR1syeiUNyaafwtRtZzZ9iJ-k');

commit;



DROP TABLE IF EXISTS article;

CREATE TABLE article ( 
	id SERIAL PRIMARY KEY NOT NULL,
	object_id VARCHAR(50) UNIQUE NOT NULL,
	created_at VARCHAR(30) NOT NULL,
	active BOOLEAN NOT NULL,
	url VARCHAR(200),
	points INTEGER,
	story_text VARCHAR(5000),
	comment_text VARCHAR(5000),
	num_comments INTEGER,
	story_id INTEGER,
	story_title VARCHAR(200),
	story_url VARCHAR(200),
	parent_id INTEGER,
	created_at_i BIGINT,
	author VARCHAR(100),
	tags VARCHAR(200),
	title VARCHAR(200),
	month VARCHAR(9) NOT NULL
);

commit;
