package components.manager;

public class Main {

    public static void main(String[] args) {
        MavenConfigManager.getConfigManager().getImplicityWait();
        String environment = MavenConfigManager.getConfigManager().getEnvironment();
        System.out.println(environment);
    }
}
