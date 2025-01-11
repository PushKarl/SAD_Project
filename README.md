# SAD_Project
Final Project for our SAD Lecture. 

Software Architektur & Design
# Programmierung eines Flipperautomaten mithilfe von Entwurfsmustern.

Verwenden sie die in der Lehrveranstaltung vorgenommenen Entwurfsmuster, um einen Ablauf eines Flipperautomaten zu simulieren.
Die Angaben müssen nicht exakt so umgesetzt werden und dienen lediglich als Inspiration.
Erfinden sie ein Szenario nach ihrer Fantasie!

## Zustand
- Der Flipper befindet sich anfangs im <mark>NoCredit-Zustand</mark>. Nach Einwurf einer Münze wechselt dieser in den <mark>Ready-Zustand</mark> und bleibt dort, bis der <mark>Start-Knopf</mark> gedrückt wird.
- Der <mark>Start-Knopf</mark> versetzt den Automaten in den <mark>Playing-Zustand<7mark>. Zu jedem Zeitpunkt können weitere Münzen eingeworfen werden, welche den Kredit erhöhen.
- Wird der <mark>Start-Knopf im NoCredit-Zustand gedrückt</mark>, so erscheint eine Meldung, dass <mark>kein Kredit</mark> vorhanden ist.
- Wird der <mark>Start-Knopf während des Playing-Zustandes gedrückt</mark>, so erscheinen die <mark>Autoren der Software</mark>.
- Ist eine <mark>Kugel 3-mal verloren gegangen</mark>, so wechseln sie in den <mark>End State</mark>, bei welchem sie ein Spiel gewinnen können. Danach wechselt der Automat, je nach Kredit, in den No-Credit- bzw. Ready-Zustand.

## Befehl und Kompositum
- Erstellen sie ein paar <mark>Flipper-Elemente</mark> (z. B. Rampe, Target, Bumper, SlingShot, Hole, Kicker, etc.), welche sie beliebig oft instanziieren können.
- Verwenden sie das <mark>Command-Pattern</mark> (Befehl bzw. Kommando), um zu spezifizieren, was passiert, wenn ein gewisses Element getroffen wird (z. B. wenn die hit-Methode aufgerufen wird).
- Verwenden sie auch das <mark>Kompositum-Muster</mark> zusammen mit dem Kommando-Muster, um komplexere Befehle (Makro-Befehle) zu erstellen.

Zum Beispiel können sie ein Hole derart konfigurieren, sodass ein <mark>Befehl für die Punktevergabe</mark> zuständig ist und ein weiterer Befehl den Spieler bzw. die Spielerin zwischen 1, 2 und 3 wählen lässt, wobei es beim Erraten Zusatzpunkte gibt.

## Adapter
Verwenden sie den <mark>objektbasierten Adapter</mark> und binden sie ein inkompatibles Flipperelement oder einen inkompatiblen Befehl
(Command) in den Flipper ein.

## Vermittler (Mediator)
- Verwenden sie einen (oder mehrere) <mark>Vermittler</mark>, in welchem sie spezifizieren, <mark>wie die Flipper-Elemente miteinander zusammenarbeiten</mark>.
- Zum Beispiel könnte sich eine Rampe öffnen, wenn alle Targets einer Gruppe getroffen wurden.
- Ebenfalls könnten alle Targets einer Gruppe wieder rauf gehen, nachdem das letzte Target der Gruppe getroffen wurde.

## Visitor (Besucher):
- Verwenden sie das Visitor Pattern (Besucher) und <makr>implementieren sie 2 Besucher</mark>, welche eine Liste von abstrakten Flipper-Elementen durchlaufen kann um Funktionen der Konkreten Flipper-Elemente aufrufen zu können.
- Ein <mark>ResetVisitor</mark> soll dabei alle Elemente in den Anfangszustand versetzen – Rampen werden z. B. geschlossen und die Anzahl der Durchläufe auf 0 gesetzt, Targets werden hochgefahren und die Leds ausgeschalten, etc.
- Ein <mark>PunkteVisitor</mark> soll durch die Elemente gehen und Punkte nach einem gewissen Schema, welches sie frei erfinden dürfen, berechnen.
- Zum Beispiel werden die Anzahl der Durchläufe mit einem Wert multipliziert, welcher vom Level oder von sonstigen Zuständen des Flippers abhängt!

Rufen sie den Punkte-Visitor nach jedem Verlust der Kugel auf und geben sie die Punkte aus.

## Abstrakte Fabrik:
Verwenden sie die Abstrakte Fabrik, um die <mark>Ausgabe auf dem Flipper in unterschiedlichem Format darzustellen</mark>.

Zum Beispiel könnte beim Wechsel in den Playing-Zustand – je nach Kugel - folgende Ausgabe erscheinen: BALL 1

Folgender Link ist bei der Generierung von ASCII-Schriften hilfreich:
http://patorjk.com/software/taag

Verwenden sie <mark>2 Schriftfamilien</mark> und erstellen sie Ausgaben für das Flipper-Display. (Z. B. Press Start, Game Over, Ball 1, Ball 2, Ball 3, …)
Die Auswahl der Schriftfamilie soll gesteuert werden können.

## Singleton
Verwenden sie das Singleton-Muster, wo es ihnen als geeignet erscheint.

## Weitere Ideen (optional):
- Erstellen sie einen weiteren Mediator, mit welchem ein anderer Spielablauf bzw. ein anderes Verhalten der Elemente möglich ist.
- Kombinieren sie den Mediator mit dem Besucher-Muster (Visitor).
- Erstellen sie häufig verwendete Elemente mithilfe des Prototype-Musters.
