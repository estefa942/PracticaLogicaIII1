package modelo;

public class CH_SList {

    private SNode first;
    private SNode last;
    private SNode head;

    //Constructor 
    public CH_SList() {
        head = new SNode((int) 0);
        head.setLink(head);
        first = head.getLink();
        last = first;
    }

    public SNode firstNode() {
        return head.getLink();
    }

    public SNode lastNode() {
        return last;
    }

    public SNode headNode() {
        return head;
    }

    public SNode previousNode(SNode x) {

        SNode p, pp;
        p = firstNode();
        pp = head;

        while (!isTheEnd(p)) {
            pp = p;
            p = p.getLink();

        }
        return (pp);
    }

    public boolean isTheEnd(SNode x) {

        return (x == head);
    }

    public boolean isVoid() {

        if (head.getLink() == head) {
            return (true);
        } else {
            return false;
        }
    }

    public void printData() {

        SNode p = firstNode();
        while (p != head) {

            System.out.print("|" + p.getData() + "|");
            p = p.getLink();
        }
    }

    public SNode whereInsert(char d) {
        SNode p, pp;
        p = firstNode();
        pp = head;
        while (!isTheEnd(p) && (char) p.getData() < d) {
            pp = p;
            p = p.getLink();
        }
        return pp;
    }

    public SNode nodeAt(int d) {
        SNode p, pp;
        p = firstNode();
        pp = previousNode(p);
        int j = 1;
        while (j <= d) {
            pp = p;
            p = p.getLink();
            j++;
        }
        return pp;

    }

    public void insert(char d, SNode y) {
        SNode x = new SNode(d);
        head.setData((int) head.getData() + 1);
        connect(x, y);

    }

    public void connect(SNode x, SNode y) {
        if (y != head) {
            x.setLink(y.getLink());
            y.setLink(x);

            if (y == last) {
                last = x;
            }
        } else {
            x.setLink(firstNode());
            if (first == head) {
                last = x;
            }
            first = x;
            head.setLink(x);
        }
    }

    public SNode searchData(char d, SNode y) {
        SNode x = firstNode();
        y = previousNode(x);
        while (!isTheEnd(x) && (char) x.getData() != d) {
            y = x;
            x = x.getLink();
        }

        return x;
    }

    public void delete(SNode x, SNode y) {
        if (x == head) {
            System.out.println("El dato no existe");
            return;
        }
        disconnect(x, y);
    }

    public void disconnect(SNode x, SNode y) {

        if (x != firstNode()) {
            y.setLink(x.getLink());
            if (x == last) {
                last = y;
            }
        } else {
            first = first.getLink();
            if (first == head) {
                last = head;
            }
            head.setLink(first);
        }
    }

    public void reverse() {
        SNode p, q, r;
        p = firstNode();
        last = p;
        q = previousNode(p);
        while (!isTheEnd(p)) {
            r = q;
            q = p;
            p = p.getLink();
            q.setLink(r);
        }
        first = q;
        head.setLink(first);
        last.setLink(head);
    }

    public CH_SList alphabet() {
        SNode p;
        CH_SList h = new CH_SList();
        p = firstNode();
        while (p != head) {
            h.insert((char) p.getData(), h.whereInsert((char) p.getData()));
            p = p.getLink();
        }
        return h;

    }

    public boolean equals(CH_SList h) {
        if (head.getData() != h.headNode().getData()) {
            return false;
        }
        SNode p, q;
        p = first;
        q = h.firstNode();
        while (!isTheEnd(p)) {
            if (p.getData() != q.getData()) {
                System.out.println("No son anagramas");
                return false;
            }
            p = p.getLink();
            q = q.getLink();
        }
        System.out.println("Son anagramas");
        return true;
    }
    
    public CH_SList copiar() {
        Object x;
        SNode p, q;
        CH_SList h = new CH_SList();
        p = firstNode();
        while (p != head) {
            x = p.getData();
            q = new SNode(x);
            h.connect(q, h.lastNode());
            p = p.getLink();
        }
        return h;
    }

}
