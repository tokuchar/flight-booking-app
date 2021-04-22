CREATE TABLE reservation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(40),
    last_name VARCHAR(40)
);

INSERT INTO reservation(first_name, last_name)
VALUES ('jan', 'kowalski');
COMMIT;
