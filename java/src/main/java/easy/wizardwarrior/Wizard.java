package easy.wizardwarrior;

public class Wizard extends Fighter {

    boolean isSpellPrepared = false;

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    @Override
    boolean isVulnerable() {
        return !isSpellPrepared;
    }

    @Override
    int getDamagePoints(Fighter target) {
        return isSpellPrepared ? 12 : 3;
    }

    void prepareSpell() {
        isSpellPrepared = true;
    }
}
