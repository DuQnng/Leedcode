
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6);
        List<Integer> evenNumers=numbers.stream()
                                        .filter(n->n%2==0)
                                        .collect(Collectors.toList());
        System.out.println(evenNumers);
    }
}
