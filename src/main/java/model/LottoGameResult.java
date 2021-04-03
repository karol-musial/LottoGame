package model;

import input.LottoInputReceiver;
import logic.HitNumberCalculator;
import logic.RandomNumbersGenerator;

import java.util.Scanner;
import java.util.Set;

import static messageProvider.LottoMessageProvider.*;

public class LottoGameResult {
    final RandomNumbersGenerator numbersGenerator = new RandomNumbersGenerator();
    final LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();
    final Scanner scanner = new Scanner(System.in);

    final Set<Integer> randomNumbers = numbersGenerator.getRandomNumbers();
    final Set<Integer> inputNumbers = lottoInputReceiver.getSixNumbers(scanner);

    public void lottoGameInfo() {

        HitNumberCalculator hitNumberCalculator = new HitNumberCalculator();
        Set<Integer> finalHitNumbers = hitNumberCalculator.getFinalHitNumbers(randomNumbers, inputNumbers);
        System.out.println(String.format(FINISH_INFO, finalHitNumbers.size()));
        System.out.println(String.format(WINNING_NUMBERS +  randomNumbers));
        System.out.println(String.format(YOUR_WINNING_NUMBERS) + finalHitNumbers);
    }


}
