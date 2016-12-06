package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        long limit = 1000000000000L;
        int count = 0;

        System.out.println("Computing...");
        ArrayList<Long> primes = getPrimes2((int) limit);
        System.out.println("Total primes found is: " + primes.size());
        for (int i = 0; i < primes.size(); i++) {
            for (int j = 0; j < primes.size(); j++) {
                if (i == j) {
                    continue;
                }

                if (getProduct1(primes.get(i), primes.get(j)) < limit) {
                    // System.out.println(getProduct1(primes.get(i), primes.get(j)));
                    count++;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < primes.size(); i++) {
            if (getProduct3(primes.get(i)) < limit) {
                // System.out.println(getProduct3(primes.get(i)));
                count++;
            } else {
                break;
            }
        }


        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                for (int k = j + 1; k < primes.size(); k++) {
                    if (getProduct2(primes.get(i), primes.get(j), primes.get(k)) < limit) {
                        // System.out.println(getProduct2(primes.get(i), primes.get(j), primes.get(k)));
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println("Total Count is: " + count);
        System.out.println("Computing Finished...");
    }

    static long getProduct3(long a) {
        return a * a * a * a * a * a * a;
    }

    static long getProduct2(long a, long b, long c) {
        return a * b * c;
    }

    static long getProduct1(long a, long b) {
        return a * a * a * b;
    }

    // fast way to get primes under integer n
    static ArrayList<Long> getPrimes2(final int target) {

        final boolean[] nonPrime = new boolean[target + 1];

        for (int i = 2; i <= Math.sqrt(target); ++i) {
            if (!nonPrime[i]) {
                for (int j = i + i; j <= target; j = j + i) {
                    nonPrime[j] = true;
                }
            }
        }

        ArrayList<Long> primes = new ArrayList<>();

        for (int i = 2; i <= target; ++i) {
            if (!nonPrime[i]) primes.add((long) i);
        }

        return primes;
    }

    // slow way to get primes under n
    static ArrayList<Long> getPrimes1(long n) {
        ArrayList<Long> primes = new ArrayList<>();
        for (Long i = 2L; i < n; i++) {
            // checking if i is prime
            boolean prime = true;
            for (Long j = 2L; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                primes.add(i);
            }
        }

        return primes;
    }
}
