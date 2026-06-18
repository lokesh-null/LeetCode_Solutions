class Solution {
    public double angleClock(int hour, int minutes) {
        hour %= 12;

        double minAngle = minutes * 6.0;
        double hourAngle = hour * 30.0 + minutes * 0.5;
        double angle = Math.abs(hourAngle - minAngle);
        return Math.min(angle, 360 - angle);
    }
}