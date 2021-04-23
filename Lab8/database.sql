CREATE TABLE movies
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    title        VARCHAR(100) NOT NULL,
    release_year INT,
    duration     INT,
    score        INT
);

CREATE TABLE genres
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE movies_genres
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    movies_id INT NOT NULL,
    genres_id INT NOT NULL,
    FOREIGN KEY (movies_id) REFERENCES movies (id) ON DELETE CASCADE,
    FOREIGN KEY (genres_id) REFERENCES genres (id) ON DELETE CASCADE
)