INSERT INTO users (username, password, enabled) values ('alex', '1234', true);
INSERT INTO users (username, password, enabled) values ('parul', 'zxcv', true);
INSERT INTO users (username, password, enabled) values ('gaurav', 'qwerty', true);

INSERT INTO authorities (username, authority) values ('ekta', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('parul', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) values ('gaurav', 'ROLE_XYZ');