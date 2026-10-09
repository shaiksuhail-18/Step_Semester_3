public class Locker {
    private String combination;
    private final int lockerNumber;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combination = initialCode;
    }

    public void changeCode(String currentCode, String newCode) {
        if (this.combination.equals(currentCode)) {
            this.combination = newCode;
            System.out.println("success");
        } else {
            System.out.println("rejected, code is still \"" + this.combination + "\"");
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
