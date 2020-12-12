package abstractclass.gamecharacter;

public class BattleField {

    private int round;

    public int getRound() {
        return round;
    }

    private boolean oneHit(Character attacker, Character defender) {
        if (attacker.isAlive() && defender.isAlive()) {
            attacker.primaryAttack(defender);
            attacker.secondaryAttack(defender);
        }
        return attacker.isAlive() && defender.isAlive();
        // amely igazzal tér vissza, ha mindkét karakter él.
        // Törzsében meghívja a támadó (attacker) primaryAttack() majd secondaryAttack() metódusait,
        // melyeknek paramétere a védekező defender, ha még mindkettő él.
    }

    public Character fight(Character one, Character other) {
        while (oneHit(one, other) && oneHit(other, one)) {
            round++;
        }
        return one.isAlive() ? one : other;
//        amely visszatér az élve maradt karakterrel. Törzsében
//        mindaddig hívja a privát oneHit metódust felváltva a támadó és védekező szerepeket, amíg valamelyik meg nem hal.
//        Minden körben először a one támadja az other-t, majd az other a one-t.
//                közben növeli a round attribútum értékét.
//                végül visszatért az élő karakter referenciával.
    }
}
