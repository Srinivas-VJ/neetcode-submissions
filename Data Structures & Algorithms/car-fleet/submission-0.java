class Car {
    int position;
    int speed;

    public Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    boolean willCollide(Car car, int target) {
        Car furtherCar = car.position > this.position ? car : this;
        Car laggingCar = furtherCar == car ? this : car;

        int shorterDistance = target - furtherCar.position;
        float timeTakeByFurtherCar = (float) shorterDistance / (float) furtherCar.speed;
        // if the lagging car can reach the target in the time the further car reaches the target, then they collide somewhere
        return timeTakeByFurtherCar * (float) laggingCar.speed + (float)laggingCar.position >= (float)target;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++)
            cars.add(new Car(position[i], speed[i]));

        cars.sort((a, b) -> a.position - b.position);

        Stack<Car> stack = new Stack<>();
        for (Car car : cars) {
            if (stack.isEmpty()) {
                stack.add(car);
                continue;
            }
            Car furthestCar = stack.peek();
            while(furthestCar.willCollide(car, target)) {
                stack.pop();
                if (stack.isEmpty())
                    break;
                furthestCar = stack.peek();
            }
            stack.add(car);
        }

        return stack.size();
    }
}