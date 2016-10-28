INSERT INTO account(username, password, last_name, first_name)
  VALUES('admin', 'pass', 'アドミン', '次郎');
INSERT INTO account(username, password, last_name, first_name)
  VALUES('user1', 'pass', 'ユーザー1', '太郎');
INSERT INTO account(username, password, last_name, first_name)
  VALUES('user2', 'pass', 'ユーザー2', '太郎');

INSERT INTO account_role(username, role)
  VALUES('admin', 'ROLE_ADMIN');
INSERT INTO account_role(username, role)
  VALUES('admin', 'ROLE_APP1');
INSERT INTO account_role(username, role)
  VALUES('admin', 'ROLE_APP2');
INSERT INTO account_role(username, role)
  VALUES('admin', 'ROLE_APP3');
INSERT INTO account_role(username, role)
  VALUES('user1', 'ROLE_APP1');
INSERT INTO account_role(username, role)
  VALUES('user1', 'ROLE_APP2');
INSERT INTO account_role(username, role)
  VALUES('user2', 'ROLE_APP1');
INSERT INTO account_role(username, role)
  VALUES('user2', 'ROLE_APP3');

