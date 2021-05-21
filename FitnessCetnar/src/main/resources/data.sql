INSERT INTO FITNESS_CENTAR (adresa,br_telefona,email,naziv) VALUES ('herojaPinkija','123123123','best@gmail.com','BestFit');

INSERT INTO KORISNIK_TERETANE(type,aktivan,datum,email,ime,password,pozicija,prezime,telefon,username,fitness_centar_id) VALUES ('ClanFitnesCentra',true,'2000-05-07','dsmirkovic@gmail.com','Predrag','Pedja-2000','korisnik','Mirkovic','0666224414','pedja123',1);
INSERT INTO KORISNIK_TERETANE(type,aktivan,datum,email,ime,password,pozicija,prezime,telefon,username,fitness_centar_id) VALUES ('trener',true,'2000-05-07','dsmirko2ic@gmail.com','Dejan','Pedja-2000','korisnik','Mirkovic','0666324414','pedja1234',1);

INSERT INTO TERMINSKA_LISTA(broj_clanova,cena,dan,fitness_centar_id) VALUES ('30','50','utorak',1);

INSERT INTO TRENING(trajanje,naziv,opis,tip_treninga,cene_id,trener_id,trening_id) VALUES ('2.5','ultrax','grudiramena','personalni',1,1,1);

INSERT INTO LISTA_ODRADJENIH_TRENINGA (clan_id,termin_id) VALUES (1,1);

INSERT INTO LISTA_PRIJAVLJENIH_TRENINGA (clan_id,termin_id) VALUES (1,1);

INSERT INTO OCENA_ODRADJENIH_TRENINGA (clan_id,termin_id) VALUES (1,1);

INSERT INTO SALA (kapacitet,oznaka_sale,fitness_centar_id,trening_id) VALUES ('20','1',1,1);
