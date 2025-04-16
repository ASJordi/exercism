package medium.errorhand;

class CustomCheckedException extends Exception {

    CustomCheckedException() {
        super();
    }

    CustomCheckedException(String message) {
        super(message);
    }

}
