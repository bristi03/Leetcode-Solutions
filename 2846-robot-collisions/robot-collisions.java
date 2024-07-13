class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];

        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(robots, Comparator.comparingInt(robot -> robot.position));

        Stack<Robot> stack = new Stack<>();
        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek().direction == 'R') {
                    Robot top = stack.pop();
                    if (top.health > robot.health) {
                        top.health--;
                        robot = null;
                        stack.push(top);
                        break;
                    } else if (top.health < robot.health) {
                        robot.health--;
                        top = null;
                    } else {
                        robot = null;
                        top = null;
                        break;
                    }
                }
                if (robot != null) {
                    stack.push(robot);
                }
            }
        }

        List<Robot> survivingRobots = new ArrayList<>(stack);
        survivingRobots.sort(Comparator.comparingInt(robot -> robot.index));

        List<Integer> result = new ArrayList<>();
        for (Robot robot : survivingRobots) {
            result.add(robot.health);
        }

        return result;
    }

    static class Robot {
        int position;
        int health;
        char direction;
        int index;

        Robot(int position, int health, char direction, int index) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }
}