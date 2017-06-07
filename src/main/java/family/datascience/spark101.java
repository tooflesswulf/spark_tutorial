package family.datascience;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.Function;

import java.util.ArrayList;
import java.util.List;

// import java.util.function.Function;


/**
 * Created by albertxu on 6/1/17.
 */
public class spark101 {

    public static void main(String[] args) {
        System.out.println("Started");
        SparkConf conf = new SparkConf()
                .setAppName("Simple Application")
                .setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        int n_samp = 50000;
        List<Integer> l = new ArrayList<>(n_samp);
        for (int i = 0; i < n_samp; i++) {
            l.add(i);
        }

        long count = sc.parallelize(l).filter(i -> {
            double x = Math.random();
            double y = Math.random();
            return x*x + y*y < 1;
        }).count();
        System.out.println("Pi is roughly " + 4.0 * count / n_samp);
        System.out.println("The error is " + (1.0 - 4.0 * count / n_samp / Math.PI));

        sc.stop();
    }
}
