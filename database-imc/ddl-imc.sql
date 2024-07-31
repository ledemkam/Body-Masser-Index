create  database  IMC;
use IMC;

create table ACCOUNT (
    id int PRIMARY KEY auto_increment,
    name varchar(30) ,
    email varchar(30) ,
    password varchar(30) ,
    created_at datetime default CURRENT_TIMESTAMP
);

create table SUGGESTION (
    id int PRIMARY KEY auto_increment,
    label varchar(200) ,
    description text
);

create table IMC (
    id int PRIMARY KEY auto_increment,
    height integer ,
    weight integer ,
    created_at datetime default CURRENT_TIMESTAMP,
    account_id integer not null,
    CONSTRAINT fk_account FOREIGN KEY (account_id) REFERENCES ACCOUNT(id)
);

create table IMC_SUGGESTION (
    id int PRIMARY KEY auto_increment,
    imc_id integer not null,
    suggestion_id integer not null,
    CONSTRAINT fk_imc FOREIGN KEY (imc_id) REFERENCES IMC(id),
    CONSTRAINT fk_suggestion FOREIGN KEY (suggestion_id) REFERENCES SUGGESTION(id)
);