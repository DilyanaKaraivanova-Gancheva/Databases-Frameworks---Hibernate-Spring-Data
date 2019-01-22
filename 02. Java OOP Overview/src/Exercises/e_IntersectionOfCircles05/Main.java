package Exercises.e_IntersectionOfCircles05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] firstCircle = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondCircle = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Circle c1 = new Circle(new Point(firstCircle[0],firstCircle[1]),firstCircle[2]);
        Circle c2 = new Circle(new Point(secondCircle[0],secondCircle[1]),secondCircle[2]);

        if (intersect(c1,c2)){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }

    private static boolean intersect(Circle c1, Circle c2){
        double distance = Math.sqrt(Math.pow((c2.getCenter().getX()-c1.getCenter().getX()),2)+
                Math.pow((c2.getCenter().getY()-c1.getCenter().getY()),2));
        return (c1.getRadius() + c1.getRadius()) >= distance;
    }
}
