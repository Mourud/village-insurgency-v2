package com.villageinsurgency.game.model;

import com.villageinsurgency.game.model.constants.GameConstants;

import java.util.Objects;

public class Position {
    private static final int BUFFER = 2 * GameConstants.SOLDIER_SIZE;

    private int posX;
    private int posY;

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Position(int x, int y) {
        posX = x;
        posY = y;
    }

    public void changePos(int x, int y) {
        posX = x;
        posY = y;
    }

    public void random(boolean isPlayer) {
        if (isPlayer) {
            posX = GameConstants.BIRTH_RADIUS + (int) (Math.random() * GameConstants.BIRTH_RADIUS + 1);
            posY = GameConstants.GAME_SCREEN_HEIGHT - BUFFER - (int) (Math.random() * GameConstants.BIRTH_RADIUS - 1);
        } else {
            posX = GameConstants.GAME_SCREEN_WIDTH - GameConstants.BIRTH_RADIUS - (int) (Math.random() * GameConstants.BIRTH_RADIUS - 1);
            posY = BUFFER + (int) (Math.random() * GameConstants.BIRTH_RADIUS + 1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return posX == position.posX && posY == position.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }
}
