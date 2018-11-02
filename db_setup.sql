/*
    ERS Database v 1.0
    DB Server: PostgreSql
    Author: Josh Stoltenberg
*/

-- Create tables
SET SCHEMA 'ers';

CREATE TABLE ers_reimbursment
(
    reimb_id SERIAL,
    reimb_amt NUMBER NOT NULL,
    reimb_submitted TIMESTAMP NOT NULL,
    reimb_resolved TIMESTAMP,
    reimb_description VARCHAR2(250),
    reimb_receipt BLOB,
    reimb_author NUMBER NOT NULL,
    reimb_resolver NUMBER,
    reimb_status_id NUMBER NOT NULL,
    reimb_type_id NUMBER NOT NULL,
    CONSTRAINT ers_reimbursment_PK PRIMARY KEY (reimb_id)
);

CREATE TABLE ers_users
(
    ers_users_id SERIAL,
    ers_username VARCHAR2(50) NOT NULL,
    ers_password VARCHAR2(50) NOT NULL,
    user_first_name VARCHAR2(100) NOT NULL,
    user_last_name  VARCHAR2(100) NOT NULL,
    user_email  VARCHAR2(150) NOT NULL,
    user_role_id NUMBER NOT NULL,
    CONSTRAINT ers_users_PK PRIMARY KEY (ers_users_id),
    CONSTRAINT ers_users__UNv1 CHECK (ers_username <> user_email)
);

CREATE TABLE ers_reimbursment_status
(
    reimb_status_id SERIAL,
    reimb_status  VARCHAR2(10) NOT NULL,
    CONSTRAINT reimb_status_PK PRIMARY KEY (reimb_status_id)
);

CREATE TABLE ers_reimbursment_type
(
    reimb_type_id SERIAL,
    reimb_type VARCHAR2(10) NOT NULL,
    CONSTRAINT reimb_type_PK PRIMARY KEY (reimb_type_id)
);

CREATE TABLE ers_user_roles
(
    ers_user_role_id SERIAL,
    user_role VARCHAR2(10) NOT NULL
    CONSTRAINT ers_user_roles_PK PRIMARY KEY (ers_user_role_id)
);

-- Add foreign keys
ALTER TABLE ers_reimbursment 
ADD CONSTRAINT ers_users_FK_auth FOREIGN KEY (reimb_author) REFERENCES ers_users (ers_users_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT ers_users_FK_reslvr FOREIGN KEY (reimb_resolver) REFERENCES ers_users (ers_users_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT ers_reimbursment_status_FK FOREIGN KEY (reimb_status_id) REFERENCES ers_reimbursment_status (reimb_status_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT ers_reimbursment_type_FK FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursment_type (reimb_status_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE ers_users 
ADD CONSTRAINT user_roles_FK FOREIGN KEY (user_role_id) REFERENCES ers_user_roles (ers_user_role_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION;