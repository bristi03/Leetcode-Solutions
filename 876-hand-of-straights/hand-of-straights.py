class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if groupSize == 1:
            return True
        hand.sort()
        for i in range (len(hand)):
            if hand[i] == -1:
                continue
            current = hand[i]
            if not self.hasGroup(current, i, hand, groupSize):
                return False
        return True

    def hasGroup(self, current, start, hand, groupSize):
        search = current + 1
        count = 1
        for j in range(start + 1, len(hand)):
            if hand[j] == search:
                search += 1
                count += 1
                hand[j] = -1
            if count == groupSize:
                return True
        return False