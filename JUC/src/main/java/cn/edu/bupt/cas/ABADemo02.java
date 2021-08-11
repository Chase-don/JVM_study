package cn.edu.bupt.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo02 {

    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(2020, 1);
        // TODO: ABA
    }
}
