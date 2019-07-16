package com.uestc.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author CLthinking
 * @date 2019/7/10 下午 07:42
 */
public class No4 {

        static class Pair {
            int x;
            int y;
            int expect;

            public Pair(int x, int y, int expect) {
                this.x = x;
                this.y = y;
                this.expect = expect;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair pair = (Pair) o;
                return x == pair.x &&
                        y == pair.y &&
                        expect == pair.expect;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

        public static void main(String[] args) throws Exception{

            Scanner cin = new Scanner(System.in);
            int n = cin.nextInt();
            while (n-- > 0) {
                int m = cin.nextInt();
                int expect = 0;
                int res = 0;
                Map<Pair, Integer> map = new HashMap<>();
                while (m-- > 0) {
                    int feature = cin.nextInt();
                    if (feature != 0) {
                        for (int i = 0; i < feature; i += 1) {
                            Pair pair = new Pair(cin.nextInt(),
                                    cin.nextInt(), expect);
                            Pair prePair =  new Pair(pair.x, pair.y, expect - 1);
                            map.put(pair, map.getOrDefault(prePair, 0) + 1);
                            map.remove(prePair);
                            res = Math.max(res, map.get(pair));
                        }
                    }
                    expect++;
                }
                System.out.println(res);
            }
        }
}
