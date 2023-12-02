CREATE TABLE USERS (
  ID INTEGER NOT NULL AUTO_INCREMENT,
  USERNAME VARCHAR(255) NOT NULL,
  EMAIL VARCHAR(255) NOT NULL,
  PASSWORD VARCHAR(255) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE SHOWS (
  ID INTEGER NOT NULL AUTO_INCREMENT,
  TITLE VARCHAR(255) NOT NULL,
  DESCRIPTION VARCHAR(255) NOT NULL,
  DURATION VARCHAR(255) NOT NULL,
  DIRECTOR VARCHAR(255) NOT NULL,
  GENRE VARCHAR(255) NOT NULL,
  LANGUAGE VARCHAR(255) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE SCREENINGS (
  ID INTEGER NOT NULL AUTO_INCREMENT,
  SHOW_ID INTEGER NOT NULL,
  DATE DATETIME NOT NULL,
  PRICE DECIMAL NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE RESERVATIONS (
  USER_ID INTEGER NOT NULL,
  SCREENING_ID INTEGER NOT NULL,
  DATE DATETIME NOT NULL,
  PRIMARY KEY(USER_ID, SCREENING_ID)
);

CREATE TABLE LIKED_SHOWS (
  USER_ID INTEGER NOT NULL,
  SHOW_ID INTEGER NOT NULL,
  PRIMARY KEY(USER_ID, SHOW_ID)
);