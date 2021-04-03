package logic;

import input.LottoInputReceiver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HitNumberCalculator {

    public Set<Integer> getFinalHitNumbers(Set<Integer> randomNumbers, Set<Integer> inputNumbers) {
        final Set<Integer> finalHitNumbers = new HashSet<>(inputNumbers);
        finalHitNumbers.retainAll(randomNumbers);
        return finalHitNumbers;
    }
}
