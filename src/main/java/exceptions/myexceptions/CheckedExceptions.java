package exceptions.myexceptions;

public class CheckedExceptions extends Exception {
    public CheckedExceptions(String message) {
        super(message);
    }

    static public void theMethodThrowsCheckedException() throws CheckedExceptions {
        throw new CheckedExceptions("This is a checked exception");
    }

    static class UncheckedExceptions extends RuntimeException {
        public UncheckedExceptions(String message) {
            super(message);
        }

        static public void theMethodThrowsUncheckedException() throws UncheckedExceptions {
            throw new UncheckedExceptions("This is an unchecked exception");
        }

        public void useMethod() {
            theMethodThrowsUncheckedException();
        }
    }

    //    here we are catching the exception
    static public void useMethod1() {
        try {
            theMethodThrowsCheckedException();
        } catch (CheckedExceptions checkedExceptions) {
            checkedExceptions.printStackTrace();
        }
    }

    //    here we are throwing the exception
    static void useMethod2() throws CheckedExceptions {
        theMethodThrowsCheckedException();
    }

    public static void main(String[] args) {
        useMethod1();
    }
}
