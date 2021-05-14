INSERT INTO FITNESS_CENTAR (adresa,br_telefona,email,naziv) VALUES ('herojaPinkija','123123123','best@gmail.com','BestFit');

INSERT INTO KORISNIK (aktivan,datum,email,ime,password,position,prezime,telefon,fitness_centar_id) VALUES (true,'2000-05-07','mirkovic@gmail.com','Pedja','Pedja-2000','korisnik','Mirkovic','123123123',1);

INSERT INTO TRENER (aktivan,datum,email,ime,password,position,prezime,telefon,fitness_centar_id) VALUES (true,'2000-05-07','mirkovicnemnja@gmail.com','nemnja','Pedja-2000','trener','Cuturilo','43531321',1);

INSERT INTO TERMINSKA_LISTA (broj_clanova,cena,dan,fitness_centar_id) VALUES ('20','2000','sreda',1);

INSERT INTO CLAN_FITNES_CENTRA (aktivan,datum,email,ime,password,position,prezime,telefon) VALUES (true,'2000-05-07','mirkovic@gmail.com','Pedja','Pedja-2000','korisnik','Mirkovic','123123123');

INSERT INTO TRENING (trajanje,naziv,opis,tip_treninga,cene_id,trener_id,trening_id) VALUES ('2.5','ultrax','grudiramena','personalni',1,1,1);

INSERT INTO LISTA_ODRADJENIH_TRENINGA (clan_id,trening_id) VALUES (1,1);

INSERT INTO LISTA_PRIJAVLJENIH_TRENINGA (clan_id,trening_id) VALUES (1,1);

INSERT INTO OCENA_ODRADJENIH_TRENINGA (clan_id,trening_id) VALUES (1,1);

INSERT INTO SALA (kapacitet,oznaka_sale,cene_id,fitness_centar_id,trening_id) VALUES ('20','1',1,1,1);

