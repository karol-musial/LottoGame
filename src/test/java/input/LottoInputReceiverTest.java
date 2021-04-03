package input;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoInputReceiverTest {

        LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();

        @Test
        void shouldKeepGoingWhenDetectOneNumberOutOfRange(){
            // given
            Set<Integer> expectedNumbers = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
            String inputNumbers = "1 2 3 4 5 101 6";
            Scanner userNumbers = mockScannerIn(inputNumbers);
            // when
            final Set<Integer> userInputNumbers = lottoInputReceiver.getSixNumbers(userNumbers);
            // then
            assertThat(expectedNumbers).isEqualTo(userInputNumbers);
        }
        
    private Scanner mockScannerIn(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }
}