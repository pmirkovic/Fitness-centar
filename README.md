Specifikacija projekta
Web programiranje 2020/2021
1. Model podataka
  Zadatak je implementirati sistem za rad fitness centra.
  Korisnici sistema mogu se pojaviti u sledećim ulogama:
    ● Administrator
    ● Trener
    ● Član fitness centra
  Svaki korisnik je opisan sa sledećim podacima:
    ● Korisničko ime
    ● Lozinka
    ● Ime
    ● Prezime
    ● Kontakt telefon
    ● E-mail adresa
    ● Datum rođenja
    ● Uloga
    ● Aktivan (označava da li ovaj korisnik trenutno ima pristup sistemu)
  Za svakog člana fitness centra vezuju se još i podaci:
    ● Lista odrađenih treninga
    ● Lista treninga za koje su se prijavili (ali ih još nisu odradili)
    ● Lista ocena za odrađene treninge (ne mora oceniti svaki trening koji je
    odradio)
  Za svakog trenera vezuju se još i podaci:
    ● Lista treninga koje on drži
    ● Prosečna ocena (srednja ocena koja se izračuna svaki put kada neko oceni
    trening koji je on održao)
  Pored korisnika, u okviru sistema neophodno je čuvati podatke i o sledećim
  entitetima:
    Trening:
      ● Naziv
      ● Opis
      ● Tip treninga
      ● Trajanje
    Fitness centar:
      ● Naziv
      ● Adresa
      ● Broj telefona centrale
      ● E-mail
      ● Treneri koji rade u tom fitness centru
      ● Lista sala koje se nalaze u tom fitness centru
      ● Raspored održavanja treninga zajedno sa cenama za svaki termin posebno
      Sala:
      ● Kapacitet
      ● Oznaka sale
      ● Za salu se još vezuje
        ○ Terminska lista treninga (koji trening se održava u kom danu i po kojoj ceni
        - isti trening se može u istim danima održavati u različitim salama, veza
        N:N), koja sadrži i broj prijavljenih članova za taj termin.
2. Funkcionalnosti
  Funkcionalnost koje su dostupne svim korisnicima:
    ● Registracija korisnika (registraciju korisnika koji nije u ulozi člana fitness
    centra mora potvrditi administrator da bi se aktivirala)
    ● Prijava na sistem (neaktivni korisnici se ne mogu prijaviti čak i kada su
    kredencijali tačni)
    ● Pregled treninga koji su u ponudi
    ● Pretraga treninga po kriterijumima:
      ○ Nazivu
      ○ Tip
      ○ Opisu
      ○ Ceni
      ○ Vremenu termina
    ● Višekriterijumska pretraga (kombinacija više prethodno navedenih kriterijuma)
    ● Sortiranje termina (po vremenu ili po ceni)
  Funkcionalnosti koje su dostupne samo članovima fitness centra:
    ● Odabir željenog termina treninga iz rezultata pretrage
    ● Prijava za željeni termin treninga ukoliko ima slobodnih mesta
    ● Pregled svih treninga za koje su se prijavili
    ● Otkazivanje prijave za trening
    ● Pregled profila
    ● Pregled svih odrađenih treninga
    ● Pregled treninga koje su odradili, a nisu ocenili
    ● Mogućnost ocenjivanja odrađenih treninga
    ● Pregled odrađenih treninga koje su ocenili
  Funkcionalnosti koje su dostupne samo trenerima:
    ● Kreiranje i izmena rasporeda treninga za fitness centar u kom radi - Za svaki
    termin treninga u rasporedu neophodno je dodeliti datum i vreme održavanja
    termina i cenu za taj termin.
  Funkcionalnosti koje su dostupne samo administratoru:
    ● Dodavanje, izmena i brisanje fitness centra
    ● Dodavanje, izmena i brisanje sala za odabrani fitness centar
    ● Odobravanje zahteva za registraciju trenera
    ● Registracija novih trenera (automatski se odobrava)
    ● Uklanjanje trenera
3. Implementacija
  Aplikaciju realizovati kao klijent-server aplikaciju.
  Serverski deo aplikacije treba da bude realizovan korišćenjem Java programskog
  jezika i Spring (SpringBoot) radnog okvira.
  Dizajn korisničkog interfejsa, kao i stilovi (CSS) su prepušteni studentu i
  obavezni su. Za olakšanje formiranja layouta stranica studenti mogu koristiti neki
  od postojećih framework-a (Bootstrap, MaterializeCSS…).
