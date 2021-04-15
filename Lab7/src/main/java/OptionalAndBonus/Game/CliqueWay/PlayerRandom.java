package OptionalAndBonus.Game.CliqueWay;

import OptionalAndBonus.Utils.Utils;

public class PlayerRandom extends PlayerCliqueGame{
    public PlayerRandom(CliqueGame game, String name) {
        super(game, name);
    }

    @Override
    protected void myTurnLogic() {
        int edgesCount = graph.getEdgesCount();
        if (edgesCount == 0) {
            return;
        }
        System.out.println(name + "'s turn. Random player.");
        Edge myEdge = graph.getNthEdge(Utils.generateRandomInt(0, edgesCount - 1));
        graph.removeEdge(myEdge);
        edges.add(myEdge);

        verifyScore();
    }
}
