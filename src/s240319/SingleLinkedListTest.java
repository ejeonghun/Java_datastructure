package s240319;

class Node { // 노드 클래스 정의
    String data; // 데이터 필드: 노드가 저장하는 데이터
    Node next; // 링크 필드: 다음 노드를 가리키는 참조

    public Node() { // 기본 생성자: 데이터와 링크를 null로 초기화
        this.data = null;
        this.next = null;
    }
    public Node(String data) { // 생성자: 데이터를 받아서 초기화하고 링크는 null로 초기화
        this.data = data;
        this.next = null;
    }
    public Node(String data, Node next) { // 생성자: 데이터와 링크를 받아서 초기화
        this.data = data;
        this.next = next;
    }
}

class LinkedList { // 단순 연결리스트 클래스 정의
    private Node head; // 헤드 포인터(참조변수): 리스트의 첫 번째 노드를 가리킴

    public LinkedList() { // 기본 생성자: 헤드를 null로 초기화
        this.head = null;
    }

    // 단순 연결리스트 처음에 데이터 삽입
    void insertFirstNode(String str) {
        Node node = new Node(str); // 새 노드 생성
        if (head == null) { // 리스트가 비어있으면 헤드에 새 노드를 연결
            head = node;
        } else { // 리스트가 비어있지 않으면 새 노드를 헤드 앞에 연결하고 헤드를 새 노드로 설정
            Node current = head;
            node.next = current;
            head = node;
        }
    }

    // 단순 연결리스트에 마지막에 데이터 삽입
    void insertLastNode(String str) {
        Node node = new Node(str); // 새 노드 생성
        if (head == null) { // 리스트가 비어있으면 헤드에 새 노드를 연결
            head = node;
        } else { // 리스트가 비어있지 않으면 마지막 노드를 찾아서 새 노드를 연결
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    // 단순 연결리스트 중간에 데이터 삽입
    void insertMiddleNode(Node pre, String str) {
        Node node = new Node(str); // 새 노드 생성
        node.next = pre.next; // 새 노드의 링크를 pre 노드의 다음 노드로 설정
        pre.next = node; // pre 노드의 링크를 새 노드로 설정
    }




    // 단순 연결리스트 마지막 데이터 삭제
    void deleteLastNode() {
        if (head == null) { // 리스트가 비어있으면 삭제할 노드가 없다는 메시지 출력
            System.out.println("지울 노드가 존재하지 않습니다.");
        } else { // 리스트가 비어있지 않으면 마지막 노드를 찾아서 삭제
            Node prev = head;
            Node current = head.next;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            prev.next = null;
        }
    }

    // 단순 연결리스트 중간 데이터 삭제
    void deleteMiddleNode(String str) {
        Node node = new Node(str); // 삭제할 노드 생성
        if (head == null) { // 리스트가 비어있으면 삭제할 노드가 없다는 메시지 출력
            System.out.println("지울 노드가 존재하지 않습니다.");
        } else { // 리스트가 비어있지 않으면 삭제할 노드를 찾아서 삭제
            Node prev = head;
            Node current = head.next;
            while (current.data != node.data) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
    }

    // 단순 연결리스트 처음 데이터 삭제
    void deleteFirstNode() {
        if (head == null) { // 리스트가 비어있으면 삭제할 노드가 없다는 메시지 출력
            System.out.println("지울 노드가 존재하지 않습니다.");
        } else { // 리스트가 비어있지 않으면 헤드 노드를 삭제하고 헤드를 다음 노드로 설정
            head = head.next;
        }
    }

    // 단순 연결리스트에서 데이터 검색
    Node searchNode(String str) {
        Node node = new Node(str); // 검색할 노드 생성
        if (head == null) { // 리스트가 비어있으면 검색할 노드가 없다는 메시지 출력
            System.out.println("노드가 비어있습니다.");
            return null;
        } else { // 리스트가 비어있지 않으면 검색할 노드를 찾아서 반환
            Node current = head;
            while (current.data != node.data) {
                current = current.next;
            }
            return current;
        }
    }

    // 단순 연결리스트 전체 데이터 출력
    void printList() {
        if (head == null) { // 리스트가 비어있으면 출력할 리스트가 없다는 메시지 출력
            System.out.println("출력할 리스트가 존재하지 않습니다.");
        } else { // 리스트가 비어있지 않으면 모든 노드의 데이터를 출력
            Node current = head;
            System.out.print("[");
            while (current.next != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.print(current.data);
            System.out.print("]");
            System.out.println();
        }
    }

    // 단순 연결리스트 노드 인덱스 검색
    int IndexOf(String str) {
        Node node = new Node(str); // 검색할 노드 생성
        int Index = 1; // 인덱스 초기화
        if (head == null) { // 리스트가 비어있으면 검색할 노드가 없다는 메시지 출력
            System.out.println("노드가 비어있습니다.");
            return -1;
        } else { // 리스트가 비어있지 않으면 검색할 노드를 찾아서 인덱스를 반환
            Node current = head;
            while (current.data != node.data) {
                if (current.next == null) { return -1; } // 만약 다음 노드가 없다면 못찾은것이기 때문에 -1
                current = current.next;
                Index++;
            }
            return Index;
        }
    }
}


public class SingleLinkedListTest { // 단순 연결리스트 테스트 코드
    public static void main(String[] args) {
        LinkedList list = new LinkedList(); // 연결리스트 객체 생성
        System.out.println("(1) 공백 리스트에 노드 5개 삽입하기");
        list.insertLastNode("월");
        list.insertLastNode("화");
        list.insertLastNode("수");
        list.insertLastNode("목");
        list.insertLastNode("토");
        list.printList();
        System.out.println("(2) \"목\"노드 뒤에 \"금\" 노드 삽입하기");
        Node pre = list.searchNode("목");
        if (pre == null) {
            System.out.println("검색 실패 >> 찾는 데이터가 없습니다.");
        } else {
            list.insertMiddleNode(pre, "금");
        }
        list.printList();System.out.println("(3) 리스트의 첫번째에 노드 추가하기");
        list.insertFirstNode("일");
        list.printList();
        System.out.println("(4) 리스트의 마지막 노드 삭제하기");
        list.deleteLastNode();
        list.printList();
        System.out.println("(5) 리스트의 중간 노드 \"수\" 삭제하기");
        list.deleteMiddleNode("수");
        list.printList();
        System.out.println("(6) 리스트의 첫번째 노드 삭제하기");
        list.deleteFirstNode();
        list.printList();

        System.out.println("(7) 리스트의 노드 검색하고 위치값 반환");
        System.out.println("목 : " +list.IndexOf("금"));

        System.out.println("(8) 리스트의 노드 검색하고 위치값 반환 만약 없으면?");
        System.out.println("토 : " +list.IndexOf("토"));

        System.out.println();
    }
}

