package medium.errorhand;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Optional;

public class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException(message);
    }

    void handleErrorByThrowingAnyCheckedException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String message) throws FileAlreadyExistsException {
        throw new FileAlreadyExistsException(message);
    }

    void handleErrorByThrowingAnyUncheckedException() {
        throw new IndexOutOfBoundsException();
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String message) {
        throw new IndexOutOfBoundsException(message);
    }

    void handleErrorByThrowingCustomCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String message) throws CustomCheckedException {
        throw new CustomCheckedException(message);
    }

    void handleErrorByThrowingCustomUncheckedException() {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String message) {
        throw new CustomUncheckedException(message);
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        try {
            return Optional.of(Integer.parseInt(integer));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
