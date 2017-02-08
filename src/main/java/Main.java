import controller.Controller;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        System.out.println(controller.executeTask("lol books life Mark"));
   //     System.out.println(controller.executeTask("ADD_NEWS BOOKS life Mark1"));
//        System.out.println(controller.executeTask("ADD_NEWS BOOKS life Mark2"));
        System.out.println(controller.executeTask("FIND_NEWS BOOKS detective Akunin"));
        System.out.println(controller.executeTask("FIND_NEWS books lif Mark2"));
        System.out.println(controller.executeTask("FIND_NEWS"));
        System.out.println(controller.executeTask("ADD_NEWS BOOKS Mark1"));
        System.out.println(controller.executeTask("1"));
        System.out.println(controller.executeTask(""));

    }
}
