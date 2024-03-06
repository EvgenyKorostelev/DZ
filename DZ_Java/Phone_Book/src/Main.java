public class Main {
    public static void main(String[] args){

        PhoneBook pb1 = new PhoneBook();

        pb1.add("MyAmi", 77777);
        pb1.add("MyAmi", 99999);

        pb1.add("Mr.Anderson", 555555);

        pb1.add("Ms.Smith", 6666666);
        pb1.add("Ms.Smith", 1111111);
        pb1.add("Ms.Smith", 2222222);
        pb1.add("Ms.Smith", 45454545);

        pb1.add("Gr", 4444444);
        pb1.add("Gr", 1000000);
        pb1.add("Gr", 3333333);


        System.out.println();
        System.out.println(pb1.find("MyAmi"));
        System.out.println();
        System.out.println(PhoneBook.getPhoneBook(pb1));
        System.out.println();
        PhoneBook.outSortPBook(pb1);

 }
}