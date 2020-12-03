class SkipList {
    private final SkipListNode[] head;
    private int n = 0; // list size
    private final int lanes = 3;

    public SkipList() {
        head = new SkipListNode[lanes];
    }

    public void createTestList() {

        SkipListNode Anne = new SkipListNode("Anne", 3);
        n++;

        for (int i=0; i<lanes; i++){ head[i] = Anne; }

        SkipListNode Ben = new SkipListNode("Ben", 1);
        n++;
        SkipListNode Charlie = new SkipListNode("Charlie", 2);
        n++;
        SkipListNode Don = new SkipListNode("Don", 1);
        n++;
        SkipListNode Ernie = new SkipListNode("Ernie", 3);
        n++;

        int l = 0;
        Anne.next[l] = Ben;
        Ben.next[l] = Charlie;
        Charlie.next[l] = Don;
        Don.next[l] = Ernie;

        l = 1;
        Anne.next[l] = Charlie;
        Charlie.next[l] = Ernie;

        l = 2;
        Anne.next[l] = Ernie;

    }

    public void print() {

        for (int i=lanes-1; i>=0; i--){
            SkipListNode node = head[i];
            StringBuilder layer = new StringBuilder();
            while (true){
                layer.append(node.element).append(", ");
                if (node.next[i] == null){
                    layer.setLength(layer.length() - 2);
                    System.out.println(layer + "\n");
                    break;
                }
                else { node = node.next[i]; }
            }
        }
    }

    public boolean inList(String s) {

        for (int i=lanes-1; i>=0; i--) {
            SkipListNode node = head[i];
            while (true) {
                if (node.element.compareTo(s) == 0){
                    return true;
                }

                if (node.next[i] == null){
                    break;
                }

                else if (s.compareTo(node.next[i].element) == 0){
                    return true;
                }

                else if (s.compareTo(node.next[i].element) > 0){
                    node = node.next[i];
                }

                else {
                    break;
                }


            }
        }
        return false;
    }

    public static void main(String[] args) {
        SkipList sl = new SkipList();
        sl.createTestList();
        sl.print();
        System.out.println();

        System.out.println(sl.inList("Anne") + " should be true");
        System.out.println(sl.inList("Ben") + " should be true");
        System.out.println(sl.inList("Charlie") + " should be true");
        System.out.println(sl.inList("Don") + " should be true");
        System.out.println(sl.inList("Ernie") + " should be true");

        System.out.println(sl.inList("Arya") + " should be false");
        System.out.println(sl.inList("Elmo") + " should be false");
        System.out.println(sl.inList("Zorro") + " should be false");
    }
}
