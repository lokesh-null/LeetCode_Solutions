class Solution:
    def angleClock(self, hour: int, minutes: int) -> float:
        hour %= 12

        minAngle = minutes * 6.0
        hourAngle = hour * 30.0 + minutes * 0.5
        angle = abs(hourAngle - minAngle)
        return min(angle, 360 - angle)