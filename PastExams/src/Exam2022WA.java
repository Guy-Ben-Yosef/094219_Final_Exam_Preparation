import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exam2022WA {
    // Question 01
    public static void adjacentHanoi(int n, String A, String B, String C) {
        if (n == 0) {
            return;
        }
        adjacentHanoi(n - 1, A, B, C);
        System.out.println("Move disk from " + A + " To " + B);
        adjacentHanoi(n - 1, C, B, A);
        System.out.println("Move disk from " + B + " To " + C);
        adjacentHanoi(n - 1, A, B, C);
    }

    // Question 03
    public static class Set implements Cloneable {
        private int[] values;
        private int index; // Next index for inserting an element
        private int scanningType = 0;

        public Set(int maxSize) {
            values = new int[maxSize];
            index = 0;
        }

        // Section A
        public void addElement(int newElement) {
            if (index < values.length) {
                for (int oldElement : values) {
                    if (oldElement == newElement) {
                        throw new ElementAlreadyExists();
                    }
                }
                values[index] = newElement;
                index++;
            } else {
                throw new SetOverflowException();
            }
        }

        public static class setException extends RuntimeException {
        }

        public static class ElementAlreadyExists extends setException {
        }

        public static class SetOverflowException extends setException {
        }

        // Section B
        @Override
        public Set clone() {
            try {
                Set newSet = (Set) super.clone();
                newSet.values = this.values.clone();
                newSet.index = this.index;
                return newSet;
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        // Section C
        private boolean isSubset(Set otherSet) {
            for (int i = 0; i < index; i++) {
                boolean flag = false;
                for (int j = 0; j < otherSet.index; j++) {
                    if (values[i] == otherSet.values[j]) {
                        flag = true;
                    }
                }
                if (!flag) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Set)) {
                return false;
            }
            Set otherSet = (Set) other;
            return isSubset(otherSet) && otherSet.isSubset(this);
        }

        // Section D
        public void setScanningType(int scanningType) {
            this.scanningType = scanningType;
        }

        public SetIterator iterator() {
            return new SetIterator();
        }

        public class SetIterator implements Iterator<Integer> {
            private int[] array;
            private int index;
            private int direction;

            public SetIterator() {
                this.array = values;
                this.direction = scanningType;
                switch (direction) {
                    case 0:
                        this.index = 0;
                        break;
                    case 1:
                        this.index = array.length - 1;
                        break;
                }
            }

            @Override
            public boolean hasNext() {
                switch (direction) {
                    case 0:
                        return index < array.length;
                    case 1:
                        return index >= 0;
                    default:
                        return false;
                }
            }

            @Override
            public Integer next() {
                int next = array[index];
                switch (direction) {
                    case 0:
                        index++;
                    case 1:
                        index--;
                }
                return next;
            }
        }

    }

    // Question 05
    public static class Person {
        public String name;
        public String phoneNumber;

        public Person() {
            this.name = "";
            this.phoneNumber = "";
        }

        public Person(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
    public static class Seller extends Person{
        public String item;

        public Seller() {
            super();
            this.item = "";
        }

        public Seller(String name, String phoneNumber, String item) {
            super(name, phoneNumber);
            this.item = item;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;

        }
    }
    public static class Bidder extends Person {
        public String name;
        public String phoneNumber;
        private int bid;

        public Bidder() {
            super();
            this.bid = 0;
        }

        public Bidder(String name, String phoneNumber, int bid) {
            super(name, phoneNumber);
            this.bid = bid;
        }

        public int getBid() {
            return bid;
        }

        public void setBid(int bid) {
            this.bid = bid;
        }

    }
    public static abstract class Auction {
        public Seller seller;
        protected List<Bidder> bidders = new ArrayList<>();
        protected Bidder leader;
        int highestBid;
        int secondHighestBid;

        public Auction(Seller seller) {
            this.seller = seller;
        }

        public void addBidder(Bidder bidder) {
            bidders.add(bidder);
            int bid = bidder.getBid();
            if (bid > highestBid) {
                leader = bidder;
                secondHighestBid = highestBid;
                highestBid = bid;
            } else if (bid > secondHighestBid) {
                secondHighestBid = bid;
            }
        }
        public Bidder getWinner() {return leader;}
        public abstract int getWinningBid();
    }
    public static class FirstPriceAuction extends Auction {
        Seller seller;
        List<Bidder> bidders;
        Bidder leader;
        int highestBid;
        int secondHighestBid;

        public FirstPriceAuction(Seller seller) {
            super(seller);
        }

        @Override
        public int getWinningBid() {
            return highestBid;
        }
    }
    public static class SecondPriceAuction extends Auction {
        Seller seller;
        List<Bidder> bidders;
        Bidder leader;
        int highestBid;
        int secondHighestBid;

        public SecondPriceAuction(Seller seller) {
            super(seller);
        }

        @Override
        public int getWinningBid() {
            return secondHighestBid;
        }

    }

    // Question 06
    static class A{
        private int a;
        public A(int a){
            this.a = a;
        }
        public int hashCode(){
            return a;
        }
    }
}
