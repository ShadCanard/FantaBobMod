package com.shadcanard.fbm.utils;

/**
 * Created by Shad on 28/08/2016.
 */
public class SoundHelper {
    public static String getButtonAction(boolean isFanta, int buttonID){
        String result = "fbm:soundbox.";
        result = result + (isFanta ? "fanta.":"bob.");
        switch (buttonID){
            case 1:
                result = result + "greets";
                break;
            case 2:
                result = result + "laugh";
                break;

            case 3:
                result = result + "applause";
                break;

            case 4:
                result = result + "troll";
                break;

            case 5:
                result = result + "attack";
                break;

            case 6:
                result = result + "flee";
                break;

            case 7:
                result = result + "bye";
                break;

            case 8:
                result = result + "joke";
                break;

            case 9:
                result = result + "follow";
                break;
        }
        return result;
    }
}
