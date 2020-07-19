package net.ddns.johnnystene.infinitytoolkit.engine;

public class Test {
    public static void main(String[] args) {
        Game game = new Game("Infinity Toolkit - Test application", 800, 600) {
            @Override
            public void doTick() {
                System.out.println("Game tick!");
            }
        };
        game.start();
    }
}
