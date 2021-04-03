package logic;

import java.security.SecureRandom;
import java.util.Set;
import java.util.stream.Collectors;

import static lottoConfig.LottoConfig.*;

public class RandomNumbersGenerator {

        public Set<Integer> getRandomNumbers(){
            SecureRandom random = new SecureRandom();
                return random.ints(NUMBERS_TO_GENERATE, LOWER_BOND, UPPER_BOND)
                        .boxed()
                        .collect(Collectors.toSet());
        }
}
