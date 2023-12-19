USE railwayreservation;

CREATE TABLE train (
    train_no BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    train_name NVARCHAR(250) NOT NULL,
    train_start_place NVARCHAR(250),
    train_end_place NVARCHAR(250),
    train_seater_carriage_count INT,
    train_seater_carriage_capacity INT,
    train_sleeper_carriage_count INT,
    train_sleeper_carriage_capacity INT,
    train_sleeper_carriage_upperbirth_capacity INT,
    train_sleeper_carriage_middlebirth_capacity INT,
    train_sleeper_carriage_lowerbirth_capacity INT,
    train_active_status NVARCHAR(250)
);