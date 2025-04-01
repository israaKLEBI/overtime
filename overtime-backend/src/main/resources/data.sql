INSERT INTO employee (nom, prenom, poste) VALUES 
('klebi', 'isra', 'Développeur'),
('Martin', 'Sophie', 'Designer'),
('Bernard', 'Pierre', 'Manager');

INSERT INTO tarif (type_jour, tarif) VALUES 
('weekend', 1.5),
('jour ordinaire', 1.25);

INSERT INTO heures_sup (employe_id, date, nb_heures) VALUES 
(1, '2023-06-01', 3),
(1, '2023-06-02', 5.5),
(2, '2023-06-01', 2);