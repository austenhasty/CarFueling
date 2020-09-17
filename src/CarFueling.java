import java.util.*;

public class CarFueling {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int distance = s.nextInt();
        int tankSize = s.nextInt();
        int n = s.nextInt();
        int[] stops = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            stops[i] = s.nextInt();
        }
        stops[0] = 0;
        stops[stops.length - 1] = distance;
        System.out.println(getStops(tankSize, n, stops));
    }

    private static int getStops(int tankSize, int n, int[] stops) {
        int refills = 0;
        int currentStop = 0;
        int lastStop;
        while (currentStop <= n) {
            lastStop = currentStop;
            while (currentStop <= n && stops[currentStop + 1] - stops[lastStop] <= tankSize) {
                currentStop++;
            }
            if (currentStop == lastStop) {
                return -1;
            }
            if (currentStop <= n) {
                refills++;
            }
        }
        return refills;
    }
}
