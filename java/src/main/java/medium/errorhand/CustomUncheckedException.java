package medium.errorhand;

class CustomUncheckedException extends RuntimeException {

    CustomUncheckedException() {
        super();
    }

    CustomUncheckedException(String message) {
        super(message);
    }

}
