### Harjoitustyön aihe
**Aihe:** tietokonepeli Tetris. Pelissä ohjataan eri muotoisia putoavia palikoita, joista on tarkoitus saada tasaisia vaakarivejä. Vaakarivit tuhoutuvat ja jokaisesta tuhotusta rivistä saa pisteitä. Tuhottujen rivien yläpuolella olevat rivit siirretään alemmas. 

Tetris-palikoita kutsutaan tetrominoiksi ja nämä koostuvat neljästä neliön muotoisesta osasta. Eri muotoisia tetrominoja on yhteensä seitsemän. Pelin haasteena on saada eri muotoiset osat sopimaan mahdollisimman hyvin yhteen tetrominon pudotessa määrätyllä nopeudella alaspäin. Tetrominoja on mahdollista ohjata sivuttaissuunnassa sekä kääntämällä myötä/vastapäivään ja nopeuttaa putoamista.

**Käyttäjät:** kaikki pulmapeleistä kiinnostuneet.

**Käyttäjien toiminnot:**
- Tetrominon kääntäminen myötäpäivään
- Tetrominon kääntäminen vastapäivään
- Tetrominon siirtäminen oikealle
- Tetrominon siirtäminen vasemmalle
- Tetrominon siirtäminen alas
- Tetrominon pudottaminen alas

##Rakennekuvaus

Pelissä on kolme varsinaista objektiluokkaa Game, Board ja Tetromino. Luokat sisältävät oman logiikkansa: Game-luokka vastaa palojen siirtämisestä ja peli-luupista. Luuppi on toteutettu Swingin ajastimella. Board-luokka tietää laudan tilan, alustaa laudan, luo uudet tetrominot ja kiinnittää palat lautaan. Tetromino-luokkassa luodaan tetrominoon liittyvät palat ja näille asetetaan halutun muodon mukaiset koordinaatit ja väri. Luokka vastaa myös tetrominon rotaatioista.

TRenderer luokka on niin sanottu piirtoalusta, joka vastaa ohjelman komponenttien piirtämisestä. Piirrettäviä komponentteja ovat pelilaudan kehys, aktiivinen tetromino sekä paikallaan olevat palat. Peliluuppi kutsuu TRenderer luokan update-metodia, jolloin komponentit piirretään uudestaan.

Ui käyttöliittymäluokan kautta kuunnellaan käyttöliittymään kohdistuvia näppäinten painalluksia. Tätä varten luokassa luodaan KeyboardListener, jolle lisätään Game-luokan olio. Tätä kautta KeyboarListenerin eventit pääsee Game-luuppiin käsiksi.

![Luokkakaavio](/dokumentaatio/Luokkakaavio_ver3.png)
![Käynnistys sekvenssi](/dokumentaatio/SetupSeq.png)
