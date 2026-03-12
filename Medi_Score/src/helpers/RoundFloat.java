package helpers;

public class RoundFloat {
    /*
      Method to round off a number
      Source - https://stackoverflow.com/a/22186845
      Posted by jpdymond
      Retrieved 2026-03-11 and edited, License - CC BY-SA 3.0
    */

    public static float round(float value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (float) Math.round(value * scale) / scale;
    }
}
