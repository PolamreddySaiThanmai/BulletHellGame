package com.bullethell.game.Algorithms.EnemyMovePattern;

import com.badlogic.gdx.utils.TimeUtils;
import com.bullethell.game.entities.Enemy.Enemy;

//go steadily straight from top to bottom
public class SteadyDrop extends EnemyMovePattern {
    private float newX, newY;
    private float curX, curY;
    private Enemy entity;

    public SteadyDrop(int attackingDuration)
    {
        super(attackingDuration);
    }

    public void applyMovePattern(Enemy entity) {
        curX = (float)entity.getPos().x;
        curY = (float) entity.getPos().y;
        this.entity = entity;

        if (TimeUtils.millis() - initTime < dTimeToRetrieve)
            move();
        else
            retrieve();
    }

    private void move()
    {
        newX = curX;
        newY = (float) (curY - entity.getSpeed());
        entity.setPos(newX, newY);
    }

    private void retrieve()
    {
        newX = curX;
        newY = curY+1;
        entity.setPos(newX, newY);
    }
}
