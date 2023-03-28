import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'serviceLane' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY cases
     */

    public static List<Integer> serviceLane(int n, List<List<Integer>> cases, List<Integer> width)     {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> testCase : cases) 
        {
            int entryPoint = testCase.get(0);
            int exitPoint = testCase.get(1);
            int minWidth = Integer.MAX_VALUE;
            for (int i = entryPoint; i <= exitPoint; i++) 
            {
                int segmentWidth = width.get(i);
                if (segmentWidth < minWidth) 
                {
                    minWidth = segmentWidth;
                }
            }
            result.add(minWidth);
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();

        List<Integer> width = IntStream.range(0, n)
            .mapToObj(i -> scanner.nextInt())
            .collect(toList());

        List<List<Integer>> cases = IntStream.range(0, t)
            .mapToObj(i -> Arrays.asList(scanner.nextInt(), scanner.nextInt()))
            .collect(toList());

        List<Integer> result = Result.serviceLane(n, cases, width);

        System.out.println(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
        );

        scanner.close();
    }
}
