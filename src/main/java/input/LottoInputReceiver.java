package input;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static lottoConfig.LottoConfig.*;
import static messageProvider.LottoMessageProvider.*;

public class LottoInputReceiver {

    public Set<Integer> getSixNumbers(Scanner scanner) {
        Set<Integer> givenSixNumbers = getSixNumbersFromUser(scanner);
        scanner.close();
        return givenSixNumbers;
    }

    private Set<Integer> getSixNumbersFromUser(Scanner sc) {
        final Set<Integer> givenNumbers = new HashSet<>();
        System.out.println(String.format(STARTING_INFO,LOWER_BOND, UPPER_BOND));
        while (areThereLessThanSixNumbers(givenNumbers)) {
            System.out.println(GIVE_NUMBER);
            while (!sc.hasNextInt()) {
                System.out.println(String.format(ERROR_INFO));
                if (!sc.hasNext()) {
                    return Collections.emptySet();
                }
            }
            final int userInput = sc.nextInt();
            addingNumberToSet(givenNumbers, userInput);
        }
        return givenNumbers;
    }

    private void addingNumberToSet(Set<Integer> givenNumbers, int userInput) {
        if (isInCorrectRange(userInput)) {
            givenNumbers.add(userInput);
        } else System.out.println(String.format(NUMBER_OUT_OF_RANGE_INFO,userInput,LOWER_BOND,UPPER_BOND));
    }

    private boolean isInCorrectRange(int userInput) {
        return (userInput <= UPPER_BOND) && (userInput >= LOWER_BOND);
    }

    private boolean areThereLessThanSixNumbers(Set<Integer> givenNumbers) {
        return givenNumbers.size() < NUMBERS_TO_GENERATE;
    }
}
