package easy.secrethandshake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> list = new ArrayList<>();
        var binary = new StringBuilder(Integer.toBinaryString(number)).reverse();

        for (int i = 0; i < Math.max(5, binary.length()); i++) {
            if (i < binary.length()) {
                var c = binary.charAt(i);
                if (i == 0 && c == '1') list.add(Signal.WINK);
                else if (i == 1 && c == '1') list.add(Signal.DOUBLE_BLINK);
                else if (i == 2 && c == '1') list.add(Signal.CLOSE_YOUR_EYES);
                else if (i == 3 && c == '1') list.add(Signal.JUMP);
                else if (i == 4 && c == '1') Collections.reverse(list);
            }
        }

        return list;
    }

}
