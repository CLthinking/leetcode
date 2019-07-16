package com.uestc.jdk8;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

public class StreamTest6 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        stream = Stream.empty();
        stream.findFirst().ifPresent(System.out::println);

        System.out.println("---------------------");

        Stream.iterate(1, item -> item + 2).limit(6).forEach(System.out::println);

        System.out.println("---------------------");

        Stream.iterate(1, item -> item + 2).limit(6).filter(i -> i > 2).mapToInt(i -> i * 2)
                .skip(2).limit(2).reduce(Integer::sum).ifPresent(System.out::println);

        // 不使用流,针对上面的问题的求解，可以看出使用流的便捷性
        int[] nums = {1,3,5,7,9,11};
        int res = 0;
        int skip = 2;
        int limit = 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 2)
                ;
            else if (skip != 0) {
                skip--;
            }else if (limit != 0) {
                res += 2 * nums[i];
                limit--;
            }else
                break;
        }
        System.out.println(res);

        System.out.println("----------------");
        IntSummaryStatistics summaryStatistics = Stream.iterate(1, item -> item + 2).limit(6).filter(i -> i > 2).mapToInt(i -> i * 2)
                .skip(2).limit(2).summaryStatistics();
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getAverage());

        Stream<Integer> stream1 = Stream.iterate(1, item -> item + 2).limit(6);
//        System.out.println(stream1);
//        System.out.println(stream1.filter(i -> i > 2));
//        System.out.println(stream1.distinct());
    }
}
