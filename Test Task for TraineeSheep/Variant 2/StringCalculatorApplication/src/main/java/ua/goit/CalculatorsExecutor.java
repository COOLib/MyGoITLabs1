package ua.goit;

public class CalculatorsExecutor {

    public static void main(String[] args) {

        HibernateUtil.getSessionFactory();
        RemakingText text = new RemakingText();
        text.go();
    }
}
