package agh.ics.oop;


public class World {
    // Odpowiedz na pytanie: jak zaimplementować mechanizm, który wyklucza pojawienie się dwóch zwierząt w tym
    // samym miejscu (zakładamy że jest n zwierząt , gdzie n <= 25 z powodu wymiarów mapy)
    // Odpowiedź : najpierw trzeba stworzyć tablice 2d o wymiarach 5X5 wypełnioną wartościami false i jeżeli
    // jakieś zwierze pojawi się na jakimś polu to zmienić wartość na tym polu na true, jeżeli zwierze przemieszcza
    // się z pola (x1,y1) na (x2,y2) to zmienić wartość na (x1,y1) na false a (x2,y2) na true, jeżeli jednak
    // na polu (x2,y2) jest wartość true to wyświetlić komunikat że to pole jest zajęte i pozostawić zwierze na
    // polu (x1,y1)
    public static void main(String[] args) {
        System.out.println("system wystartował");
        Animal lion = new Animal();
        System.out.println(lion);
        MoveDirection[] array;
        array = OptionsParser.parse(args);
        for (int i = 0; i < array.length; i+=1){
            lion.move(array[i]);
        }
        System.out.println(lion);
        lion = new Animal();
        lion.move(MoveDirection.RIGHT);
        lion.move(MoveDirection.FORWARD);
        lion.move(MoveDirection.FORWARD);
        lion.move(MoveDirection.FORWARD);
        System.out.println(lion);
        System.out.println("system zakończył działanie");
    }


}

