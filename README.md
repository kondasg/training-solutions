# Junior Java backend fejlesztő

Ez a repository tartalmazza a Junior Java backend fejlesztő tematikáját és gyakorlati feladatainak megoldásait.

## Gyakorlati vizsga feladatok

* II. részvizsga ([exam02](https://github.com/kondasg/training-solutions/tree/master/src/main/java/exam02))
* III. részvizsga ([exam03](https://github.com/kondasg/training-solutions/tree/master/src/main/java/exam03))
* Záróvizsga ([zarovizsga](https://github.com/kondasg/zarovizsga))

## Projekt feladatok

* I. projekt: MeetingRoom ([meetingrooms](https://github.com/kondasg/training-solutions/tree/master/src/main/java/meetingrooms))
* II. projekt: Schoolrecords ([schoolrecords](https://github.com/kondasg/training-solutions/tree/master/src/main/java/schoolrecords))
* III. projekt: Catalog ([catalog](https://github.com/kondasg/training-solutions/tree/master/src/main/java/catalog))
* IV. projekt: Activity ([activity](https://github.com/kondasg/training-solutions/tree/master/src/main/java/activity)) 
* V. projekt: Timesheet ([timesheet](https://github.com/kondasg/training-solutions/tree/master/src/main/java/timesheet))
* Záró projekt: Oltásokat kezelő alkalmazás ([covid]())

## Napi feladatok

Napi konzltációk feladatai (weekxxdxx)

## Tematika

### Bevezetés a nyelvi eszközökbe

**Eszközkészlet**

* Java történeti háttér
* Java platform
* Maven
* IDE - IntelliJ IDEA
* Git használata az IDE-ben
* Feltöltés GitHubra ([introgit](https://github.com/kondasg/introgit))

**Java osztályok**

* Kiírás és beolvasás konzolról (classstructureio)
* Objektumok és attribútumok (classstructureattributes)
* Metódusok (classstructuremethods)
* Konstruktorok (classstructureconstructors)
* UML, példányok konzol íráskor/olvasáskor (classstructureintegrate)

**A nyelv építőkövei**

* Kódolási konvenciók (conventions)
* Literálok és lokális változók (localvariables)
* Kifejezések és utasítások (statements)
* Csomagok (packages)
* Java API (javaapi)
* JAR állomány (distjar)
* Szöveges típus (stringtype)
* Dátum és időkezelés alapok (introdate)
* Bevezetés a vezérlési szerkezetekbe (introcontrol)

**Bonyolultabb típusok**

* Tömbök (array)
* Parancssori paraméterek (cmdarguments)
* Tömbök tömbje (arrayofarrays)
* Tömbök kezelése (arrays)
* Lista (arraylist)
* Debug (debug)
* Konstans értékek használata (finalmodifier)
* Math és Random osztály (math)

**Bevezetés az osztályok és objektumok világába**

* Objektumok (objects)
* Bevezetés az attribútumok használatába (attributes)
* Bevezetés a konstruktorok használatába (introconstructors)
* Bevezetés a metódusok használatába (intromethods)
* Referenciák (references)

### A Java nyelv részletes megismerése

**Típusok és operátorok**

* Literálok (literals)
* Egyszerű típusok (primitivetypes)
* Felsorolásos típus (enumtype)
* Operátorok (operators)
* Típuskonverzió (typeconversion)
* Egész és lebegőpontos számok (numbers)

**Vezérlési szerkezetek**

* Unit tesztelés JUnittal (introjunit)
* JUnit 5 (junit5)
* Vezérlési szerkezetek és az elágazás (controlselection)
* Ciklusok (controliteration)
* Haladó vezérlési szerkezetek (controladvanced)
* Bevezetés a kivételkezelésbe (introexception)

**String, StringBuilder**

* String alapok (stringbasic)
* Konkatenáció (stringconcat)
* Főbb String metódusok (stringmethods)
* StringBuilder (stringbuilder)
* Scanner (stringscanner)
* Fájl olvasása Scannerrel (filescanner)
* printf (formatlocaleprintf)

**Programozási tételek és egyéb algoritmusok**

* Összegzés tétele (algorithmssum)
* Számlálás tétele (algorithmscount)
* Szélsőérték keresés tétele (algorithmsmax)
* Eldöntés tétele (algorithmsdecision)
* Rekurzió (recursion)

### Objektumorientáltság

**Attribútumok és metódusok**

* Immutable objektumok (immutable)
* JavaBeans objektumok (javabeans)
* Metódusok (methodstructure)
* Értékmásolás szerinti paraméterátadás (methodpass)
* Metódus paraméterek (methodparam)
* Változó hosszúságú paraméterlista (methodvarargs)
* Metódus hívások láncolása (methodchain)
* Metódusnév túlterhelés (methoverloading)
* Statikus attribútumok és metódusok (staticattrmeth)

**Konstruktorok és inicializátorok**

* Default és paraméter nélküli konstruktor (defaultconstructor)
* Konstruktor túlterhelés (constructoroverloading)
* Inicializátorok (initializer)

**Öröklődés**

* Öröklődés (introinheritance)
* Konstruktorok és az öröklődés viszonya (inheritanceconstructor)
* Object ősosztály (objectclass)
* Attribútumok öröklődése (inheritanceattributes)
* Metódusok öröklődése (inheritancemethods)

**Absztrakt osztályok és interfészek**

* Absztrakt osztályok (abstractclass)
* Interfészek (interfaces)
* Interfészekkel kapcsolatos szabályok (interfacerules)
* Dependency inversion (interfacedependencyinversion)
* Default interfész metódusok (interfacedefaultmethods)
* Statikus interfész metódusok (interfacestaticmethods)
* Interfészek és az öröklődés viszonya (interfaceextends)
* Absztrakt metódusok implementálása felsorolásos típusokban (enumabstract)
* Állapotgép (statemachine)

**Haladó OO elvek**

* Polimorfizmus (polymorphism)
* Dinamikus kötés (virtualmethod)
* is-a has-a kapcsolatok (isahasa)

### Kivétel- és fájlkezelés

**Kivételkezelés**

* Kivételkezelés (exceptions)
* Saját kivétel (exceptionclass)
* Multi catch (exceptionmulticatch)
* Try-With-Resources szerkezet (exceptionresource)

**Fájlkezelés**

* Szöveges állomány beolvasása (ioreadstring)
* String kiírása szöveges állományba (iowritestring)
* Bájtos beolvasása fájlból és kiírása fájlba (ioreadwritebytes)
* String olvasása Readerrel (ioreader)
* String írása Writerrel (iowriter)
* Különböző típusok írása PrintWriterrel (ioprintwriter)
* Kiírás Stringbe StringWriterrel (iostringwriter)
* Bájtok olvasása InputStreammel (ioreadbytes)
* String olvasása classpath-ról (ioreaderclasspath)
* Bájtok írása OutputStreammel (iowritebytes)
* Adatok írása OutputStreamre, és olvasás (iodatastream)
* Bájtok írása tömörítéssel (iozip)
* Konvertálás a típusok között (ioconvert)
* Files osztály használata (iofiles)
* Fájlkezelés tesztelése (iofilestest)

### Kollekciók és osztálykönyvtárak

**Kollekció típusok**

* Generikusok használata, diamond operátor (genericsusage)
* equals, hashCode (collectionsequalshash)
* List, ArrayList kontra LinkedList (collectionslist)
* Set (collectionsset)
* Queue (collectionsqueue)
* Map (collectionsmap)
* Autoboxing használata kollekcióknál (collectionsautoboxing)

**Alapvető algoritmusok**

* Bejárás (collectionsiterator)
* Comparable és Comparator (collectionscomp)
* Keresés (searching)
* Rendezés (sorting)
* Collections osztály (keresésen, rendezésen felüli metódusok) (collectionsclass)
* A clone() metódus, deep clone (clone)
* Properties állományok (properties)

### Adatbázis programozás Java nyelven

**JDBC**

* Egyszerű JDBC adatmódosítás
* Egyszerű JDBC lekérdezés
* Alkalmazás architektúra
* Generált azonosító lekérdezése
* Tranzakciókezelés
* Adatbázis metaadatok
* Haladó ResultSet
* Blob
* Spring JdbcTemplate

## 

**Képző intézmény:** Training360  
**Vezető oktató, mentor:** [Viczián István](https://hu.linkedin.com/in/viczianistvan)  
**Mentor:** [Bárczay Kristóf](https://hu.linkedin.com/in/krist%C3%B3f-b%C3%A1rczay-6aa0351b6)  
**Mentor:** [Arold Ádám](https://hu.linkedin.com/in/adamarold)  
