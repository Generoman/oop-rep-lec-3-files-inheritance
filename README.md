## Hvordan laste ned prosjektet:

### Metode 1:
* Trykk på den grønne "Code"-knappen oppe til høyre på GitHub
* Velg `Download ZIP`
* Pakk ut ZIP-filen i en egenvalgt mappe, og åpne prosjektet i IntelliJ

### Metode 2:
* Trykk på den grønne "Code"-knappen oppe til høyre på GitHub
* Trykk på knappen til høyre for linken
* Velg `New -> Project from Version Control...` i IntelliJ
* Lim inn linken i URL-feltet og velg mappa hvor prosjektet skal lagres

### Oppdatere allerede nedlastet prosjekt:
* Trykk på den blå pila ved siden av teksten "Git" oppe til høyre i IntelliJ
* Om dere har endret koden mellom nedlasting og oppdatering, kan det skje en merge-konflikt. En måte å løse det på er å laste ned prosjektet på nytt

## Ordliste
* Polymorfisme / Polymorphism:
  * Konseptet om at et objekt tilhører flere klasser samtidig gjennom arv
  * En metode kan kjøres på forskjellige måter utifra hvilken klasse vi behandler et objekt som
  * Streng talt ikke viktig å huske for å bestå faget
* Casting:
  * Å behandle et objekt som om det tilhører superklassen eller subklassen
* Upcasting:
  * Å behandle et objekt som om det tilhører superklassen
  * Skjer uten at vi trenger å skrive noe ekstra i koden
  * Se eksempel på linje 13, 17, og 21 i CarChecker-klassen
* Downcasting:
  * Å behandle et objekt som om det tilhører en subklasse
  * Krever at vi spesifiserer hvilken subklasse vi caster til
  * Se eksempel på linje 49, 58, og 67 i CarChecker-klassen
* `instanceof`-nøkkelordet:
  * Brukes for å se om et objekt er en instans av en gitt klasse (tilhører en gitt klasse)
  * Se eksempel på linje 45, 54, og 63 i CarChecker-klassen
* `equals`-metoden:
  * Brukes for å sjekke om to objekter har samme verdier
  * Dobbelt likhetstegn sjekker bare om to objekter er *det samme*, mens `equals` sjekker fields
    * Merk at for at `equals` skal fungere på denne måten, må den overrides
    * Dette kan gjøres automatisk ved å generere koden i IntelliJ
  * Se mer info her: https://www.baeldung.com/java-equals-hashcode-contracts
* `hashCode`-metoden:
  * En metode som genererer en semi-unik tallverdi for et objekt
  * Hvis `equals` overrides, må også `hashCode` overrides
  * Se linken i forklaringen av `equals`-metoden for mer info
* Unntak / Exceptions:
  * "Feil" i koden som vi ikke alltid kan forutse
  * Checked exceptions oppdages før koden kjører, under kompilering
  * Unchecked exceptions må enten kastes videre, eller ligge i en try/catch-blokk
  * IntelliJ gir beskjed når en metode må behandle en exception, og viser også hvilken type exception som skal behandles
* `throws`-nøkkelordet:
  * Brukes for å vise at en metode sender en unchecked exception videre til en annen metode
  * En exception kan kastes helt opp til `main`-metoden
  * Om den ikke fanges opp noen steder, vil programmet til slutt kræsje
* `try`/`catch`-blokk:
  * Brukes som et alternativ til `throws` nøkkelordet
  * Kan sammenlignes med en `if`/`else`
    * `try`-delen skjer hvis en exception ikke oppstår
    * `catch`-delen skjer hvis det ER en exception