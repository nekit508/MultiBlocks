package classes.blocks.MBParts;

import mindustry.world.blocks.defense.Wall;

public class BaseMBPart extends Wall {
    public float speedUp = 0f, warmupUp = 0f, energyInIncrease = 0f, energyOutIncrease = 0f;

    public BaseMBPart(String name) {
        super(name);
        size = 1;
        health = 60;
    }

    public class BaseMBPartBuilding extends WallBuild {

    }
}
