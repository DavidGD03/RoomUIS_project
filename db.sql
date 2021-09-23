CREATE TABLE arrendador(
idA INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
cedula VARCHAR(50) NOT NULL,
nombre VARCHAR(50) NOT NULL,
correo VARCHAR(50) NOT NULL,
telefono VARCHAR(50) NOT NULL  
);
CREATE TABLE estudiante(
idE INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
codigo VARCHAR(10) NOT NULL,
nombre VARCHAR(50) NOT NULL,
carrera VARCHAR(50) NOT NULL,
telefono VARCHAR(50) NOT NULL    
);

CREATE TABLE admin(
idAd INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
cedula VARCHAR(12) NOT NULL,
nombre VARCHAR(50) NOT NULL,
correo VARCHAR(50) NOT NULL,
telefono VARCHAR(50) NOT NULL
);

CREATE TABLE locacion(
idL INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
idAL INT NOT NULL,
direccion VARCHAR(250) NOT NULL,
extradir VARCHAR(50),
precio DOUBLE NOT NULL,
detalles VARCHAR(300) NOT NULL,
imagen VARCHAR(100)
);

CREATE TABLE denuncia(
idD INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
idE INT NOT NULL,
idL INT NOT NULL,
titulo VARCHAR(50) NOT NULL,
descripcion VARCHAR(500) NOT NULL,
CONSTRAINT idED FOREIGN KEY (idE) REFERENCES Estudiante (idE) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT idLD FOREIGN KEY (idL) REFERENCES Locacion (idL) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE valoracion(
idV INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
idE INT NOT NULL,
idL INT NOT NULL,
titulo VARCHAR(50) NOT NULL,
descripcion VARCHAR(500) NOT NULL,
estrellas INTEGER(1) NOT NULL,
CONSTRAINT idEV FOREIGN KEY (idE) REFERENCES Estudiante (idE) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT idLV FOREIGN KEY (idL) REFERENCES Locacion (idL) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE solicitudCompra(
idS INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
idE INT NOT NULL,
idAS INT NOT NULL,
mensaje VARCHAR(500) NOT NULL,
CONSTRAINT idESC FOREIGN KEY (idE) REFERENCES Estudiante (idE) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE locacionesEstudiantes(
idLE INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
idE INT NOT NULL,
idL INT NOT NULL,
CONSTRAINT idELE FOREIGN KEY (idE) REFERENCES Estudiante (idE) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT idLLE FOREIGN KEY (idL) REFERENCES Locacion (idL) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into arrendador (cedula, nombre, correo, telefono) values( "1234", "Angie Rangel","angieran@gmail.com", "3202935664"),
("1235", "Miguel Mora", "miguemora@gmail.com", "3042158850"),
("1236","Juan Mantilla",  "juanmanti@gmail.com", "3202569816"),
("1237","Stifer Orduz",  "stiffior@gmail.com", "3177926541"),
("1238","Juan Pinto",  "juanpito@gmail.com", "3254612121"),
("1239","Andres Peña",  "andressinpena@gmail.com", "3048766121"),
("1240","Myller Prada",  "millerlite@gmail.com", "3042122321"),
("1241","Paula Rojas",  "paurorojas@gmail.com", "304142120"),
("1242","Isabella Piñeres",  "isapinene@gmail.com", "3043188978"),
("1243","Omar Zapato",  "omzapdam@gmail.com", "3044534521"),
("1244","Sergio Galindo",  "sergeiga@gmail.com", "3044534521"),
("1245","Luciana Calvete",  "lucilucica@gmail.com", "3043179801");

insert into estudiante (codigo,nombre,carrera,telefono) values("2170128", "Alex Casablanca", "ing. Sistemas", "3232335276"),
("2170137", "Estefani Sokolinski", "ing. Electrica", "3182931315"),
("2170136","David Rojas",  "ing. Petroleos", "3182993816"),
("2170133","Andres Navarro",  "ing. Mecanica", "312212123"),
("2170143","Sandro Boticelli",  "ing. Industrial", "3177928402"),
("2170156","Farina Martinez",  "ing. Quimica", "3125648710"),
("2170189","Andrea Bocelli",  "ing. Sistemas", "312212675"),
("2170795","Justo Bolsa",  "ing. Mecanica", "312873122"),
("2170563","Muriel Bolsa",  "ing. Metalurgica", "327867142"),
("2170654","Miguel Cuauhtemoc",  "ing. Industrial", "3165461252"),
("2170851","Diego Quesito",  "ing. Mecanica", "312154675"),
("2170122","Daniel Nahuatl",  "ing. Sistemas", "312212543"),
("2170138", "Mauricio Benavente", "ing. Industrial", "3182932556");

insert into admin (idAd, cedula, nombre, correo, telefono) values( "1007", "1098822", "Nesly Oliveros","nesnesily@gmail.com", "3202125487"),
("1008", "1098821", "Felix Rojas", "felixfix@gmail.com", "3502846750"),
("1009", "1098823", "Juan Riveros",  "Juanriver@gmail.com", "3156452132");

insert into locacion (idAL,direccion,extradir,precio,detalles,imagen) values(1, "carrera 25 #18-20", "Casa", 350000, "Habitación recien remodelada" ,"C:/Users/David/Documents/RoomUISFinal/src/main/resources/locaciones/locacion1.png"),
(2, "carrera 35 #18-20", "Casa gris", 400000, "Incluye las tres comidas","C:/Users/David/Documents/RoomUISFinal/src/main/resources/locaciones/locacion2.png"),
(3, "carrera 24 #19-05", "Edificio Premium", 320000, "En el día hay mucho tránsito de vehículos, apartamento en segundo piso","C:/Users/David/Documents/RoomUISFinal/src/main/resources/locaciones/locacion3.png"),
(4, "calle 10 #20-34", "Edificio Cima", 290000, "No incluye administración ni servicios","C:/Users/David/Documents/RoomUISFinal/src/main/resources/locaciones/locacion4.png"),
(5,"calle 23 #17-04", "Edificio Balcones", 380000, "Pequeña humedad en una pared","C:/Users/David/Documents/RoomUISFinal/src/main/resources/locaciones/locacion5.png"),
(6, "calle 9 #25-30", "Edificio Fundadores", 450000, "No hay pago de administración","C:/Users/David/Documents/RoomUISFinal/src/main/resources/locaciones/locacion6.png"),
(7, "carrera 18 #8-70", "Edificio Jordan", 420000, "La habitación incluye los servicios","C:/Users/David/Documents/RoomUISFinal/src/main/resources/locaciones/locacion7.png");

insert into valoracion (idE, idL, titulo, descripcion, estrellas) values(3,4,"Humedad","Una de las paredes de la habitación tenía muchísima humedad en una de sus paredes, tenía hongos!!",2),
(1,2,"Goteras","Justo dónde ubiqué mis libros había una gotera, tuve daños y los de la habitación no respondieron.",3),
(2,3,"Humo","Apartamento ubicado en un segundo piso y con ventana a la calle, la cual en el día es imposible de abrir, constante paso de buses por la zona.",4),
(5,6,"Limpieza","Increíble la cantidad de basura que tenían en el apartamento",2),
(3,4,"Servicio de Comida","Ofrecían comida con el pago de la habitación, la comida siempre estaba fría y muy fea, como recomendación: aprender a cocinar antes de ofrecer ese servicio.",3),
(4,6,"Poco limpio","El baño era compartido, increíble la cochinada de baño",2),
(7,4,"Ambiente conflictivo","El arrendador venía constantemente a crear conflictos, puede ser muy lindo el lugar, pero imposible aguantar.",1);

insert into denuncia (idE, idL, titulo, descripcion) values(2,5,"Engaño","Tiene información engañosa sobre el apartamento, y se excusó diciendo que olvidó actualizar la información."),
(1,6,"El teléfono de contacto no funciona","Justo dónde ubiqué mis libros había una gotera, tuve daños y los de la habitación no respondieron.");

insert into solicitudCompra (idE, idAS, mensaje) values(2,3,"Me interesa mucho, quiero agendar una visita, podría comunicarse conmigo al 3182931315"),
(3,4,"Me puede comunicar al número 312154675 si incluye o no administración, si no incluye arriendo, de una");

