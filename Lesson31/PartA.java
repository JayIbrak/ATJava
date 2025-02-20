package Lesson31;

public class PartA {
    public static void main(String[] args) {
        BaseballCard joey = new BaseballCard("Joey Wagner", 1980);
        BaseballCard juan = new BaseballCard("Juan Sandoval", 1995);
        BaseballCard juan2 = new BaseballCard("Juan Sandoval", 1995);

        System.out.println(joey);
        System.out.println(juan.equals(juan2));// should be tru
        System.out.println(joey.equals(juan2));// should be false
        // bada bing bada boom
    }

    static class BaseballCard {
        String name; // the name of the player on the card.
        int year; // the year the card was issued.

        public BaseballCard(String name, int year) {
            this.name = name;
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        public String toString() {
            return "Baseball Card: " + name + ", Year: " + year + ".";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            BaseballCard card = (BaseballCard) obj;
            return year == card.year && name.equals(card.name);
        }
    }
}
