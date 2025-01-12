package elemente;

import elemente.FlipperElement;
import visitor.FlipperElementVisitor;

import java.util.Random;
public class Bumper extends FlipperElement {
    private int hits = 0;
    private int points = 0;

    public void hit() {
        hits++;
        Random random = new Random();
        int pointsAwarded = random.nextInt(101) + 50; // Zufällige Punkte zwischen 50 und 150
        points += pointsAwarded;
        System.out.println("Bumper getroffen! Punkte: " + pointsAwarded);

        // Spezieller Effekt bei jedem 5. Treffer
        if (hits % 5 == 0) {
            points *= 2;
            System.out.println("Bonus: Punkte wurden verdoppelt! Gesamtpunkte: " + points);
        }
    }

    public void reset() {
        hits = 0;
        points = 0;
        System.out.println("Bumper wurde zurückgesetzt.");
    }

    public int getPoints() {
        return points;
    }

    public int getHits() {
        return hits;
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }
}
