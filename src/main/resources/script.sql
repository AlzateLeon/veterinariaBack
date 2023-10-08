-- Insertar usuarios de ejemplo
INSERT INTO Usuario (idUser, nombre, correo, contrasena, tipoUsuarioEnum, cedula) VALUES
('-1', 'ADMIN', 'admin@virtualpet.com', '123', 'ADMINISTRADOR', '000'),
('-2', 'Usuario Prueba', 'a@gmail.com', '123', 'DUENO_MASCOTA', '1094960114');

INSERT INTO Mascota(ID_MASCOTA, NOMBRE, DUENO_ID, EDAD, RAZA, TIPO_MASCOTA) VALUES
('-1', 'Gayita', '-2', '3', 'chandita', 'PERRO'),
('-2', 'Dali', '-2', '8', 'Fastidioso', 'GATO');