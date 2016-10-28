CREATE TABLE account(
  username VARCHAR(10) PRIMARY KEY,
  password VARCHAR(100),
  last_name VARCHAR(20),
  first_name VARCHAR(20)
);

CREATE TABLE account_role(
  username VARCHAR(10),
  role VARCHAR(20),
  PRIMARY KEY (username, role)
);
