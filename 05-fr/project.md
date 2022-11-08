# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu([UC4](#uc4)).
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu([UC2](#uc2)).

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC2](#uc2): Przekazanie produktu

[Kupujący](#ac2)
* [UC3](#uc3): Oferowanie kwoty za produkt
* [UC4](#uc4): Przekazanie należności

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą. 
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Przekazanie produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System prosi [sprzedającego](#ac1) o wysłanie produktu.
2. System prosi [sprzedającego](#ac1) o wgrywiu potwierdzenia nadania paczki do systemu.
3. System weryfikuję potwierdzenie.
4. System wysyła [kupującemu](#ac2) informację o przesyłce.
5. System weryfikuję odbiór przesyłki.


**Scenariusze alternatywne:** 

3.A. Nie zostało podane potwierdzenie w wyznaczonym terminie.
* 3.A.1. System informuje o nie nadaniu paczki w wyznaczonym terminie.
* 3.A.2. System zwraca pięniądzę na konto [kupującego](#ac2)

3.B. Podano niepoprawne potwierdzenie
* 3.B.1. System informuję o błędnie podanych danych.
* 3.B.2. Przejdź do kroku 2

---

<a id="uc3"></a>
### UC3: Oferowanie kwoty za produkt
**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć oferowania kwoty za produkt.
2. System prosi o podanie nowej ceny produktu.
3. [Kupujący](#ac2) podaje nową cenę.
4. System weryfikuje poprawność podanej ceny.
5. System zmienia cenę produktu.

**Scenariusze alternatywne:** 

4.A. Podana cena jest nie poprawna lub nie odpowiada [BR1](#br1)
* 4.A.1. System informuję o błędnie podanej cenie.
* 4.A.2. Przejdź do kroku 2.  

---

<a id="uc4"></a>
### UC4: Przekazanie należności

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System weryfikuję wygranie aukcji przez [Kupującego](#ac2). 
2. System prosi kupującego o wgrywaniu kwoty. ([BR2](#br2))
3. [Kupujący] wgrywa kwotę do systemu.
4. System weryfikuje naliczenie kwoty.
5. System przekazuję kwotę do [Sprzedającego](#ac1)

**Scenariusze alternatywne:** 

3.A. Nie wgrana kwota lub nie wystarcza pieniędzy na koncie.
* 3.A.1. System informuje o nie wgranej kwocie.
* 3.A.2. Przejdź do kroku 2.


---

## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

### BO3: Przesyłka

Produkt fizyczny wysłany drogą pocztową

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | Przesyłka |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    |  |
| UC2: Przekazanie produktu                                            |     |  U    | C |
| UC3: Oferowanie kwoty za produkt                                             | R U    |     |  |
| UC4: Przekazanie należności                       |D|||

