package easy.secrethandshake;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HandshakeCalculatorTest {

    private final HandshakeCalculator handshakeCalculator = new HandshakeCalculator();

    @Test
    public void testThatInput1YieldsAWink() {
        assertThat(handshakeCalculator.calculateHandshake(1)).containsExactly(Signal.WINK);
    }

    @Test
    public void testThatInput2YieldsADoubleBlink() {
        assertThat(handshakeCalculator.calculateHandshake(2)).containsExactly(Signal.DOUBLE_BLINK);
    }

    @Test
    public void testThatInput4YieldsACloseYourEyes() {
        assertThat(handshakeCalculator.calculateHandshake(4)).containsExactly(Signal.CLOSE_YOUR_EYES);
    }

    @Test
    public void testThatInput8YieldsAJump() {
        assertThat(handshakeCalculator.calculateHandshake(8)).containsExactly(Signal.JUMP);
    }

    @Test
    public void testAnInputThatYieldsTwoActions() {
        assertThat(handshakeCalculator.calculateHandshake(3))
                .containsExactly(Signal.WINK, Signal.DOUBLE_BLINK);
    }

    @Test
    public void testAnInputThatYieldsTwoReversedActions() {
        assertThat(handshakeCalculator.calculateHandshake(19))
                .containsExactly(Signal.DOUBLE_BLINK, Signal.WINK);
    }

    @Test
    public void testReversingASingleActionYieldsTheSameAction() {
        assertThat(handshakeCalculator.calculateHandshake(24)).containsExactly(Signal.JUMP);
    }

    @Test
    public void testReversingNoActionsYieldsNoActions() {
        assertThat(handshakeCalculator.calculateHandshake(16)).isEmpty();
    }

    @Test
    public void testInputThatYieldsAllActions() {
        assertThat(handshakeCalculator.calculateHandshake(15))
                .containsExactly(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP);
    }

    @Test
    public void testInputThatYieldsAllActionsReversed() {
        assertThat(handshakeCalculator.calculateHandshake(31))
                .containsExactly(Signal.JUMP, Signal.CLOSE_YOUR_EYES, Signal.DOUBLE_BLINK, Signal.WINK);
    }

    @Test
    public void testThatInput0YieldsNoActions() {
        assertThat(handshakeCalculator.calculateHandshake(0)).isEmpty();
    }

    @Test
    public void testThatHandlesMoreThanFiveBinaryPlacesWithReversal() {
        assertThat(handshakeCalculator.calculateHandshake(51))
                .containsExactly(Signal.DOUBLE_BLINK, Signal.WINK);
    }

    @Test
    public void testThatHandlesMoreThanFiveBinaryPlacesWithoutReversal() {
        assertThat(handshakeCalculator.calculateHandshake(35))
                .containsExactly(Signal.WINK, Signal.DOUBLE_BLINK);
    }

    @Test
    public void testInputThatYieldsAllActionsFromMoreThanFiveBinaryPlaces() {
        assertThat(handshakeCalculator.calculateHandshake(111))
                .containsExactly(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP);
    }

}
