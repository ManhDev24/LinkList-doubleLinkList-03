
public class DLL_Flower_Tester {

    public static void main(String[] args) {
        DLL_FlowerList list = new DLL_FlowerList();
        //adds
        list.addFirst("Hung. Rose", "Hungary", 20);
        list.addFirst("Dalat Rose", "VietNam", 2);
        list.addLast("White tulip", "Hungary", 10);
        list.addLast("Orchid", "French", 30);
        list.addLast("Gladiolus", "VietNam", 1);

        // traversals
        System.out.println("\nFlower in the list: ");
        list.printAll();
        System.out.println("\nFlower in the list , Reverse order: ");
        list.printAll_reverse();
        System.out.println("\nFlower from Hungary: ");
        list.printAll_org("Hungary");
        System.out.println();

        //search
        String name = "Tidgon";
        DLL_Node reuslt = list.search(name);
        if (reuslt == null) {
            System.out.println("Search " + name + ": Not found!");
        } else {
            System.out.println("Search " + reuslt.flower);
        }
        name = "Orchid";
        reuslt = list.search(name);
        if (reuslt == null) {
            System.out.println("Search " + name + ": Not found!");
        } else {
            System.out.println("Search " + reuslt.flower);
        }
        System.out.println();

        //remove
        System.out.println("\nRemove first operation");
        list.removeFirst();
        System.out.println("\nFlower in the list:");
        list.printAll();
        System.out.println("\nRemove last operation");
        list.removeLast();
        System.out.println("\nFlower in the list: ");
        list.printAll();
        System.out.println("\nSearch and remove");
        name = "Tigon";
        Flower f = list.remove(name);
        if (f == null) {
            System.out.println("Remove failed " + name);
        } else {
            System.out.println("Remove succesfully: " + f);
        }
        name = "White tulip";
        f = list.remove(name);
        if (f == null) {
            System.out.println("Remove failed " + name);
        } else {
            System.out.println("Remove successfully: " + f);
        }

        // printall
        System.out.println("\nFlower in the list:");
        list.printAll();
    }
}
