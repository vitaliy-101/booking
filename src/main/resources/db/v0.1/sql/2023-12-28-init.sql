-- liquibase formatted sql
-- changeset vitaliy:2023-12-28-init
create table if not exists `user`
(
    id INT AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    roles VARCHAR(100),
    password VARCHAR(100) NOT NULL,
    CONSTRAINT pk_user primary key (id)
);
create table if not exists orders
(
    id INT AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    price INT,
    duration INT,
    CONSTRAINT pk_order primary key (id),
    CONSTRAINT uq_order_title unique (title)
);
create table if not exists image
(
    id INT AUTO_INCREMENT,
    name_image MEDIUMTEXT NOT NULL,
    orig_file_name MEDIUMTEXT NOT NULL,
    size_image BIGINT,
    content_type MEDIUMTEXT NOT NULL,
    bytes LONGBLOB,
    order_id INT,
    CONSTRAINT pk_image primary key (id),
    CONSTRAINT fk_image_order_id FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE
);
create table if not exists active_order
(
    id INT AUTO_INCREMENT,
    time_order BIGINT,
    user_id INT,
    order_id INT,
    CONSTRAINT pk_active_order primary key (id),
    CONSTRAINT fk_active_order_order_id FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
    CONSTRAINT fk_active_order_user_id FOREIGN KEY (user_id) REFERENCES `user` (id) ON DELETE CASCADE
);