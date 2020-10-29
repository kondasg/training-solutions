package trainerapp;

public class TrainerMain {
    public static void main(String[] args) {
        Trainer trainer = new Trainer();
        // trainer.name = "Géza"; private miatt
        trainer.setName("Géza");
        //trainer.yearOfBirth = 1980;
        trainer.setYearOfBirth(1980);
        //System.out.println(trainer.name);
        System.out.println(trainer.getName());
        //System.out.println(trainer.yearOfBirth);
        System.out.println(trainer.getYearOfBirth());

        Trainer anotherTrainer = new Trainer();
        //anotherTrainer.name = "Gizi";
        anotherTrainer.setName("Gizi");
        //System.out.println(anotherTrainer.name);
        System.out.println(anotherTrainer.getName());

        System.out.println(anotherTrainer.getName());
        System.out.println(trainer.getNameAndYearOfBirth());

        anotherTrainer.changeName("Gizella");
        System.out.println(anotherTrainer.getName());

        anotherTrainer.setName("Gizi megint");
        System.out.println(anotherTrainer.getName());
    }
}
