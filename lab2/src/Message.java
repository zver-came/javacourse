public interface Message {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_WHITE = "\u001B[37m";
    default void Border(){
        System.out.println(ANSI_PURPLE+"-".repeat(150)+ANSI_RESET);
    }
    default void Head(String message){
        System.out.println(ANSI_PURPLE+"-".repeat(150)+ANSI_RESET);
        System.out.println("\t\t\t"+ANSI_CYAN+message+"\n"+ANSI_WHITE+"-".repeat(150)+ANSI_RESET);
    }
    default void Info(String message){
        System.out.printf(ANSI_BLUE + "%s\n" + ANSI_RESET, message);
    }
    default void ErrorInfo(String error, String message){
        System.out.printf(ANSI_RED + "%s\n\t%s\n" + ANSI_RESET, message, error);
        System.out.println(ANSI_PURPLE+"-".repeat(150)+ANSI_RESET);
    }
    default void SuccessInfo(String message){
        System.out.printf(ANSI_GREEN + "%s\n" + ANSI_RESET, message);
        System.out.println(ANSI_PURPLE+"-".repeat(150)+ANSI_RESET);
    }
    default void FailInfo(String message){
        System.out.printf(ANSI_YELLOW + "%s\n" + ANSI_RESET, message);
        System.out.println(ANSI_PURPLE+"-".repeat(150)+ANSI_RESET);
    }
}
