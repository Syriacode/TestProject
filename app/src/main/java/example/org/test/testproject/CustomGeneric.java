package example.org.test.testproject;

public class CustomGeneric {

    public static class Application1<Item> {
        Item[] array;
        int size;

        public Application1() {
            array = (Item[]) new Object[5];
        }

        public void add(Item item) {
            grow();
            array[size++] = item;
        }

        public void grow() {
            if ((size) >= array.length) {
                Item[] temp = (Item[]) new Object[array.length + array.length ];
                for (int i = 0; i < array.length; i++)
                    temp[i] = array[i];
                array = temp;
            }

        }

        public Item remove(int index) {
            if (index > array.length) {
                System.out.println("undefined index..");
                return null;
            }

            Item item = array[index];
            array[index] = null;
            return item;
        }

        public String toString() {
            String result = "";
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null)
                    result += "" + array[i] + " ";
            }
            return "[" + result + "]";
        }

        public int sizeOfArray() {
            return array.length;
        }

        class Itr<Item> {
            int current;

            public boolean hasNext() {
                return current < (size);
            }

            public Item next() {
                return (Item) array[current++];
            }
        }

        public static void main(String[] args) {
            Application1<Integer> application1 = new Application1<Integer>();
            application1.add(1);
            application1.add(2);
            application1.add(3);
            application1.add(4);
            application1.add(5);
            application1.add(6);
            System.out.println(application1.toString());
            application1.remove(5);
            System.out.println(application1.toString());
            Application1.Itr itr = application1.new Itr();
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
            System.out.println("size of array " + application1.sizeOfArray());
        }
    }
}
