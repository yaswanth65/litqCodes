import java.util.*;
class CustomStack {
    private StringBuilder text; 
    private Stack<Command> history; 
    public CustomStack() {
        text = new StringBuilder(); 
        history = new Stack<>(); 
    }
    public void insert(String value) {
        text.append(value); 
        history.push(new Command("insert", value)); 
    }
    public void delete(int value) {
        String removedText = text.substring(text.length() - value); 
        text.delete(text.length() - value, text.length()); 
        history.push(new Command("delete", removedText)); 
    }
    public char get(int index) {
        return text.charAt(index - 1); 
    }
    public void undo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            if (lastCommand.type.equals("insert")) {
                text.delete(text.length() - lastCommand.value.length(), text.length());
            } else if (lastCommand.type.equals("delete")) {
                text.append(lastCommand.value);
            }
        }
    }
    private static class Command {
        String type;
        String value;

        Command(String type, String value) {
            this.type = type;
            this.value = value;
        }
    }
    public void processCommands(String[] commands) {
        for (String command : commands) {
            String[] parts = command.split(" ");
            int cmd = Integer.parseInt(parts[0]);
            switch (cmd) {
                case 1:
                    insert(parts[1]);
                    break;
                case 2:
                    delete(Integer.parseInt(parts[1]));
                    break;
                case 3:
                    System.out.println(get(Integer.parseInt(parts[1])));
                    break;
                case 4:
                    undo();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        CustomStack editor = new CustomStack();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); 
        String[] commands = input.split(",");
        editor.processCommands(commands);
        sc.close();
    }
}
