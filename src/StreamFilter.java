import java.util.stream.IntStream;

public class StreamFilter {

    public static void main(String[] args) {
        int[] number = {-5,-4,-3,-2,-1,0,1,2,3,4,5};

        long count = IntStream.of(number).filter(w -> w>0).count();
        System.out.println(count);



    }

}
